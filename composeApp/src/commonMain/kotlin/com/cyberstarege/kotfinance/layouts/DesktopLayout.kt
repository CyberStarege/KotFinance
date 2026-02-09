package com.cyberstarege.kotfinance.layouts

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.cyberstarege.kotfinance.navigation.AppNavigation
import com.cyberstarege.kotfinance.navigation.AppNavigationRail

@Composable
fun DesktopLayout(
    navBackStack: NavBackStack<NavKey>,
    modifier: Modifier = Modifier
) {
    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        Row(
            modifier = modifier.fillMaxSize()
        ) {
            AppNavigationRail(
                modifier = Modifier.width(255.dp),
                currentKey = navBackStack.lastOrNull(),
                onNavigate = { navKey -> navBackStack.add(navKey) }
            )
            AppNavigation(navBackStack)
        }
    }

}