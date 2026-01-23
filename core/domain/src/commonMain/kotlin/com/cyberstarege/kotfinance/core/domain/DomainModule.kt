package com.cyberstarege.kotfinance.core.domain

import com.cyberstarege.kotfinance.core.data.di.dataModule
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val domainModule = module {
    includes(dataModule)
    singleOf(::GetAllAccountGroupsUseCase)
}