package com.cyberstarege.kotfinance.core.data.repository

import com.cyberstarege.kotfinance.core.data.mapper.toEntity
import com.cyberstarege.kotfinance.core.data.mapper.toModel
import com.cyberstarege.kotfinance.core.database.dao.AccountDao
import com.cyberstarege.kotfinance.core.model.Account
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AccountRepositoryImpl(
    private val accountDao: AccountDao
) : AccountRepository {
    override suspend fun addAccount(account: Account) {
        accountDao.insertAccount(account.toEntity())
    }

    override suspend fun deleteAccount(account: Account) {
        accountDao.deleteAccount(account.toEntity())
    }

    override suspend fun updateAccount(account: Account) {
        accountDao.updateAccount(account.toEntity())
    }

    override suspend fun getAllAccounts(): Flow<List<Account>> {
        return accountDao.getAllAccounts().map {
            it.map { accountEntity ->
                accountEntity.toModel()
            }
        }
    }

    override suspend fun getAllAccountsForGroup(groupId: Long): Flow<List<Account>> {
        return accountDao.getAllAccountsForGroup(groupId).map {
            it.map { accountEntity ->
                accountEntity.toModel()
            }
        }
    }
}