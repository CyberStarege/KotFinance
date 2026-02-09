package com.cyberstarege.kotfinance.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.runtime.NavKey
import com.cyberstarege.kotfinance.core.designsystem.theme.KotFinanceTheme
import org.jetbrains.compose.resources.stringResource

@Composable
fun AppBottomBarNavigation(
    currentKey: NavKey?,
    onNavigate: (NavKey) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier,
    ) {
        navigationItems.forEach { navigationItem ->
            val selected = currentKey == navigationItem.navKey
            val selectedIconColor = MaterialTheme.colorScheme.primary
            val unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant
            val selectedTextColor = MaterialTheme.colorScheme.primary
            val unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
            val indicatorColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)

            NavigationBarItem(
                selected = selected,
                onClick = { onNavigate(navigationItem.navKey) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = selectedIconColor,
                    unselectedIconColor = unselectedIconColor,
                    selectedTextColor = selectedTextColor,
                    unselectedTextColor = unselectedTextColor,
                    indicatorColor = indicatorColor
                ),
                icon = {
                    Icon(
                        painter = navigationItem.icon(),
                        contentDescription = stringResource(navigationItem.title)
                    )
                },
                label = {
                    Text(
                        text = stringResource(navigationItem.title),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.labelMedium
                    )
                },
                alwaysShowLabel = true
            )
        }
    }
}

@Preview
@Composable
private fun AppBottomBarPreview() {
    KotFinanceTheme(darkTheme = true) {
        AppBottomBarNavigation(
            currentKey = Route.Home,
            onNavigate = {}
        )
    }
}