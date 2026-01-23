package com.cyberstarege.kotfinance.di

import com.cyberstarege.kotfinance.databaseModule
import com.cyberstarege.kotfinance.repository.AccountGroupRepository
import com.cyberstarege.kotfinance.repository.AccountGroupRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    includes(databaseModule)
    singleOf(::AccountGroupRepositoryImpl) bind AccountGroupRepository::class
}