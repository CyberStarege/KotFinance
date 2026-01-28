package com.cyberstarege.kotfinance.core.database

import androidx.room.RoomDatabase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

actual val platformModule = module {
    singleOf(::getDatabaseBuilder).bind<RoomDatabase.Builder<KotFinanceRoomDatabase>>()
}