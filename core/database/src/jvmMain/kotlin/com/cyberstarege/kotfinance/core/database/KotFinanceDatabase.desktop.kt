package com.cyberstarege.kotfinance.core.database

import androidx.room.Room
import androidx.room.RoomDatabase
import java.io.File


fun getDatabaseBuilder(): RoomDatabase.Builder<KotFinanceRoomDatabase> {
    val dbFile = File(System.getProperty("java.io.tmpdir"), "kotfinance.db")
    return Room.databaseBuilder<KotFinanceRoomDatabase>(
        name = dbFile.absolutePath,
    )
}