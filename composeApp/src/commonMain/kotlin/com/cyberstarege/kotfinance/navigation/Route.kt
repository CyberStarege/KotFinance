package com.cyberstarege.kotfinance.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed class Route: NavKey {
    @Serializable
    data object Home: Route()

    @Serializable
    data object Analytics: Route()

    @Serializable
    data object GroupsAccount: Route()

    @Serializable
    data object Settings: Route()
}