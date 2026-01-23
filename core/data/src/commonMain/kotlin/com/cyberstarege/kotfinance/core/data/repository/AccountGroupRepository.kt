package com.cyberstarege.kotfinance.core.data.repository

import com.cyberstarege.kotfinance.core.model.AccountGroup
import kotlinx.coroutines.flow.Flow

interface AccountGroupRepository {
    suspend fun addAccountGroup(accountGroup: AccountGroup)
    fun getAllAccountGroups(): Flow<List<AccountGroup>>
    suspend fun updateAccountGroup(accountGroup: AccountGroup)
    suspend fun deleteAccountGroup(accountGroup: AccountGroup)
}