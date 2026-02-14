package com.cyberstarege.kotfinance.feature.groups.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cyberstarege.kotfinance.core.designsystem.component.KotFinanceCard
import com.cyberstarege.kotfinance.core.designsystem.icon.KotFinanceIcons
import com.cyberstarege.kotfinance.core.designsystem.theme.KotFinanceTheme
import com.cyberstarege.kotfinance.core.model.Account
import com.cyberstarege.kotfinance.core.model.AccountType

@Composable
fun AccountCard(
    account: Account,
    modifier: Modifier = Modifier
) {
    KotFinanceCard(
        modifier = modifier.width(280.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(Color(account.color).copy(alpha = 0.2f), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                   Text(
                       text = account.name.take(2).uppercase(),
                       color = Color(account.color),
                       fontWeight = FontWeight.Bold,
                       fontSize = 12.sp
                   )
                }
                Spacer(Modifier.weight(1f))
                IconButton(onClick = {}) {
                    Icon(
                        painter = KotFinanceIcons.MoreVert,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
            Spacer(Modifier.height(16.dp))
            Text(
                text = account.name,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(16.dp))
            Text(
                text = "${account.currentBalance}",
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Preview(name = "Light mode")
@Preview(name = "Night mode", uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun AccountCardPreview() {
    KotFinanceTheme {
        AccountCard(
            account = Account(
                id = 123456789L,
                accountGroupId = 1L,
                name = "Основной счёт",
                accountType = AccountType.DEBIT,
                currentBalance = 2450.75,
                color = 0xFF00E3D9.toInt()
            )
        )
    }
}
