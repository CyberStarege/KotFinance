package com.cyberstarege.kotfinance

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.room.TypeConverters
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.cyberstarege.kotfinance.converters.DateTimeConverter
import com.cyberstarege.kotfinance.model.AccountEntity
import com.cyberstarege.kotfinance.model.CategoryEntity
import com.cyberstarege.kotfinance.model.TransactionEntity
import com.cyberstarege.kotfinance.model.AccountGroupEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

@Database(
    entities = [
        AccountGroupEntity::class,
        AccountEntity::class,
        CategoryEntity::class,
        TransactionEntity::class
    ],
    version = 1
)
@TypeConverters(DateTimeConverter::class)
@ConstructedBy(KotFinanceDatabaseConstructor::class)
abstract class KotFinanceRoomDatabase : RoomDatabase() {

}

@Suppress("KotlinNoActualForExpect")
expect object KotFinanceDatabaseConstructor : RoomDatabaseConstructor<KotFinanceRoomDatabase> {
    override fun initialize(): KotFinanceRoomDatabase
}

fun getKotFinanceRoomDatabase(
    builder: RoomDatabase.Builder<KotFinanceRoomDatabase>
): KotFinanceRoomDatabase {
    return builder
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}