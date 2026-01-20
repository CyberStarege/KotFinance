package com.cyberstarege.kotfinance.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "accounts",
    foreignKeys = [
        ForeignKey(
            entity = AccountGroupEntity::class,
            parentColumns = ["id"],
            childColumns = ["account_group_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class AccountEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "account_group_id")
    val accountGroupId: Long,
    val name: String,
    @ColumnInfo(name = "account_type")
    val accountType: AccountType,
    @ColumnInfo(name = "current_balance")
    val currentBalance: Double,
    val color: Int
)

