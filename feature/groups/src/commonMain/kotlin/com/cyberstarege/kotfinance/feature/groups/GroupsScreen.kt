package com.cyberstarege.kotfinance.feature.groups

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowSizeClass
import com.cyberstarege.kotfinance.core.model.AccountGroup
import com.cyberstarege.kotfinance.feature.groups.components.CreateGroupBottomSheet
import com.cyberstarege.kotfinance.feature.groups.components.CreateGroupButton
import com.cyberstarege.kotfinance.feature.groups.components.CreateGroupDialog
import com.cyberstarege.kotfinance.feature.groups.components.GroupsScreenContent
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun GroupsScreen(
    windowSizeClass: WindowSizeClass,
) {
    val groupsViewModel = koinViewModel<GroupsViewModel>()
    val uiState by groupsViewModel.uiState.collectAsState()
    val isDesktop = windowSizeClass.isWidthAtLeastBreakpoint(WindowSizeClass.WIDTH_DP_MEDIUM_LOWER_BOUND)
    var showCreateGroupDialog by remember { mutableStateOf(false) }
    var showCreateGroupBottomSheet by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        GroupsScreenContent(
            isDesktop = isDesktop,
            uiState = uiState,
            onAddAccount = { }
        )
        CreateGroupButton(
            isDesktop = isDesktop,
            onCreateGroup = {
                if (isDesktop) {
                    showCreateGroupDialog = true
                } else {
                    showCreateGroupBottomSheet = true
                }
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(if (isDesktop) 32.dp else 16.dp)
        )
        if (showCreateGroupDialog) {
            CreateGroupDialog(
                isDesktop = isDesktop,
                onDismiss = { showCreateGroupDialog = false },
                onCreate = { name, color, icon ->
                    groupsViewModel.addGroup(
                        AccountGroup(
                            name = name,
                            color = color,
                            icon = icon
                        )
                    )
                    showCreateGroupDialog = false
                }
            )
        }
        if (showCreateGroupBottomSheet) {
            CreateGroupBottomSheet(
                isDesktop = isDesktop,
                onDismiss = { showCreateGroupBottomSheet = false },
                onCreate = { name, color, icon ->
                    groupsViewModel.addGroup(
                        AccountGroup(
                            name = name,
                            color = color,
                            icon = icon
                        )
                    )
                }
            )
        }
    }
}
