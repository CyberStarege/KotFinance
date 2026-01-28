package com.cyberstarege.kotfinance.core.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.room.TypeConverters
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.cyberstarege.kotfinance.core.database.converters.DateTimeConverter
import com.cyberstarege.kotfinance.core.database.dao.AccountDao
import com.cyberstarege.kotfinance.core.database.dao.AccountGroupDao
import com.cyberstarege.kotfinance.core.database.dao.CategoryDao
import com.cyberstarege.kotfinance.core.database.dao.TransactionDao
import com.cyberstarege.kotfinance.core.database.model.AccountEntity
import com.cyberstarege.kotfinance.core.database.model.AccountGroupEntity
import com.cyberstarege.kotfinance.core.database.model.CategoryEntity
import com.cyberstarege.kotfinance.core.database.model.TransactionEntity
import kotlinx.coroutines.Dispatchers

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
    abstract fun getAccountGroupDao(): AccountGroupDao
    abstract fun getAccountDao(): AccountDao
    abstract fun getCategoryDao(): CategoryDao
    abstract fun getTransactionDao(): TransactionDao
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