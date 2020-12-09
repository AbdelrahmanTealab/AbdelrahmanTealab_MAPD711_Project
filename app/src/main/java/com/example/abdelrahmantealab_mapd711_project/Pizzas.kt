package com.example.abdelrahmantealab_mapd711_project

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pizzas")
class Pizzas{
    @PrimaryKey(autoGenerate = true)
    private var id: Int = 0

    var pizzaName:String
    var pizzaToppings:String
    var pizzaSize:String
    var pizzaPrice:Int

    constructor(
        id: Int,
        pizzaName: String,
        pizzaToppings: String,
        pizzaSize: String,
        pizzaPrice: Int,
    ) {
        this.id = id
        this.pizzaName = pizzaName
        this.pizzaToppings = pizzaToppings
        this.pizzaSize = pizzaSize
        this.pizzaPrice = pizzaPrice
    }


    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getPName(): String? {
        return pizzaName
    }

    fun setPName(pizzaName: String) {
        this.pizzaName = pizzaName
    }
    fun getPToppings(): String{
        return pizzaToppings
    }

    fun setPToppings(pizzaToppings: String ) {
        this.pizzaToppings = pizzaToppings
    }
    fun setPsize(pizzaSize: String) {
        this.pizzaSize = pizzaSize
    }

    fun getPsize(): String? {
        return pizzaSize
    }

    fun setPprice(pizzaPrice: Int) {
        this.pizzaPrice = pizzaPrice
    }

    fun getPprice(): Int? {
        return pizzaPrice
    }


}