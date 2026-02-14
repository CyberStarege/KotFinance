package com.cyberstarege.kotfinance.feature.groups.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cyberstarege.kotfinance.core.designsystem.icon.KotFinanceIcons
import com.cyberstarege.kotfinance.core.designsystem.icon.SelectIcons
import com.cyberstarege.kotfinance.core.designsystem.theme.KotFinanceTheme
import com.cyberstarege.kotfinance.core.model.Account
import com.cyberstarege.kotfinance.core.model.AccountGroup
import com.cyberstarege.kotfinance.core.model.AccountType
import com.cyberstarege.kotfinance.core.model.GroupWithAccounts
import com.cyberstarege.kotfinance.feature.groups.GroupsUiState
import kotfinance.feature.groups.generated.resources.Res
import kotfinance.feature.groups.generated.resources.feature_groups
import kotfinance.feature.groups.generated.resources.feature_groups_accounts
import kotfinance.feature.groups.generated.resources.feature_groups_add_account
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.pluralStringResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun GroupsScreenContent(
    isDesktop: Boolean,
    uiState: GroupsUiState,
    onAddAccount: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        contentPadding = PaddingValues(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(Res.string.feature_groups),
                    style = if (isDesktop) MaterialTheme.typography.headlineMedium else MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }

        items(uiState.groupsWithAccounts) { groupWithAccounts ->
            GroupSection(
                group = groupWithAccounts.group,
                accounts = groupWithAccounts.accounts,
                onAddAccount = { onAddAccount(groupWithAccounts.group.id) },
                isDesktop = isDesktop
            )
        }
    }
}

@Composable
fun GroupSection(
    group: AccountGroup,
    accounts: List<Account>,
    onAddAccount: () -> Unit,
    isDesktop: Boolean,
    modifier: Modifier = Modifier
) {
    val icon = SelectIcons.entries.find { it.name == group.icon }?.icon
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                if (isDesktop) {
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .background(Color(group.color).copy(alpha = 0.2f), CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = if (icon != null) painterResource(icon) else KotFinanceIcons.AccountBalanceWallet,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp),
                            tint = Color(group.color)
                        )
                    }
                    Spacer(Modifier.width(12.dp))
                }
                Text(
                    text = group.name,
                    style = if (isDesktop) MaterialTheme.typography.titleMedium else MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.width(8.dp))
                Surface(
                    color = MaterialTheme.colorScheme.surfaceContainer,
                    shape = CircleShape
                ) {
                    Text(
                        text = pluralStringResource(Res.plurals.feature_groups_accounts, accounts.size, accounts.size),
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            TextButton(
                onClick = onAddAccount,
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Icon(KotFinanceIcons.Add, contentDescription = null, modifier = Modifier.size(16.dp))
                Spacer(Modifier.width(4.dp))
                Text(
                    text = stringResource(Res.string.feature_groups_add_account),
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }

        Spacer(Modifier.height(if (isDesktop) 12.dp else 24.dp))

        if (!isDesktop) {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                accounts.forEach { account ->
                    AccountCard(account = account, modifier = Modifier.fillMaxWidth())
                }
            }
        } else {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                items(accounts) { account ->
                    AccountCard(account = account)
                }
            }
        }
    }
}


@Preview(name = "Desktop", widthDp = 800)
@Preview(name = "Desktop Dark", uiMode = UI_MODE_NIGHT_YES, widthDp = 800)
@Composable
private fun GroupsScreenDesktopPreview() {
    KotFinanceTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            GroupsScreenContent(
                isDesktop = true,
                uiState = GroupsUiState(
                    groupsWithAccounts = listOf(
                        GroupWithAccounts(
                            group = AccountGroup(
                                id = 1,
                                name = "Карты",
                                color = 0xFF00A3FF.toInt()
                            ),
                            accounts = listOf(
                                Account(1, 1, "Карта 1", AccountType.DEBIT, 2400.0, 0xFFFFFFFF.toInt()),
                                Account(2, 1, "Карта 2", AccountType.DEBIT, 560.0, 0xFF1B1D4D.toInt())
                            )
                        ),
                        GroupWithAccounts(
                            group = AccountGroup(id = 2, name = "Крипта", color = 0xFFA352FF.toInt()),
                            accounts = listOf(
                                Account(3, 2, "Binance", AccountType.CRYPTO, 3150.0, 0xFF9C27B0.toInt())
                            )
                        )
                    )
                ),
                onAddAccount = { }
            )
        }
    }
}

@Preview(name = "Mobile", widthDp = 360)
@Preview(name = "Mobile Dark", uiMode = UI_MODE_NIGHT_YES, widthDp = 360)
@Composable
private fun GroupsScreenMobilePreview() {
    KotFinanceTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            GroupsScreenContent(
                isDesktop = false,
                uiState = GroupsUiState(
                    groupsWithAccounts = listOf(
                        GroupWithAccounts(
                            group = AccountGroup(
                                id = 1,
                                name = "Карты",
                                color = 0xFF00A3FF.toInt()
                            ),
                            accounts = listOf(
                                Account(1, 1, "Карта 1", AccountType.DEBIT, 2400.0, 0xFFFFFFFF.toInt()),
                                Account(2, 1, "Карта 2", AccountType.DEBIT, 560.0, 0xFF1B1D4D.toInt())
                            )
                        ),
                        GroupWithAccounts(
                            group = AccountGroup(id = 2, name = "Крипта", color = 0xFFA352FF.toInt()),
                            accounts = listOf(
                                Account(3, 2, "Binance", AccountType.CRYPTO, 3150.0, 0xFF9C27B0.toInt())
                            )
                        )
                    )
                ),
                onAddAccount = { }
            )
        }
    }
}