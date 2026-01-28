package com.cyberstarege.kotfinance.core.domain

import com.cyberstarege.kotfinance.core.data.repository.AccountGroupRepository
import com.cyberstarege.kotfinance.core.model.AccountGroup

class AddGroupUseCase(
    private val accountGroupRepository: AccountGroupRepository
) {
    suspend operator fun invoke(accountGroup: AccountGroup) {
        accountGroupRepository.addAccountGroup(accountGroup)
    }
}