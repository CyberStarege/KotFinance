package com.cyberstarege.kotfinance

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.savedstate.serialization.SavedStateConfiguration
import androidx.window.core.layout.WindowSizeClass
import com.cyberstarege.kotfinance.core.designsystem.theme.KotFinanceTheme
import com.cyberstarege.kotfinance.layouts.DesktopLayout
import com.cyberstarege.kotfinance.layouts.MobileLayout
import com.cyberstarege.kotfinance.navigation.Route
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

@Composable
@Preview
fun App(
    windowSizeClass: WindowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
) {
    val navBackStack = rememberNavBackStack(config, Route.Home)
    KotFinanceTheme {
        BoxWithConstraints {
            if (maxWidth > 600.dp) {
                DesktopLayout(navBackStack = navBackStack)
            } else {
                MobileLayout(navBackStack = navBackStack)
            }
        }
    }

}

private val config = SavedStateConfiguration {
    serializersModule = SerializersModule {
        polymorphic(NavKey::class) {
            subclass(Route.Home::class, Route.Home.serializer())
            subclass(Route.Analytics::class, Route.Analytics.serializer())
            subclass(Route.GroupsAccount::class, Route.GroupsAccount.serializer())
            subclass(Route.Settings::class, Route.Settings.serializer())
        }
    }
}