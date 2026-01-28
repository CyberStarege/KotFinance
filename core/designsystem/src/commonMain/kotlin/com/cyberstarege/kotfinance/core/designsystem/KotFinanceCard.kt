package com.cyberstarege.kotfinance.core.designsystem

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cyberstarege.kotfinance.core.designsystem.theme.KotFinanceTheme

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun KotFinanceCard(
    shape: Shape = MaterialTheme.shapes.extraExtraLarge,
    colors: CardColors = CardDefaults.cardColors(
        containerColor = MaterialTheme.colorScheme.surfaceContainer,
        contentColor = MaterialTheme.colorScheme.onSurface
    ),
    modifier: Modifier = Modifier,
    content: @Composable (ColumnScope.() -> Unit)
) {
    Card(
        modifier = modifier,
        shape = shape,
        colors = colors,
        content = content
    )
}

@Preview(name = "Light mode")
@Preview(name = "Night mode", uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun KotFinanceCardPreview() {
    KotFinanceTheme {
        KotFinanceCard() {
            Box(modifier = Modifier.padding(16.dp)) {
                Text("This is Card")
            }
        }
    }
}