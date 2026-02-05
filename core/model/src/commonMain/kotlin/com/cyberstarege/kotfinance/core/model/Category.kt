package com.cyberstarege.kotfinance.core.model

data class Category(
    val id: Long,
    val name: String,
    val color: Int,
    val icon: String? = null
)