package com.cyberstarege.kotfinance.feature.groups

import com.cyberstarege.kotfinance.core.model.GroupWithAccounts

data class GroupsUiState(
    val groupsWithAccounts: List<GroupWithAccounts> = emptyList()
)