package com.cyberstarege.kotfinance

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

fun getDatabaseBuilder(context: Context): RoomDatabase.Builder<KotFinanceRoomDatabase> {
    val appContext = context.applicationContext
    val dbFile = appContext.getDatabasePath("kotfinance.db")
    return Room.databaseBuilder<KotFinanceRoomDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
}