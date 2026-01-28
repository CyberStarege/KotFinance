package com.cyberstarege.kotfinance.core.designsystem.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable

internal actual fun isPlatformWithDynamicSystemTheme(): Boolean = false

@Composable
internal actual fun dynamicColorScheme(darkTheme: Boolean): ColorScheme {
    error("Dynamic theming isn't supported")
}