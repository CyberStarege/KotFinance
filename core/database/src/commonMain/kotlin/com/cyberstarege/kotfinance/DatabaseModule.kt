package com.cyberstarege.kotfinance

import androidx.room.RoomDatabase
import org.koin.dsl.module

val databaseModule = module {
    single<KotFinanceRoomDatabase> {
        val builder = get<RoomDatabase.Builder<KotFinanceRoomDatabase>>()
        getKotFinanceRoomDatabase()
    }

    single { get<KotFinanceRoomDatabase>().getAccountGroupDao() }

    single { get<KotFinanceRoomDatabase>().getAccountDao() }

    single { get<KotFinanceRoomDatabase>().getCategoryDao() }

    single { get<KotFinanceRoomDatabase>().getTransactionDao() }
}