package com.cyberstarege.kotfinance.core.designsystem

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun KotFinanceCard(
    shape: Shape = RoundedCornerShape(24.dp),
    colors: CardColors = CardDefaults.cardColors(
        containerColor = Color(0xFF1D2931),
    ),
    border: BorderStroke = BorderStroke(1.dp, Color(0xFF1E293B)),
    modifier: Modifier = Modifier,
    content: @Composable (ColumnScope.() -> Unit)
) {
    Card(
        modifier = modifier,
        shape = shape,
        colors = colors,
        border = border,
        content = content
    )
}

@Preview()
@Composable
private fun KotFinanceCardPreview() {
    KotFinanceCard() {
        Box(modifier = Modifier.padding(16.dp)) {
            Text("This is Card")
        }
    }
}