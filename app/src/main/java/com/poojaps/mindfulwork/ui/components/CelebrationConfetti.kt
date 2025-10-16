package com.poojaps.mindfulwork.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.cos
import kotlin.math.sin
import kotlin.random.Random

@Composable
fun CelebrationConfetti(
    visible: Boolean,
    modifier: Modifier = Modifier,
    colors: List<Color> = listOf(
        Color(0xFFFFD54F),
        Color(0xFF64B5F6),
        Color(0xFFFF8A65),
        Color(0xFF81C784),
        Color(0xFFF06292)
    )
) {
    if (!visible) return

    val confettiCount = 40
    val random = remember { Random(System.currentTimeMillis()) }

    val confettiList = remember {
        List(confettiCount) {
            ConfettiParticle(
                color = colors[it % colors.size],
                angle = random.nextDouble(0.0, 360.0),
                speed = random.nextDouble(150.0, 400.0)
            )
        }
    }

    val scope = rememberCoroutineScope()

    LaunchedEffect(visible) {
        if (visible) {
            confettiList.forEach { particle ->
                scope.launch {
                    launch {
                        particle.progress.animateTo(
                            targetValue = 1f,
                            animationSpec = tween(2000, easing = LinearEasing)
                        )
                    }
                    launch {
                        particle.alpha.animateTo(
                            targetValue = 0f,
                            animationSpec = tween(2000, easing = LinearEasing)
                        )
                    }
                }
            }

            delay(2200)
            confettiList.forEach {
                it.progress.snapTo(0f)
                it.alpha.snapTo(0f)
            }
        }
    }

    Canvas(modifier = modifier) {
        val center = Offset(size.width / 2f, size.height / 2f)

        confettiList.forEach { particle ->
            val distance = (particle.speed * particle.progress.value).toFloat()
            val angleRad = Math.toRadians(particle.angle).toFloat()

            val x = center.x + distance * cos(angleRad)
            val y = center.y + distance * sin(angleRad)

            drawCircle(
                color = particle.color.copy(alpha = particle.alpha.value),
                radius = 6f,
                center = Offset(x, y)
            )
        }
    }
}

private data class ConfettiParticle(
    val color: Color,
    val angle: Double,
    val speed: Double,
    val progress: Animatable<Float, *> = Animatable(0f),
    val alpha: Animatable<Float, *> = Animatable(1f)
)
