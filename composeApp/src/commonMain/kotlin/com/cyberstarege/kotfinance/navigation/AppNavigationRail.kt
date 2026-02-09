package com.cyberstarege.kotfinance.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavKey
import com.cyberstarege.kotfinance.core.designsystem.theme.KotFinanceTheme
import org.jetbrains.compose.resources.stringResource


@Composable
fun AppNavigationRail(
    currentKey: NavKey?,
    onNavigate: (NavKey) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationRail(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.secondaryContainer
    ) {
        navigationItems.forEach { navigationItem ->
            val selected = currentKey == navigationItem.navKey
            val selectedIconColor = MaterialTheme.colorScheme.primary
            val unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant
            val selectedTextColor = MaterialTheme.colorScheme.primary
            val unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
            val indicatorColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
            NavigationRailItem(
                modifier = Modifier.clip(MaterialTheme.shapes.extraLarge),
                selected = selected,
                onClick = { onNavigate(navigationItem.navKey) },
                colors = NavigationRailItemDefaults.colors(
                    selectedIconColor = selectedIconColor,
                    unselectedIconColor = unselectedIconColor,
                    selectedTextColor = selectedTextColor,
                    unselectedTextColor = unselectedTextColor,
                    indicatorColor = indicatorColor
                ),
                icon = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Icon(
                            painter = navigationItem.icon(),
                            contentDescription = stringResource(navigationItem.title)
                        )
                        Spacer(Modifier.width(12.dp))
                        Text(
                            text = stringResource(navigationItem.title),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.labelLarge
                        )
                    }
                }
            )
        }
    }
}

@Preview
@Composable
private fun AppNavigationRailPreview() {
    KotFinanceTheme(darkTheme = true) {
        AppNavigationRail(
            currentKey = Route.Home,
            onNavigate = {},
            modifier = Modifier.width(255.dp)
        )
    }
}
