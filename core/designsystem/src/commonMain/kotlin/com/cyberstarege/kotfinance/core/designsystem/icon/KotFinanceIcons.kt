package com.cyberstarege.kotfinance.core.designsystem.icon

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import kotfinance.core.designsystem.generated.resources.Res
import kotfinance.core.designsystem.generated.resources.ic_account_balance_wallet_24px
import kotfinance.core.designsystem.generated.resources.ic_edit_24px
import kotfinance.core.designsystem.generated.resources.ic_add_24px
import kotfinance.core.designsystem.generated.resources.ic_analytics_24px
import kotfinance.core.designsystem.generated.resources.ic_close_24px
import kotfinance.core.designsystem.generated.resources.ic_coffee_24px
import kotfinance.core.designsystem.generated.resources.ic_credit_card_24px
import kotfinance.core.designsystem.generated.resources.ic_currency_bitcoin_24px
import kotfinance.core.designsystem.generated.resources.ic_currency_ruble_24px
import kotfinance.core.designsystem.generated.resources.ic_directions_car_24px
import kotfinance.core.designsystem.generated.resources.ic_fitness_center_24px
import kotfinance.core.designsystem.generated.resources.ic_fork_spoon_24px
import kotfinance.core.designsystem.generated.resources.ic_grocery_24px
import kotfinance.core.designsystem.generated.resources.ic_home_24px
import kotfinance.core.designsystem.generated.resources.ic_menu_24px
import kotfinance.core.designsystem.generated.resources.ic_mobile_24px
import kotfinance.core.designsystem.generated.resources.ic_settings_24px
import kotfinance.core.designsystem.generated.resources.ic_more_vert_24px
import kotfinance.core.designsystem.generated.resources.ic_redeem_24px
import kotfinance.core.designsystem.generated.resources.ic_school_24px
import org.jetbrains.compose.resources.painterResource

object KotFinanceIcons {
    val Edit: Painter
        @Composable
        get() = painterResource(Res.drawable.ic_edit_24px)

    val Add: Painter
        @Composable
        get() = painterResource(Res.drawable.ic_add_24px)

    val Home: Painter
        @Composable
        get() = painterResource(Res.drawable.ic_home_24px)

    val AccountBalanceWallet: Painter
        @Composable
        get() = painterResource(Res.drawable.ic_account_balance_wallet_24px)

    val Settings: Painter
        @Composable
        get() = painterResource(Res.drawable.ic_settings_24px)

    val Menu: Painter
        @Composable
        get() = painterResource(Res.drawable.ic_menu_24px)

    val Analytics: Painter
        @Composable
        get() = painterResource(Res.drawable.ic_analytics_24px)

    val MoreVert: Painter
        @Composable
        get() = painterResource(Res.drawable.ic_more_vert_24px)

    val Close: Painter
        @Composable
        get() = painterResource(Res.drawable.ic_close_24px)


}