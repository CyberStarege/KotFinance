package com.cyberstarege.kotfinance.core.data.repository

import com.cyberstarege.kotfinance.core.database.dao.AccountGroupDao
import com.cyberstarege.kotfinance.core.data.mapper.toAccountGroup
import com.cyberstarege.kotfinance.core.data.mapper.toAccountGroupEntity
import com.cyberstarege.kotfinance.core.model.AccountGroup
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AccountGroupRepositoryImpl(
    private val accountGroupDao: AccountGroupDao
) : AccountGroupRepository {
    override suspend fun addAccountGroup(accountGroup: AccountGroup) {
        accountGroupDao.insertGroup(accountGroup.toAccountGroupEntity())
    }

    override suspend fun getAllAccountGroups(): Flow<List<AccountGroup>> {
        return accountGroupDao.getAllGroups().map { it.map { it.toAccountGroup() } }
    }

    override suspend fun updateAccountGroup(accountGroup: AccountGroup) {
        accountGroupDao.updateGroup(accountGroup.toAccountGroupEntity())
    }

    override suspend fun deleteAccountGroup(accountGroup: AccountGroup) {
        accountGroupDao.deleteGroup(accountGroup.toAccountGroupEntity())
    }
}