package com.cyberstarege.kotfinance.feature.groups

import androidx.lifecycle.ViewModel
import com.cyberstarege.kotfinance.core.domain.GetAllAccountGroupsUseCase

class GroupsViewModel(
    private val getAllAccountGroupsUseCase: GetAllAccountGroupsUseCase
) : ViewModel() {

}