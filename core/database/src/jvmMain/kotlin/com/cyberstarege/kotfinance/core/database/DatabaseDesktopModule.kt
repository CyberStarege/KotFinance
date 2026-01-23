package com.cyberstarege.kotfinance.core.database

import androidx.room.RoomDatabase
import org.koin.dsl.module

val databaseDesktopModule = module {
    single<RoomDatabase.Builder<KotFinanceRoomDatabase>> {
        getDatabaseBuilder()
    }
}