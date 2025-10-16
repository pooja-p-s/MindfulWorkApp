package com.poojaps.mindfulwork.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mood
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.poojaps.mindfulwork.Routes

@Composable
fun AppBottomBar(navController: NavController) {
    val currentRoute = navController.currentBackStackEntry?.destination?.route

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surfaceVariant
    ) {
        NavigationBarItem(
            selected = currentRoute == Routes.TIMER,
            onClick = {
                if (currentRoute != Routes.TIMER) navController.navigate(Routes.TIMER) {
                    popUpTo(Routes.HOME) { saveState = true }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            icon = { Icon(Icons.Default.Timer, contentDescription = "Focus") },
            label = { Text("Focus") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,        // active icon color
                unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant, // inactive icon color
                selectedTextColor = MaterialTheme.colorScheme.primary,
                unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                indicatorColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f) // subtle highlight
            )
        )

        NavigationBarItem(
            selected = currentRoute == Routes.MOOD,
            onClick = {
                if (currentRoute != Routes.MOOD) navController.navigate(Routes.MOOD) {
                    popUpTo(Routes.HOME) { saveState = true }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            icon = { Icon(Icons.Default.Mood, contentDescription = "Mood Tracking") },
            label = { Text("Mood") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                selectedTextColor = MaterialTheme.colorScheme.primary,
                unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                indicatorColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
            )
        )

        NavigationBarItem(
            selected = currentRoute == Routes.STATS,
            onClick = {
                if (currentRoute != Routes.STATS) navController.navigate(Routes.STATS) {
                    popUpTo(Routes.HOME) { saveState = true }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            icon = { Icon(Icons.Default.Star, contentDescription = "Stats") },
            label = { Text("Stats") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                selectedTextColor = MaterialTheme.colorScheme.primary,
                unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                indicatorColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
            )
        )
    }
}
