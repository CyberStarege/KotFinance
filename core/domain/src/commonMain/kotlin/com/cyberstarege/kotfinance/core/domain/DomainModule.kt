package com.cyberstarege.kotfinance.core.domain

import com.cyberstarege.kotfinance.core.data.di.dataModule
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
    includes(dataModule)
    factoryOf(::GetAllAccountGroupsUseCase)
}