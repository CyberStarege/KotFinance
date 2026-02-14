package com.cyberstarege.kotfinance.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "account_groups")
data class AccountGroupEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name : String,
    val color: Int,
    val icon: String? = null
)
