package com.cyberstarege.kotfinance.core.data.mapper

import com.cyberstarege.kotfinance.core.model.AccountGroup
import com.cyberstarege.kotfinance.core.database.model.AccountGroupEntity

fun AccountGroupEntity.toAccountGroup(): AccountGroup {
    return AccountGroup(
        id = id,
        name = name
    )
}

fun AccountGroup.toAccountGroupEntity(): AccountGroupEntity {
    return AccountGroupEntity(
        id = id,
        name = name
    )
}