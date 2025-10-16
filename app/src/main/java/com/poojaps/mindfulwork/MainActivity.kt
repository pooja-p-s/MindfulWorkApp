package com.poojaps.mindfulwork

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Mood
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.poojaps.mindfulwork.ui.screens.FocusTimerScreen
import com.poojaps.mindfulwork.ui.screens.HomeDashboardScreen
import com.poojaps.mindfulwork.ui.screens.MoodTrackerScreen
import com.poojaps.mindfulwork.ui.screens.SettingsScreen
import com.poojaps.mindfulwork.ui.screens.SplashScreen
import com.poojaps.mindfulwork.ui.screens.StatsScreen
import com.poojaps.mindfulwork.ui.theme.MindfulworkTheme
import com.poojaps.mindfulwork.viewmodel.SettingsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Request notification permission for Android 13+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                    1001
                )
            }
        }

        setContent {
            MindfulworkTheme {
                val navController = rememberNavController()
                val backStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = backStackEntry?.destination?.route

                val bottomBarRoutes = setOf(
                    Routes.HOME,
                    Routes.TIMER,
                    Routes.MOOD,
                    Routes.STATS
                )

                Scaffold(
                    bottomBar = {
                        if (currentRoute in bottomBarRoutes) {
                            NavigationBar {
                                NavigationBarItem(
                                    selected = currentRoute == Routes.HOME,
                                    onClick = {
                                        navController.navigate(Routes.HOME) {
                                            popUpTo(navController.graph.findStartDestination().id) {
                                                saveState = true
                                            }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    },
                                    icon = { Icon(Icons.Default.Home, contentDescription = null) },
                                    label = { Text("Home") }
                                )
                                NavigationBarItem(
                                    selected = currentRoute == Routes.TIMER,
                                    onClick = {
                                        navController.navigate(Routes.TIMER) {
                                            popUpTo(navController.graph.findStartDestination().id) {
                                                saveState = true
                                            }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    },
                                    icon = { Icon(Icons.Default.Timer, contentDescription = null) },
                                    label = { Text("Focus") }
                                )
                                NavigationBarItem(
                                    selected = currentRoute == Routes.MOOD,
                                    onClick = {
                                        navController.navigate(Routes.MOOD) {
                                            popUpTo(navController.graph.findStartDestination().id) {
                                                saveState = true
                                            }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    },
                                    icon = { Icon(Icons.Default.Mood, contentDescription = null) },
                                    label = { Text("Mood") }
                                )
                                NavigationBarItem(
                                    selected = currentRoute == Routes.STATS,
                                    onClick = {
                                        navController.navigate(Routes.STATS) {
                                            popUpTo(navController.graph.findStartDestination().id) {
                                                saveState = true
                                            }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    },
                                    icon = { Icon(Icons.Default.Star, contentDescription = null) },
                                    label = { Text("Stats") }
                                )
                            }
                        }
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "splash",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("splash") { SplashScreen(navController) }

                        composable(Routes.HOME) {
                            val settingsViewModel: SettingsViewModel = hiltViewModel()
                            HomeDashboardScreen(
                                onSettingsClick = { navController.navigate(Routes.SETTINGS) },
                                settingsViewModel = settingsViewModel
                            )
                        }

                        composable(Routes.TIMER) { FocusTimerScreen() }
                        composable(Routes.MOOD) { MoodTrackerScreen() }
                        composable(Routes.STATS) { StatsScreen() }

                        composable(Routes.SETTINGS) {
                            val settingsViewModel: SettingsViewModel = hiltViewModel()
                            SettingsScreen(
                                viewModel = settingsViewModel,
                                onBackClick = { navController.popBackStack() }
                            )
                        }
                    }
                }
            }
        }
    }
}
