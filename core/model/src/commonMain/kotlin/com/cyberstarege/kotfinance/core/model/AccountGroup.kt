package com.cyberstarege.kotfinance.core.model

data class AccountGroup(
    val id: Long = 0,
    val name: String,
    val description: String? = null,
    val color: Int,
    val icon: String? = null
)
