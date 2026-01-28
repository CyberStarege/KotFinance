package com.cyberstarege.kotfinance.core.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme =
    darkColorScheme(
        primary = PrimaryDarkMode,
        onPrimary = OnPrimaryDarkMode,
        secondaryContainer = SecondaryContainerDarkMode,
        onSecondaryContainer = OnSecondaryContainerDarkMode,
        background = BackgroundDarkMode,
        surface = SurfaceDarkMode,
        onSurface = OnSurfaceDarkMode,
        onSurfaceVariant = OnSurfaceVariantDarkMode,
        onBackground = OnBackgroundDarkMode,
        surfaceContainer = SurfaceContainer,
    )

private val LightColorScheme =
    lightColorScheme(
        primary = Purple40,
        secondary = PurpleGrey40,
        tertiary = Pink40
        /* Other default colors to override
        background = Color(0xFFFFFBFE),
        surface = Color(0xFFFFFBFE),
        onPrimary = Color.White,
        onSecondary = Color.White,
        onTertiary = Color.White,
        onBackground = Color(0xFF1C1B1F),
        onSurface = Color(0xFF1C1B1F),
         */
    )

internal expect fun isPlatformWithDynamicSystemTheme(): Boolean

@Composable
internal expect fun dynamicColorScheme(darkTheme: Boolean): ColorScheme

@Composable
fun KotFinanceTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme: ColorScheme =
        when {
            isPlatformWithDynamicSystemTheme() && dynamicColor -> dynamicColorScheme(darkTheme)
            darkTheme -> DarkColorScheme
            else -> LightColorScheme
        }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )

}

