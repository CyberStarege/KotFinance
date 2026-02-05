package com.cyberstarege.kotfinance.core.model

import kotlin.time.Instant

data class Transaction(
    val id: Long,
    val accountId: Long,
    val categoryId: Long,
    val amount: Double,
    val date: Instant,
    val type: TransactionType,
    val description: String?
)
