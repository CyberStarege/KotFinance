package com.cyberstarege.kotfinance.feature.groups

import com.cyberstarege.kotfinance.core.domain.domainModule
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val groupsModule = module {
    includes(domainModule)
    viewModelOf(::GroupsViewModel)
}