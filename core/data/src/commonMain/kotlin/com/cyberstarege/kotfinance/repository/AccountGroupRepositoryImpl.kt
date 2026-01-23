package com.cyberstarege.kotfinance.repository

import com.cyberstarege.kotfinance.dao.AccountGroupDao
import com.cyberstarege.kotfinance.mapper.toAccountGroup
import com.cyberstarege.kotfinance.mapper.toAccountGroupEntity
import com.cyberstarege.kotfinance.model.AccountGroup
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