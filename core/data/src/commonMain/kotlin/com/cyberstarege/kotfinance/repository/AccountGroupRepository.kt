package com.cyberstarege.kotfinance.repository

import com.cyberstarege.kotfinance.model.AccountGroup
import kotlinx.coroutines.flow.Flow

interface AccountGroupRepository {
    suspend fun addAccountGroup(accountGroup: AccountGroup)
    suspend fun getAllAccountGroups(): Flow<List<AccountGroup>>
    suspend fun updateAccountGroup(accountGroup: AccountGroup)
    suspend fun deleteAccountGroup(accountGroup: AccountGroup)
}