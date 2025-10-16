package com.poojaps.mindfulwork.ui.theme


import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView

// -------------------- Light Theme --------------------
private val CustomLightColorScheme = lightColorScheme(
    primary = Color(0xFF6B5CA5),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFE8E0FF),
    onPrimaryContainer = Color(0xFF1D0F4B),

    secondary = Color(0xFF7C6992),
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFE8DDFF),
    onSecondaryContainer = Color(0xFF2C1B3F),

    tertiary = Color(0xFF8B4C54),
    onTertiary = Color.White,
    tertiaryContainer = Color(0xFFFFDAD7),
    onTertiaryContainer = Color(0xFF400013),

    error = Color(0xFF9B4C4C),
    onError = Color.White,
    errorContainer = Color(0xFFFFDAD6),
    onErrorContainer = Color(0xFF410002),

    background = Color(0xFFFAF8FF),
    onBackground = Color(0xFF1D1B20),

    surface = Color(0xFFFFFBFF),
    onSurface = Color(0xFF1D1B20),

    surfaceVariant = Color(0xFFE6E0EC),
    onSurfaceVariant = Color(0xFF49454F),

    outline = Color(0xFF7A757F),
    outlineVariant = Color(0xFFCBC4CF)
)

private val CustomDarkColorScheme = darkColorScheme(
    primary = Color(0xFFBDAAFF),          // gentle lavender accent
    onPrimary = Color(0xFF2A1E5F),
    primaryContainer = Color(0xFF3D316F),
    onPrimaryContainer = Color(0xFFE9DEFF),

    secondary = Color(0xFFB5A5D8),        // subtle lilac-gray tone
    onSecondary = Color(0xFF241E3A),
    secondaryContainer = Color(0xFF372E53),
    onSecondaryContainer = Color(0xFFE6DFFF),

    tertiary = Color(0xFF9FB4FF),         // cool periwinkle blue highlight
    onTertiary = Color(0xFF001B3F),
    tertiaryContainer = Color(0xFF263C6A),
    onTertiaryContainer = Color(0xFFDDE1FF),

    background = Color(0xFF121016),       // deep neutral-violet base
    onBackground = Color(0xFFE6E1EC),

    surface = Color(0xFF1A1822),          // slightly raised surface
    onSurface = Color(0xFFE9E2F1),

    surfaceVariant = Color(0xFF403A4E),
    onSurfaceVariant = Color(0xFFC8C2D4),

    outline = Color(0xFF8C8794),
    outlineVariant = Color(0xFF4D4759),

    inverseSurface = Color(0xFFE6E1EE),
    inverseOnSurface = Color(0xFF1D1A24),
    inversePrimary = Color(0xFF6C5BB7)
)

@Composable
fun MindfulworkTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            if (darkTheme) CustomDarkColorScheme else CustomLightColorScheme
        }
        darkTheme -> darkColorScheme()
        else -> lightColorScheme()
    }


    MaterialTheme(
        colorScheme = colorScheme,
        typography = BoldTypography,
        content = content
    )
}
