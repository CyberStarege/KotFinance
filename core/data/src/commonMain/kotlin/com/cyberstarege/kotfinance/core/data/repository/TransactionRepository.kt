package com.cyberstarege.kotfinance.core.data.repository

import com.cyberstarege.kotfinance.core.model.Transaction
import kotlinx.coroutines.flow.Flow

interface TransactionRepository {
    suspend fun addTransaction(transaction: Transaction)
    suspend fun deleteTransaction(transaction: Transaction)
    suspend fun updateTransaction(transaction: Transaction)
    suspend fun getAllTransactions(): Flow<List<Transaction>>
    suspend fun getAllTransactionsForAccount(accountId: Long): Flow<List<Transaction>>
}