package com.cyberstarege.kotfinance.core.data.di

import com.cyberstarege.kotfinance.core.database.databaseModule
import com.cyberstarege.kotfinance.core.database.platformModule
import com.cyberstarege.kotfinance.core.data.repository.AccountGroupRepository
import com.cyberstarege.kotfinance.core.data.repository.AccountGroupRepositoryImpl
import com.cyberstarege.kotfinance.core.data.repository.AccountRepository
import com.cyberstarege.kotfinance.core.data.repository.AccountRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    includes(databaseModule, platformModule)
    singleOf(::AccountGroupRepositoryImpl) bind AccountGroupRepository::class
    singleOf(::AccountRepositoryImpl) bind AccountRepository::class
}