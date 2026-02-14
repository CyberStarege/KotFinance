package com.cyberstarege.kotfinance.feature.groups.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview
import com.cyberstarege.kotfinance.core.designsystem.theme.KotFinanceTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateGroupBottomSheet(
    isDesktop: Boolean,
    onDismiss: () -> Unit,
    onCreate: (name: String, color: Int, icon: String?) -> Unit,
    modifier: Modifier = Modifier
) {
    ModalBottomSheet(
        containerColor = MaterialTheme.colorScheme.surfaceContainer,
        onDismissRequest = onDismiss,
        modifier = modifier
    ) {
        CreateGroupContent(
            isDesktop = isDesktop,
            onDismiss = onDismiss,
            onCreate = onCreate
        )
    }
}

@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun CreateGroupBottomSheetPreview() {
    KotFinanceTheme {
        CreateGroupBottomSheet(
            isDesktop = false,
            onDismiss = {},
            onCreate = { _, _, _ -> }
        )
    }
}
