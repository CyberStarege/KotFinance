package com.cyberstarege.kotfinance.core.domain

import com.cyberstarege.kotfinance.core.data.repository.AccountGroupRepository
import com.cyberstarege.kotfinance.core.model.AccountGroup
import kotlinx.coroutines.flow.Flow

class GetAllAccountGroupsUseCase(
    private val accountGroupRepository: AccountGroupRepository
) {
    operator fun invoke(): Flow<List<AccountGroup>> = accountGroupRepository.getAllAccountGroups()
}