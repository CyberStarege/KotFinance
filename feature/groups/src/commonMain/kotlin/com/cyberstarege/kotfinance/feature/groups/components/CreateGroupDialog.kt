package com.cyberstarege.kotfinance.feature.groups.components

import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.cyberstarege.kotfinance.core.designsystem.theme.KotFinanceTheme

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun CreateGroupDialog(
    isDesktop: Boolean,
    onDismiss: () -> Unit,
    onCreate: (name: String, color: Int, icon: String?) -> Unit
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        CreateGroupContent(
            isDesktop = isDesktop,
            onDismiss = onDismiss,
            onCreate = onCreate
        )
    }
}

@Preview(name = "Desktop")
@Preview(name = "Desktop Dark", uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun CreateGroupDialogPreview() {
    KotFinanceTheme {
        CreateGroupDialog(
            isDesktop = false,
            onDismiss = {},
            onCreate = { _, _, _ -> }
        )
    }
}
