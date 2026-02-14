package com.cyberstarege.kotfinance.core.domain

import com.cyberstarege.kotfinance.core.data.repository.AccountGroupRepository
import com.cyberstarege.kotfinance.core.data.repository.AccountRepository
import com.cyberstarege.kotfinance.core.model.GroupWithAccounts
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class GetGroupsWithAccountsUseCase(
    private val groupRepository: AccountGroupRepository,
    private val accountRepository: AccountRepository
) {
    @OptIn(ExperimentalCoroutinesApi::class)
    operator fun invoke(): Flow<List<GroupWithAccounts>> {
        return groupRepository.getAllAccountGroups()
            .flatMapLatest { groups ->
                if (groups.isEmpty()) {
                    return@flatMapLatest flowOf(emptyList())
                }

                val flows = groups.map { group ->
                    accountRepository.getAllAccountsForGroup(group.id).map { accounts ->
                        GroupWithAccounts(group, accounts)
                    }
                }
                combine(flows) { it.toList() }
            }
    }
}