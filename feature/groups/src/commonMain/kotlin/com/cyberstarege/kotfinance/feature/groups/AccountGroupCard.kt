package com.cyberstarege.kotfinance.feature.groups

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cyberstarege.kotfinance.core.designsystem.component.KotFinanceCard
import com.cyberstarege.kotfinance.core.designsystem.icon.KotFinanceIcons
import com.cyberstarege.kotfinance.core.designsystem.theme.KotFinanceTheme
import org.jetbrains.compose.resources.painterResource

@Composable
fun AccountGroupCard(
    name: String,
    description: String,
    onEdit: () -> Unit,
    onClick: () -> Unit,
    color: Color,
    modifier: Modifier = Modifier,
    icon: Painter? = null
) {
    KotFinanceCard(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() },
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(
                        color = color.copy(alpha = 0.2f),
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                if (icon != null) {
                    Icon(
                        painter = icon,
                        contentDescription = name,
                        tint = color,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            IconButton(onClick = onEdit) {
                Icon(
                    painter = KotFinanceIcons.Edit,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Preview(name = "Light mode")
@Preview(name = "Night mode", uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun AccountGroupCardPreview() {
    KotFinanceTheme {
        Box(modifier = Modifier.background(MaterialTheme.colorScheme.background).padding(vertical = 16.dp)) {
            AccountGroupCard(
                name = "Общий счёт",
                description = "Накопительный, наличка и т.д",
                onEdit = {},
                onClick = {},
                color = Color(0xFF00E3D9)
            )
        }
    }
}
