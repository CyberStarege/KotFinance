package com.cyberstarege.kotfinance

import androidx.room.RoomDatabase
import org.koin.dsl.module

val databaseDesktopModule = module {
    single<RoomDatabase.Builder<KotFinanceRoomDatabase>> {
        getDatabaseBuilder()
    }
}