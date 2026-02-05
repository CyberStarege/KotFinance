package com.cyberstarege.kotfinance.core.model

data class Account(
    val id: Long,
    val accountGroupId: Long,
    val name: String,
    val accountType: AccountType,
    val currentBalance: Double,
    val color: Int
)