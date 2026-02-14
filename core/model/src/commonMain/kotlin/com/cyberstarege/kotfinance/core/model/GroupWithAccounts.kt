package com.cyberstarege.kotfinance.core.model

data class GroupWithAccounts(
    val group: AccountGroup,
    val accounts: List<Account>
)
