package com.cyberstarege.kotfinance.core.database

import androidx.room.RoomDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseAndroidModule = module {
    single<RoomDatabase.Builder<KotFinanceRoomDatabase>> {
        getDatabaseBuilder(context = androidContext())
    }
}