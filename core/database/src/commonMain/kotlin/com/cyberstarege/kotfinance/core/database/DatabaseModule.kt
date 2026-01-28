package com.cyberstarege.kotfinance.core.database

import com.cyberstarege.kotfinance.core.database.dao.AccountGroupDao
import org.koin.core.module.Module
import org.koin.dsl.module

val databaseModule = module {
    single<KotFinanceRoomDatabase> {
        getKotFinanceRoomDatabase(builder = get())
    }

    single { get<KotFinanceRoomDatabase>().getAccountGroupDao() }

    single { get<KotFinanceRoomDatabase>().getAccountDao() }

    single { get<KotFinanceRoomDatabase>().getCategoryDao() }

    single { get<KotFinanceRoomDatabase>().getTransactionDao() }
}

expect val platformModule: Module