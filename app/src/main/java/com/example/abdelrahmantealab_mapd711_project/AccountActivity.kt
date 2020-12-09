package com.example.abdelrahmantealab_mapd711_project

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.children
import kotlinx.android.synthetic.main.activity_main.*

class AccountActivity : AppCompatActivity() {
    var db: AADatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)
        db = AADatabase.getInstance(applicationContext)

        val preferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        val user_fname = preferences.getString("user_Fname", "ERROR")
        val user_lname = preferences.getString("user_Lname", "ERROR")
        val user_username = preferences.getString("user_username", "ERROR")
        val user_email = preferences.getString("user_email", "ERROR")


        val customerData = db?.customersDao()?.getByDetails(user_fname!!,user_lname!!,user_username!!,user_email!!)
        val customerID = customerData?.getId()

        var fnameCI = findViewById<EditText>(R.id.fnameMainCI)
        var lnameCI = findViewById<EditText>(R.id.lnameMainCI)
        var usernameCI = findViewById<EditText>(R.id.usernameMainCI)
        var emailCI = findViewById<EditText>(R.id.emailMainCI)
        var addressCI = findViewById<EditText>(R.id.addressMainCI)
        var cityCI = findViewById<EditText>(R.id.cityMainCI)
        var postalCI = findViewById<EditText>(R.id.postalMainCI)
        var phoneCI = findViewById<EditText>(R.id.phoneMainCI)

        fnameCI.setText(customerData?.firstname)
        lnameCI.setText(customerData?.lastname)
        usernameCI.setText(customerData?.getUsername())
        emailCI.setText(customerData?.getEmail())
        addressCI.setText(customerData?.getAddress())
        cityCI.setText(customerData?.getCity())
        postalCI.setText(customerData?.getPostal())
        phoneCI.setText(customerData?.getPhone())
    }
    fun updatePressed(view: View){
        db = AADatabase.getInstance(applicationContext)
        val linearLayout: LinearLayout = findViewById(R.id.bigLinearLayout)

        val preferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        val user_fname = preferences.getString("user_Fname", "ERROR")
        val user_lname = preferences.getString("user_Lname", "ERROR")
        val user_username = preferences.getString("user_username", "ERROR")
        val user_email = preferences.getString("user_email", "ERROR")

        val customerData = db?.customersDao()?.getByDetails(user_fname!!,user_lname!!,user_username!!,user_email!!)
        val customerID = customerData?.getId()!!

        var err = 0

        for (small  in linearLayout.children){
            if (small is LinearLayout)
            {
                for (field in small.children)
                {
                    if (field is EditText)
                    {
                        if(field.text.toString().isEmpty()){
                            field.background.setTint((Color.parseColor("#66ff0f0f")))
                            field.setTextColor(Color.parseColor("#ff0f0f"))
                            Toast.makeText(this, "Please enter your "+field.hint.toString(), Toast.LENGTH_SHORT).show()
                            err+=1
                        }
                        else{
                            if (field == findViewById(R.id.emailMainCI) && !Patterns.EMAIL_ADDRESS.matcher(field.text.toString()).matches())
                            {
                                field.background.setTint((Color.parseColor("#66ff0f0f")))
                                field.setTextColor(Color.parseColor("#ff0f0f"))
                                Toast.makeText(this, "Invalid "+field.hint.toString(), Toast.LENGTH_SHORT).show()
                                err+=1
                            }
                            else if (field == findViewById(R.id.phoneMainCI) && !Patterns.PHONE.matcher(field.text.toString()).matches()){
                                field.background.setTint((Color.parseColor("#66ff0f0f")))
                                field.setTextColor(Color.parseColor("#ff0f0f"))
                                Toast.makeText(this, "Invalid "+field.hint.toString(), Toast.LENGTH_SHORT).show()
                                err+=1
                            }

                            else if (field == findViewById(R.id.usernameMainCI) && field.text.toString().length <= 4){
                                field.background.setTint((Color.parseColor("#66ff0f0f")))
                                field.setTextColor(Color.parseColor("#ff0f0f"))
                                Toast.makeText(this, field.hint.toString() + " must be longer than 4 characters", Toast.LENGTH_SHORT).show()
                                err+=1
                            }
                            else {
                                field.background.setTint((Color.parseColor("#ffffff")))
                                field.setTextColor(resources.getColor(R.color.radarGreen))
                            }
                        }
                    }
                    }
                }
        }
        if (err == 0){
            var fnameCI = findViewById<EditText>(R.id.fnameMainCI).text.toString()
            var lnameCI = findViewById<EditText>(R.id.lnameMainCI).text.toString()
            var usernameCI = findViewById<EditText>(R.id.usernameMainCI).text.toString()
            var emailCI = findViewById<EditText>(R.id.emailMainCI).text.toString()
            var addressCI = findViewById<EditText>(R.id.addressMainCI).text.toString()
            var cityCI = findViewById<EditText>(R.id.cityMainCI).text.toString()
            var postalCI = findViewById<EditText>(R.id.postalMainCI).text.toString()
            var phoneCI = findViewById<EditText>(R.id.phoneMainCI).text.toString()

            db?.customersDao()?.updateFname(fnameCI,customerID)
            db?.customersDao()?.updateLname(lnameCI,customerID)
            db?.customersDao()?.updateUsername(usernameCI,customerID)
            db?.customersDao()?.updateEmail(emailCI,customerID)
            db?.customersDao()?.updateAddress(addressCI,customerID)
            db?.customersDao()?.updateCity(cityCI,customerID)
            db?.customersDao()?.updatePostal(postalCI,customerID)
            db?.customersDao()?.updatePhone(phoneCI,customerID)

            val toast = Toast.makeText(applicationContext, "Update successful", Toast.LENGTH_SHORT)
            toast.show()
        }
    }
    fun refreshPressed(view: View){
        db = AADatabase.getInstance(applicationContext)

        val preferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        val user_fname = preferences.getString("user_Fname", "ERROR")
        val user_lname = preferences.getString("user_Lname", "ERROR")
        val user_username = preferences.getString("user_username", "ERROR")
        val user_email = preferences.getString("user_email", "ERROR")


        val customerData = db?.customersDao()?.getByDetails(user_fname!!,user_lname!!,user_username!!,user_email!!)
        val customerID = customerData?.getId()

        var fnameCI = findViewById<EditText>(R.id.fnameMainCI)
        var lnameCI = findViewById<EditText>(R.id.lnameMainCI)
        var usernameCI = findViewById<EditText>(R.id.usernameMainCI)
        var emailCI = findViewById<EditText>(R.id.emailMainCI)
        var addressCI = findViewById<EditText>(R.id.addressMainCI)
        var cityCI = findViewById<EditText>(R.id.cityMainCI)
        var postalCI = findViewById<EditText>(R.id.postalMainCI)
        var phoneCI = findViewById<EditText>(R.id.phoneMainCI)

        fnameCI.setText(customerData?.firstname)
        lnameCI.setText(customerData?.lastname)
        usernameCI.setText(customerData?.getUsername())
        emailCI.setText(customerData?.getEmail())
        addressCI.setText(customerData?.getAddress())
        cityCI.setText(customerData?.getCity())
        postalCI.setText(customerData?.getPostal())
        phoneCI.setText(customerData?.getPhone())

    }
}