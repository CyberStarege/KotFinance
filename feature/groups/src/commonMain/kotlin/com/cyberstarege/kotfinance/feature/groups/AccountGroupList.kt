package com.cyberstarege.kotfinance.feature.groups

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cyberstarege.kotfinance.core.designsystem.theme.KotFinanceTheme
import com.cyberstarege.kotfinance.core.model.AccountGroup

@Composable
fun AccountGroupList(
    accountGroups: List<AccountGroup>,
    onEdit: () -> Unit,
    onNavigateToAccountGroup: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(accountGroups) { accountGroup ->
            AccountGroupCard(
                name = accountGroup.name,
                description = accountGroup.description ?: "",
                onEdit = onEdit,
                onClick = onNavigateToAccountGroup,
                color = Color(accountGroup.color)
            )
        }
    }
}

@Preview(name = "Light mode")
@Preview(name = "Night mode", uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun AccountGroupListPreview() {
    KotFinanceTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            AccountGroupList(
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
                onEdit = {  },
                onNavigateToAccountGroup = { }
            )
        }
    }
}
