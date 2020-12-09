package com.example.abdelrahmantealab_mapd711_project

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.children
import kotlin.reflect.typeOf

class RegisterActivity : AppCompatActivity() {
    var db: AADatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        db = AADatabase.getInstance(applicationContext)

    }

    fun registerAdminPressed(view: View){
        val linearLayout: LinearLayout = findViewById(R.id.linearLayout2)

        val firstname: String = findViewById<EditText>(R.id.firstName).text.toString()
        val lastname: String = findViewById<EditText>(R.id.lastName).text.toString()
        val username: String = findViewById<EditText>(R.id.userName).text.toString()
        val password: String = findViewById<EditText>(R.id.password).text.toString()

        var err = 0
        for (field  in linearLayout.children){
            if (field is EditText)
            {
                if (field ==  findViewById(R.id.firstName) ||field == findViewById(R.id.lastName) || field == findViewById(R.id.userName) || field == findViewById(R.id.password)){
                if(field.text.toString().isEmpty()){
                    field.background.setTint((Color.parseColor("#66ff0f0f")))
                    field.setTextColor(Color.parseColor("#ff0f0f"))
                    Toast.makeText(this, "Please enter your "+field.hint.toString(), Toast.LENGTH_SHORT).show()
                    err+=1
                }
                else{
                    field.background.setTint((Color.parseColor("#ffffff")))
                    field.setTextColor(resources.getColor(R.color.radarGreen))
                }
                }
                else{

                    field.background.setTint((Color.parseColor("#ffffff")))
                    field.setTextColor(resources.getColor(R.color.radarGreen))
                }
            }
        }
        if (err == 0){
            var admin = Admins(0,firstname,lastname,username,password)
            db?.adminsDao()?.registerAdmin(admin)
            val toast = Toast.makeText(applicationContext, "Registration successful", Toast.LENGTH_SHORT)
            toast.show()
            val intent = Intent(this, LoginActivity::class.java).apply {
            }
            startActivity(intent)
        }
    }
    fun registerPressed(view: View){
        val linearLayout: LinearLayout = findViewById(R.id.linearLayout2)

        val firstname: String = findViewById<EditText>(R.id.firstName).text.toString()
        val lastname: String = findViewById<EditText>(R.id.lastName).text.toString()
        val username: String = findViewById<EditText>(R.id.userName).text.toString()
        val address: String = findViewById<EditText>(R.id.address).text.toString()
        val city: String = findViewById<EditText>(R.id.city).text.toString()
        val postal: String = findViewById<EditText>(R.id.postal).text.toString()
        val email: String = findViewById<EditText>(R.id.email).text.toString()
        val password: String = findViewById<EditText>(R.id.password).text.toString()
        val phone: String = findViewById<EditText>(R.id.phoneNumber).text.toString()

        var err = 0
        for (field  in linearLayout.children){
            if (field is EditText)
            {
                if(field.text.toString().isEmpty()){
                    field.background.setTint((Color.parseColor("#66ff0f0f")))
                    field.setTextColor(Color.parseColor("#ff0f0f"))
                    Toast.makeText(this, "Please enter your "+field.hint.toString(), Toast.LENGTH_SHORT).show()
                    err+=1
                }
                else{
                    if (field == findViewById(R.id.email) && !Patterns.EMAIL_ADDRESS.matcher(field.text.toString()).matches())
                    {
                        field.background.setTint((Color.parseColor("#66ff0f0f")))
                        field.setTextColor(Color.parseColor("#ff0f0f"))
                        Toast.makeText(this, "Invalid "+field.hint.toString(), Toast.LENGTH_SHORT).show()
                        err+=1
                    }
                    else if (field == findViewById(R.id.phoneNumber) && !Patterns.PHONE.matcher(field.text.toString()).matches()){
                        field.background.setTint((Color.parseColor("#66ff0f0f")))
                        field.setTextColor(Color.parseColor("#ff0f0f"))
                        Toast.makeText(this, "Invalid "+field.hint.toString(), Toast.LENGTH_SHORT).show()
                        err+=1
                    }

                    else if (field == findViewById(R.id.userName) && field.text.toString().length <= 4){
                        field.background.setTint((Color.parseColor("#66ff0f0f")))
                        field.setTextColor(Color.parseColor("#ff0f0f"))
                        Toast.makeText(this, field.hint.toString() + " must be longer than 4 characters", Toast.LENGTH_SHORT).show()
                        err+=1
                    }
                    else if (field == findViewById(R.id.password) && field.text.toString().length <= 6){
                        field.background.setTint((Color.parseColor("#66ff0f0f")))
                        field.setTextColor(Color.parseColor("#ff0f0f"))
                        Toast.makeText(this, field.hint.toString() + " must be longer than 6 characters", Toast.LENGTH_SHORT).show()
                        err+=1
                    }
                    else {
                        field.background.setTint((Color.parseColor("#ffffff")))
                        field.setTextColor(resources.getColor(R.color.radarGreen))
                    }
                }
            }
        }
        if (err == 0){
            var customer = Customers(0,firstname,lastname,username,address,city,postal,email,password,phone)
            db?.customersDao()?.register(customer)
            val toast = Toast.makeText(applicationContext, "Registration successful", Toast.LENGTH_SHORT)
            toast.show()
            val intent = Intent(this, LoginActivity::class.java).apply {
            }
            startActivity(intent)
        }
    }
    fun alreadyHaveAccountPressed(view: View) {
        val intent = Intent(this, LoginActivity::class.java).apply {
        }
        startActivity(intent)
    }
}