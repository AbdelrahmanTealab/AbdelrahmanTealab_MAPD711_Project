package com.example.abdelrahmantealab_mapd711_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.TextView

class DisplayingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_displaying)
        //this activity only displays the information that the user has input based on the previous activities
        //and also i added a button to make it possible for the user to go back to home screen
        val preferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        val user_full_name =
            preferences.getString("user_Fname", "ERROR") + " " + preferences.getString(
                "user_Lname",
                "ERROR"
            )

        val pizzaSize = intent.extras?.getString("pizzaSize")
        val pizzaType = intent.extras?.getString("pizzaType")
        val myToppings = intent.extras?.getStringArrayList("myToppings")
        val streetAddress = intent.extras?.getString("streetAddress")

        var customerName: TextView = findViewById(R.id.customerName)
        var typeOfPizza: TextView = findViewById(R.id.typeOfPizza)
        var sizeOfPizza: TextView = findViewById(R.id.sizeOfPizza)
        var customerAddress: TextView = findViewById(R.id.customerAddress)
        var toppingDis: TextView = findViewById(R.id.toppingDis)

        customerName.setText(user_full_name)
        typeOfPizza.setText(pizzaType)
        sizeOfPizza.setText(pizzaSize)
        customerAddress.setText(streetAddress)

        //in this loop, i add the elements of my array to the textview and separate them by a comma when there's
        //another element following it in the array
        for (topping in myToppings!!) {
            toppingDis.append(topping)
            if (topping != myToppings.last()) {
                toppingDis.append(",")
            }
        }
    }

    fun homePressed(view: View) {
        val intent4 = Intent(this, MainActivity::class.java)
        startActivity(intent4)
    }
}