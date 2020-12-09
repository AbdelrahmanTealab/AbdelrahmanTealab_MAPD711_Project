package com.example.abdelrahmantealab_mapd711_project

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class CheckingOutActivity : AppCompatActivity() {
    var db: AADatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checking_out)
        db = AADatabase.getInstance(applicationContext)

        val preferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        val user_full_name = "" +preferences.getString("user_Fname", "ERROR") + " " + preferences.getString("user_Lname", "ERROR")
        val user_username = preferences.getString("user_username", "ERROR")
        val user_email = preferences.getString("user_email", "ERROR")
        val user_address = preferences.getString("user_address", "ERROR")
        val user_city = preferences.getString("user_city", "ERROR")
        val user_postal = preferences.getString("user_postal", "ERROR")
        val user_phone = preferences.getString("user_phone", "ERROR")
        val pizzaSize = intent.extras?.getString("pizzaSize")
        val myToppingsString = intent.extras?.getString("myToppingsString")

        var fullName:TextView = findViewById(R.id.fullNameCI)
        fullName.text = user_full_name
        var userName:TextView = findViewById(R.id.userNameCI)
        userName.text = user_username
        var userPhone:TextView = findViewById(R.id.phoneNumberCI)
        userPhone.text = user_phone
        var streetAddress:EditText = findViewById(R.id.streetAddressCI)
        streetAddress.setText(user_address + ',' + user_city)
        var postalCode:EditText = findViewById(R.id.postalCodeCI)
        postalCode.setText(user_postal)
        var price:TextView = findViewById(R.id.priceCI)
        price.text = db?.pizzasDao()?.getPrice(myToppingsString!!,pizzaSize!!)?.toString()
    }

    fun submitPressed(view: View){
        //when submit button or (ORDER) button is pressed, i do a simple validity check
        //to make sure that all the fields have input in them, otherwise a feedback
        //will be provided for the user to enforce them to fill in the fields.
        var streetAddress:EditText = findViewById(R.id.streetAddressCI)
        var postalCode:EditText = findViewById(R.id.postalCodeCI)
        var phoneNumber:TextView = findViewById(R.id.phoneNumberCI)
        var creditCard:EditText = findViewById(R.id.creditCardCI)
        var cardType:EditText = findViewById(R.id.cardTypeCI)
        var expiryDate:EditText = findViewById(R.id.expiryDateCI)

        if (streetAddress.text.isEmpty()){
            val toast = Toast.makeText(
                applicationContext,
                "street address is empty!",
                Toast.LENGTH_SHORT
            )
            toast.show()
            streetAddress.hint="Please enter an address"
        }

        if (postalCode.text.isEmpty()){
            val toast = Toast.makeText(
                applicationContext,
                "postal code is empty!",
                Toast.LENGTH_SHORT
            )
            toast.show()
            postalCode.hint="Please enter a postal code"
        }

        if (creditCard.text.isEmpty()){
            val toast = Toast.makeText(
                applicationContext,
                "credit card is empty!",
                Toast.LENGTH_SHORT
            )
            toast.show()
            creditCard.hint="Please enter a credit card"
        }
        if (cardType.text.isEmpty()){
            val toast = Toast.makeText(
                applicationContext,
                "card type is empty!",
                Toast.LENGTH_SHORT
            )
            toast.show()
            cardType.hint="Please enter a card type"
        }
        if (expiryDate.text.isEmpty()){
            val toast = Toast.makeText(
                applicationContext,
                "expiry date is empty!",
                Toast.LENGTH_SHORT
            )
            toast.show()
            expiryDate.hint="Please enter an expiry date"
        }
        if (!streetAddress.text.isEmpty() && !postalCode.text.isEmpty() && !phoneNumber.text.isEmpty() && !creditCard.text.isEmpty() && !cardType.text.isEmpty() && !expiryDate.text.isEmpty()){
            val toast = Toast.makeText(applicationContext, "congrats!!", Toast.LENGTH_SHORT)
            toast.show()

            //when everything is valid, i pass on the variables that i need for the next screen which will be
            //pizza size, type, toppings, and also from this activity, fullname and address so they can be displayed
            //in the final screen
            val pizzaSize = intent.extras?.getString("pizzaSize")
            val pizzaType = intent.extras?.getString("pizzaType")
            val myToppings = intent.extras?.getStringArrayList("myToppings")


            val intent3 = Intent(this, DisplayingActivity::class.java).apply {
                putStringArrayListExtra("myToppings", myToppings)
                putExtra("pizzaSize", pizzaSize)
                putExtra("pizzaType", pizzaType)
                putExtra("streetAddress", streetAddress.text.toString())
            }
            startActivity(intent3)
        }
    }
}