package com.poojaps.mindfulwork.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.CountDownTimer
import android.os.IBinder
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.poojaps.mindfulwork.R
import com.poojaps.mindfulwork.domain.usecase.SaveFocusSessionUseCase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class FocusTimerService : Service() {

    @Inject lateinit var saveSessionUseCase: SaveFocusSessionUseCase

    private var totalTime = 0
    private var timeLeft = 0
    private var isRunning = false
    private var timer: CountDownTimer? = null

    private val channelId = "focus_timer_channel"
    private val notificationId = 1

    override fun onBind(intent: Intent?): IBinder? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // Ensure Hilt injection before usage
        if (!::saveSessionUseCase.isInitialized) {
            stopSelf()
            return START_NOT_STICKY
        }

        when (intent?.action) {
            FocusTimerActions.ACTION_START ->
                startTimer(intent.getIntExtra(FocusTimerActions.EXTRA_TOTAL_TIME, 0))
            FocusTimerActions.ACTION_PAUSE -> pauseTimer()
            FocusTimerActions.ACTION_RESUME -> resumeTimer()
            FocusTimerActions.ACTION_END -> endSession()
        }
        return START_STICKY
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "Focus Timer",
                NotificationManager.IMPORTANCE_LOW
            )
            getSystemService(NotificationManager::class.java)
                .createNotificationChannel(channel)
        }
    }

    private fun buildNotification(text: String): Notification {
        return NotificationCompat.Builder(this, channelId)
            .setContentTitle("Focus Timer")
            .setContentText(text)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setOngoing(true)
            .setOnlyAlertOnce(true)
            .build()
    }

    private fun updateNotification(text: String) {
        val manager = getSystemService(NotificationManager::class.java)
        manager.notify(notificationId, buildNotification(text))
    }

    private fun startTimer(totalSeconds: Int) {
        totalTime = totalSeconds
        timeLeft = totalSeconds
        isRunning = true
        createNotificationChannel()

        startForeground(notificationId, buildNotification("Focusing..."))

        timer?.cancel()
        timer = object : CountDownTimer(totalSeconds * 1000L, 1000L) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeft = (millisUntilFinished / 1000L).toInt()
                sendUpdate()
                updateNotification("Time left: ${timeLeft / 60}m ${timeLeft % 60}s")
            }

            @RequiresApi(Build.VERSION_CODES.O)
            override fun onFinish() {
                endSession()
            }
        }.start()
    }

    private fun pauseTimer() {
        timer?.cancel()
        isRunning = false
        updateNotification("Paused")
        sendUpdate()
    }

    private fun resumeTimer() {
        isRunning = true
        startForeground(notificationId, buildNotification("Resumed"))
        timer?.cancel()
        timer = object : CountDownTimer(timeLeft * 1000L, 1000L) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeft = (millisUntilFinished / 1000L).toInt()
                sendUpdate()
                updateNotification("Time left: ${timeLeft / 60}m ${timeLeft % 60}s")
            }

            @RequiresApi(Build.VERSION_CODES.O)
            override fun onFinish() {
                endSession()
            }
        }.start()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun endSession() {
        timer?.cancel()
        val focusedTime = totalTime - timeLeft
        isRunning = false

        CoroutineScope(Dispatchers.IO).launch {
            saveSessionUseCase(totalTime, focusedTime)
        }

        sendUpdate(reset = false)

        CoroutineScope(Dispatchers.IO).launch {
            delay(1000)
            sendUpdate(reset = true)
            stopForeground(true)
            stopSelf()
        }
    }

    private fun sendUpdate(reset: Boolean = false) {
        val intent = Intent(FocusTimerActions.ACTION_UPDATE).apply {
            putExtra(FocusTimerActions.EXTRA_TOTAL_TIME, if (reset) 0 else totalTime)
            putExtra(FocusTimerActions.EXTRA_TIME_LEFT, if (reset) 0 else timeLeft)
            putExtra(FocusTimerActions.EXTRA_IS_RUNNING, if (reset) false else isRunning)
        }
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
    }

    override fun onDestroy() {
        timer?.cancel()
        super.onDestroy()
    }
}
