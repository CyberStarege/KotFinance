package com.cyberstarege.kotfinance.feature.groups

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cyberstarege.kotfinance.core.designsystem.icon.KotFinanceIcons
import com.cyberstarege.kotfinance.core.designsystem.theme.KotFinanceTheme
import com.cyberstarege.kotfinance.core.model.AccountGroup
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun GroupsScreen() {
    val groupsViewModel = koinViewModel<GroupsViewModel>()
    val accountGroups by groupsViewModel.accountGroups.collectAsState()
    GroupsScreen(
        accountGroups = accountGroups,
        onEdit = { },
        onCreate = {
            groupsViewModel.addGroup(
                AccountGroup(
                    name = "Новый кошелёк",
                    description = "Описание",
                    color = 0xFF4CAF50.toInt()
                )
            )
        },
        onNavigateToAccountGroup = { }
    )
}

@Composable
fun GroupsScreen(
    accountGroups: List<AccountGroup>,
    onEdit: () -> Unit,
    onCreate: () -> Unit,
    onNavigateToAccountGroup: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        AccountGroupList(
            accountGroups = accountGroups,
            onEdit = onEdit,
            onNavigateToAccountGroup = onNavigateToAccountGroup
        )
        FloatingActionButton(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            onClick = onCreate,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 16.dp, bottom = 16.dp)
        ) {
            Icon(
                painter = KotFinanceIcons.Add,
                contentDescription = null
            )
        }
    }
}

@Preview(name = "Light mode")
@Preview(name = "Night mode", uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun GroupsScreenPreview() {
    KotFinanceTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            GroupsScreen(
                accountGroups = listOf(
                    AccountGroup(
                        id = 1,
                        name = "Кошелек",
                        description = "Наличка, карта, накопительный счёт и т.д",
                        color = 0xFF4CAF50.toInt()
                    ),
                    AccountGroup(
                        id = 2,
                        name = "Инвестиции",
                        description = "Т-Инвестиции, А-Инвестиции и т.д",
                        color = 0xFF2196F3.toInt()
                    ),
                    AccountGroup(
                        id = 3,
                        name = "Крипта",
                        description = "Bybit",
                        color = 0xFFFFC107.toInt()
                    )
                ),
                onEdit = { },
                onCreate = { },
                onNavigateToAccountGroup = { }
            )
        }
    }
}