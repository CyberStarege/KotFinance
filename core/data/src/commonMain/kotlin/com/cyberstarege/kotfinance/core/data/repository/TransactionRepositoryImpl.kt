package com.cyberstarege.kotfinance.core.data.repository

import com.cyberstarege.kotfinance.core.database.dao.TransactionDao
import com.cyberstarege.kotfinance.core.model.Transaction
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TransactionRepositoryImpl(
    private val transactionDao: TransactionDao
) : TransactionRepository {
    override suspend fun addTransaction(transaction: Transaction) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteTransaction(transaction: Transaction) {
        TODO("Not yet implemented")
    }

    override suspend fun updateTransaction(transaction: Transaction) {
        TODO("Not yet implemented")
    }

    override suspend fun getAllTransactions(): Flow<List<Transaction>> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllTransactionsForAccount(accountId: Long): Flow<List<Transaction>> {
        TODO("Not yet implemented")
    }
}