package com.example.abdelrahmantealab_mapd711_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.TextView

class Toppings : AppCompatActivity() {
    var db: AADatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toppings)
        db = AADatabase.getInstance(applicationContext)

        val pizzaSize = intent.extras?.getString("pizzaSize")
        val pizzaType = intent.extras?.getString("pizzaType")

        val pizzaTitle: TextView = findViewById(R.id.pizzaTitle)
        pizzaTitle.setText(pizzaSize + " " + pizzaType)
    }
    fun checkOutPressed(view: View){
        //when check out button is pressed, i store the text of the checkboxes
        //into an array only if they are checked so i can pass them on
        //to the next activity

        val cheese: CheckBox = findViewById(R.id.cheese)
        val greenPepper: CheckBox = findViewById(R.id.greenPepper)
        val smokedHam: CheckBox = findViewById(R.id.smokedHam)
        val spinach: CheckBox = findViewById(R.id.spinach)
        val blackOlives: CheckBox = findViewById(R.id.blackOlives)
        val spanishOnions: CheckBox = findViewById(R.id.spanishOnions)
        val availableToppings = arrayOf(cheese,greenPepper,smokedHam,spinach,blackOlives,spanishOnions)

        val myToppings: ArrayList<String> = ArrayList()
        val pizzaSize = intent.extras?.getString("pizzaSize")
        val pizzaType = intent.extras?.getString("pizzaType")

        for (topping in availableToppings){
            if (topping.isChecked){
                myToppings.add(topping.text.toString())
            }
        }

        var myToppingsString: String = ""
        for (topping in myToppings!!)
        {
            myToppingsString+=topping
            if (topping != myToppings.last()){
                myToppingsString+=","
            }
        }
        var pizzaPrice: Int
        if (pizzaSize == "Small"){
            pizzaPrice = (((myToppings.count()+1)*2) + 10)
        }
        else if (pizzaSize == "Medium"){
            pizzaPrice = (((myToppings.count()+1)*2) + 15)
        }
        else{
            pizzaPrice = (((myToppings.count()+1)*2) + 20)
        }

        var pizza = Pizzas(0,pizzaType!!,myToppingsString,pizzaSize!!,pizzaPrice)
        db?.pizzasDao()?.register(pizza)

        //here i pass the pizza type, size, and toppings array to the next activity
        val intent2 = Intent(this, CheckingOutActivity::class.java).apply {
            putStringArrayListExtra("myToppings",myToppings)
            putExtra("pizzaSize",pizzaSize)
            putExtra("pizzaType",pizzaType)
            putExtra("myToppingsString",myToppingsString)

        }
        startActivity(intent2)
    }
}