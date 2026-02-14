package com.cyberstarege.kotfinance.feature.groups.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cyberstarege.kotfinance.core.designsystem.icon.KotFinanceIcons
import com.cyberstarege.kotfinance.core.designsystem.theme.KotFinanceTheme
import kotfinance.feature.groups.generated.resources.Res
import kotfinance.feature.groups.generated.resources.feature_groups_create_group
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun CreateGroupButton(
    isDesktop: Boolean,
    onCreateGroup: () -> Unit,
    modifier: Modifier = Modifier
) {
    FloatingActionButton(
        containerColor = MaterialTheme.colorScheme.primary,
        shape = MaterialTheme.shapes.extraExtraLarge,
        onClick = onCreateGroup,
        modifier = modifier
    ) {
        if (isDesktop) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Icon(
                    painter = KotFinanceIcons.Add,
                    contentDescription = stringResource(Res.string.feature_groups_create_group),
                    tint = MaterialTheme.colorScheme.onPrimary
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    text = stringResource(Res.string.feature_groups_create_group),
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontWeight = FontWeight.Medium
                )
            }
        } else {
            Icon(
                painter = KotFinanceIcons.Add,
                contentDescription = stringResource(Res.string.feature_groups_create_group),
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@Preview(name = "Mobile Light", showBackground = true)
@Preview(
    name = "Mobile Dark",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
private fun CreateGroupButtonMobilePreview() {
    KotFinanceTheme {
        Box(modifier = Modifier.padding(16.dp)) {
            CreateGroupButton(
                isDesktop = false,
                onCreateGroup = {}
            )
        }
    }
}

@Preview(name = "Desktop Light", showBackground = true)
@Preview(
    name = "Desktop Dark",
    showBackground = true,
    backgroundColor = 0xFF14161C,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
private fun CreateGroupButtonDesktopPreview() {
    KotFinanceTheme {
        Box(modifier = Modifier.padding(16.dp)) {
            CreateGroupButton(
                isDesktop = true,
                onCreateGroup = {}
            )
        }
    }
}