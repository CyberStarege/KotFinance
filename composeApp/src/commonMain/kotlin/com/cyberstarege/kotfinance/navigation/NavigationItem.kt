package com.cyberstarege.kotfinance.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.navigation3.runtime.NavKey
import com.cyberstarege.kotfinance.core.designsystem.icon.KotFinanceIcons
import kotfinance.composeapp.generated.resources.Res
import kotfinance.composeapp.generated.resources.analytics
import kotfinance.composeapp.generated.resources.groups_account
import kotfinance.composeapp.generated.resources.main
import kotfinance.composeapp.generated.resources.settings
import org.jetbrains.compose.resources.StringResource


sealed class NavigationItem(
    val navKey: NavKey,
    val title: StringResource,
    val icon: @Composable (() -> Painter)
) {
    data object Home: NavigationItem(
        navKey = Route.Home,
        title = Res.string.main,
        icon = { KotFinanceIcons.Home }
    )
    data object Analytics: NavigationItem(
        navKey = Route.Analytics,
        title = Res.string.analytics,
        icon = { KotFinanceIcons.Analytics }
    )
    data object GroupsAccount: NavigationItem(
        navKey = Route.GroupsAccount,
        title = Res.string.groups_account,
        icon = { KotFinanceIcons.AccountBalanceWallet }
    )
    data object Settings: NavigationItem(
        navKey = Route.Settings,
        title = Res.string.settings,
        icon = { KotFinanceIcons.Settings }
    )
}

val navigationItems = listOf(
    NavigationItem.Home,
    NavigationItem.Analytics,
    NavigationItem.GroupsAccount,
    NavigationItem.Settings
)
