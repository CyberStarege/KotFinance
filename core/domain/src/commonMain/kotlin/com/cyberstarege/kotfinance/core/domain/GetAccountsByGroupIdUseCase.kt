package com.cyberstarege.kotfinance.core.domain

import com.cyberstarege.kotfinance.core.data.repository.AccountRepository
import com.cyberstarege.kotfinance.core.model.Account
import kotlinx.coroutines.flow.Flow

class GetAccountsByGroupIdUseCase(
    private val accountRepository: AccountRepository
) {
    suspend operator fun invoke(groupId: Long): Flow<List<Account>> {
        return accountRepository.getAllAccountsForGroup(groupId)
    }
}
