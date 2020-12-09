package com.example.abdelrahmantealab_mapd711_project

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
public interface PizzasDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun register(pizzas: Pizzas)

    @Query("SELECT * FROM pizzas WHERE pizzaName = :pizzaName")
    fun getByName(pizzaName: String):Pizzas

    @Query("SELECT * FROM pizzas")
    fun getAllPizzas():List<Pizzas>

    @Query("SELECT pizzaPrice FROM pizzas WHERE pizzaToppings = :pizzaToppings AND pizzaSize = :pizzaSize LIMIT 1")
    fun getPrice(pizzaToppings: String, pizzaSize: String): Int
}