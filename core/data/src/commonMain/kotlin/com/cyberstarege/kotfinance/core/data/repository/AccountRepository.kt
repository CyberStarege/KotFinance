package com.cyberstarege.kotfinance.core.data.repository

import com.cyberstarege.kotfinance.core.model.Account
import kotlinx.coroutines.flow.Flow

interface AccountRepository {
    suspend fun addAccount(account: Account)
    suspend fun deleteAccount(account: Account)
    suspend fun updateAccount(account: Account)
    suspend fun getAllAccounts(): Flow<List<Account>>
    suspend fun getAllAccountsForGroup(groupId: Long): Flow<List<Account>>
}