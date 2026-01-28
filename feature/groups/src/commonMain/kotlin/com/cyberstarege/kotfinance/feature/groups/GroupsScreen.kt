package com.cyberstarege.kotfinance.feature.groups

import androidx.compose.runtime.Composable
import com.cyberstarege.kotfinance.core.model.AccountGroup
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun GroupsScreen() {
    val groupsViewModel = koinViewModel<GroupsViewModel>()
}

@Composable
fun AccountGroupItem(
    accountGroup: AccountGroup,
) {

}