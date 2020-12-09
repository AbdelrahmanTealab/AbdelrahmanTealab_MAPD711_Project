package com.example.abdelrahmantealab_mapd711_project

import android.content.Context
import androidx.room.Database
import androidx.room.Room

import androidx.room.RoomDatabase




@Database(entities = [Customers::class,Admins::class,Pizzas::class], version = 1)

abstract class AADatabase : RoomDatabase() {

    abstract fun customersDao(): CustomersDao?
    abstract fun adminsDao(): AdminsDao?
    abstract fun pizzasDao(): PizzasDao?

    companion object {
        //
        @Volatile
        private var INSTANCE: AADatabase? = null
        private const val DATABASE_NAME = "PizzaDB"

        //
        @Synchronized
        fun getInstance(context: Context?): AADatabase? {
            if (INSTANCE == null) {

                //Create database object
                INSTANCE = Room.databaseBuilder(
                    context!!,
                    AADatabase::class.java, DATABASE_NAME
                ).allowMainThreadQueries().build()
            }
            return INSTANCE
        }
    }
}