package com.cyberstarege.kotfinance.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import androidx.window.core.layout.WindowSizeClass
import com.cyberstarege.kotfinance.feature.groups.GroupsScreen

@Composable
fun AppNavigation(
    windowSizeClass: WindowSizeClass,
    navBackStack: NavBackStack<NavKey>,
    modifier: Modifier = Modifier
) {
    NavDisplay(
        backStack = navBackStack,
        onBack = { navBackStack.removeLastOrNull() },
        entryProvider = entryProvider {
            appEntry(windowSizeClass = windowSizeClass)
        },
        modifier = modifier
    )
}


fun EntryProviderScope<NavKey>.appEntry(windowSizeClass: WindowSizeClass) {
    entry<Route.Home> {
        Text("Главный экран")
    }
    entry<Route.Analytics> {
        Text("Аналитика")
    }
    entry<Route.GroupsAccount> {
        GroupsScreen(windowSizeClass = windowSizeClass)
    }
    entry<Route.Settings> {
        Text("Настройки")
    }
}
