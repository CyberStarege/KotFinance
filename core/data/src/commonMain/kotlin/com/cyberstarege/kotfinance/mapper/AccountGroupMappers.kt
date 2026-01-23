package com.cyberstarege.kotfinance.mapper

import com.cyberstarege.kotfinance.model.AccountGroup
import com.cyberstarege.kotfinance.model.AccountGroupEntity

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