package com.cyberstarege.kotfinance.core.data.mapper

import com.cyberstarege.kotfinance.core.database.model.AccountEntity
import com.cyberstarege.kotfinance.core.model.Account

fun Account.toEntity(): AccountEntity =
    AccountEntity(
        id = id,
        accountGroupId = accountGroupId,
        name = name,
        accountType = accountType,
        currentBalance = currentBalance,
        color = color
    )

fun AccountEntity.toModel() =
    Account(
        id = id,
        accountGroupId = accountGroupId,
        name = name,
        accountType = accountType,
        currentBalance = currentBalance,
        color = color
    )