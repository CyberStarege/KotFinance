package com.cyberstarege.kotfinance.feature.groups.di

import com.cyberstarege.kotfinance.core.domain.domainModule
import com.cyberstarege.kotfinance.feature.groups.GroupsViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val groupsModule = module {
    includes(domainModule)
    viewModelOf(::GroupsViewModel)
}