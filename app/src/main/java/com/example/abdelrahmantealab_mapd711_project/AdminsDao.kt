package com.example.abdelrahmantealab_mapd711_project

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
public interface AdminsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun registerAdmin(admin: Admins)

    @Query("SELECT * FROM admins WHERE username = :username")
    fun getAdminByUsername(username: String):Admins

    @Query("SELECT * FROM admins")
    fun getAllAdmins():List<Admins>
}