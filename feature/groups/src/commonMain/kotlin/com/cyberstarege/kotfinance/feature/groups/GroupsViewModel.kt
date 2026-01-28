package com.cyberstarege.kotfinance.feature.groups

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cyberstarege.kotfinance.core.domain.AddGroupUseCase
import com.cyberstarege.kotfinance.core.domain.GetAllAccountGroupsUseCase
import com.cyberstarege.kotfinance.core.model.AccountGroup
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class GroupsViewModel(
    private val getAllAccountGroupsUseCase: GetAllAccountGroupsUseCase,
    private val addGroupUseCase: AddGroupUseCase
) : ViewModel() {
    val accountGroups: StateFlow<List<AccountGroup>> = getAllAccountGroupsUseCase()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = emptyList()
        )

    fun addGroup(accountGroup: AccountGroup) {
        viewModelScope.launch {
            addGroupUseCase(accountGroup)
        }
    }
}