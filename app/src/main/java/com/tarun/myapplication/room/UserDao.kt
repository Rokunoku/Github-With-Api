package com.tarun.myapplication.room

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tarun.myapplication.dataclass.Item

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<Item>)

    @Query("SELECT login,html_url,avatar_url FROM user ORDER BY id DESC")
    fun getAll(): PagingSource<Int, Item>

    @Query("DELETE FROM User")
    suspend fun clearAll()

    @Query("SELECT COUNT(id) from user")
    suspend fun count(): Int
}


