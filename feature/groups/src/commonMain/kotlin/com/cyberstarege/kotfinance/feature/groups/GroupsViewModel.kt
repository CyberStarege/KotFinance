package com.cyberstarege.kotfinance.feature.groups

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cyberstarege.kotfinance.core.domain.AddGroupUseCase
import com.cyberstarege.kotfinance.core.domain.GetAccountsByGroupIdUseCase
import com.cyberstarege.kotfinance.core.domain.GetAllAccountGroupsUseCase
import com.cyberstarege.kotfinance.core.domain.GetGroupsWithAccountsUseCase
import com.cyberstarege.kotfinance.core.model.AccountGroup
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch


class GroupsViewModel(
    private val getAllAccountGroupsUseCase: GetAllAccountGroupsUseCase,
    private val getAccountsByGroupIdUseCase: GetAccountsByGroupIdUseCase,
    private val addGroupUseCase: AddGroupUseCase,
    private val getGroupsWithAccountsUseCase: GetGroupsWithAccountsUseCase,
) : ViewModel() {

    val uiState: StateFlow<GroupsUiState> = getGroupsWithAccountsUseCase()
        .map { groups ->
            GroupsUiState(
                groupsWithAccounts = groups
            )
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = GroupsUiState(groupsWithAccounts = emptyList())
        )

    fun addGroup(accountGroup: AccountGroup) {
        viewModelScope.launch {
            addGroupUseCase(accountGroup)
        }
    }
}
