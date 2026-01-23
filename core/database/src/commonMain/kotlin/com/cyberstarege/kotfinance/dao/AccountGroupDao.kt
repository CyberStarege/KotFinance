package com.cyberstarege.kotfinance.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.cyberstarege.kotfinance.model.AccountGroupEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AccountGroupDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGroup(group: AccountGroupEntity)

    @Query("SELECT * FROM account_groups")
    fun getAllGroups(): Flow<List<AccountGroupEntity>>

    @Update
    suspend fun updateGroup(group: AccountGroupEntity)

    @Delete
    suspend fun deleteGroup(group: AccountGroupEntity)
}