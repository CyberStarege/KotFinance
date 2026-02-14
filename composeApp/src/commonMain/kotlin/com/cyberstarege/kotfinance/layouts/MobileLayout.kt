package com.cyberstarege.kotfinance.layouts

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.window.core.layout.WindowSizeClass
import com.cyberstarege.kotfinance.navigation.AppBottomBarNavigation
import com.cyberstarege.kotfinance.navigation.AppNavigation

@Composable
fun MobileLayout(
    windowSizeClass: WindowSizeClass,
    navBackStack: NavBackStack<NavKey>,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        bottomBar = {
            AppBottomBarNavigation(
                currentKey = navBackStack.lastOrNull(),
                onNavigate = { navKey -> navBackStack.add(navKey) }
            )
        }
    ) { contentPadding ->
        AppNavigation(
            windowSizeClass = windowSizeClass,
            navBackStack = navBackStack,
            modifier = Modifier.padding(contentPadding)
        )
    }

}