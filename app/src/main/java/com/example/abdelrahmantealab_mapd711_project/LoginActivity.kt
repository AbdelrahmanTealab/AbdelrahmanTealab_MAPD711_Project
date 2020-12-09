package com.example.abdelrahmantealab_mapd711_project

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    var db: AADatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        db = AADatabase.getInstance(applicationContext)
    }

    fun loginPressed(view: View) {
        var username: EditText = findViewById(R.id.email)
        var password: EditText = findViewById(R.id.password)

        if ((username.text.toString().isEmpty() || username.text.toString().length < 4)  && !password.text.toString().isEmpty())
        {
            Toast.makeText(this,"Please enter a valid username of at least 4 characters", Toast.LENGTH_SHORT).show()
            username.background.setTint((Color.parseColor("#66ff0f0f")))
            username.setTextColor(Color.parseColor("#ff0f0f"))
            password.background.setTint((Color.parseColor("#ffffff")))
            password.setTextColor(resources.getColor(R.color.radarGreen))
        }
        else if (password.text.toString().isEmpty() && (!username.text.toString().isEmpty() && username.text.toString().length >= 4))
        {
            Toast.makeText(this,"Please enter your password", Toast.LENGTH_SHORT).show()
            password.background.setTint((Color.parseColor("#66ff0f0f")))
            password.setTextColor(Color.parseColor("#ff0f0f"))
            username.background.setTint((Color.parseColor("#ffffff")))
            username.setTextColor(resources.getColor(R.color.radarGreen))
        }

        else if (password.text.toString().isEmpty() && (username.text.toString().isEmpty() || username.text.toString().length < 4))
        {
            Toast.makeText(this,"Please enter your login information", Toast.LENGTH_SHORT).show()
            password.background.setTint((Color.parseColor("#66ff0f0f")))
            password.setTextColor(Color.parseColor("#ff0f0f"))
            username.background.setTint((Color.parseColor("#66ff0f0f")))
            username.setTextColor(Color.parseColor("#ff0f0f"))
        }

        else {
            val dbUser = db?.customersDao()?.getByUsername(username.text.toString())
            val dbUsername = dbUser?.getUsername()
            val dbPass = dbUser?.getPassword()

            if (username.text.toString() == dbUsername && password.text.toString() == dbPass) {
                val dbId = dbUser?.getId()
                val dbFirstname = dbUser?.firstname
                val dbLastname = dbUser?.lastname
                val dbEmail = dbUser?.getEmail()
                val dbAddress = dbUser?.getAddress()
                val dbCity = dbUser?.getCity()
                val dbPostal = dbUser?.getPostal()
                val dbPhonenumber = dbUser?.getPhone()

                val preferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
                val editor = preferences.edit()
                editor.putInt("user_Id", dbId)
                editor.putString("user_username", dbUsername)
                editor.putString("user_password", dbPass)
                editor.putString("user_Fname", dbFirstname)
                editor.putString("user_Lname", dbLastname)
                editor.putString("user_email", dbEmail)
                editor.putString("user_address", dbAddress)
                editor.putString("user_city", dbCity)
                editor.putString("user_postal", dbPostal)
                editor.putString("user_phone", dbPhonenumber)
                editor.commit()

                val intent = Intent(this, MainActivity::class.java).apply {
                }
                startActivity(intent)
            }
            else if (username.text.toString() == dbUsername && password.text.toString() != dbPass){
                val toast = Toast.makeText(applicationContext, "Incorrect password", Toast.LENGTH_SHORT)
                toast.show()
                password.background.setTint(Color.parseColor("#66ff0f0f"))
                password.setTextColor(Color.parseColor("#ff0f0f"))
                username.background.setTint((Color.parseColor("#ffffff")))
                username.setTextColor(resources.getColor(R.color.radarGreen))
            }
            else {
                val toast = Toast.makeText(applicationContext, "User not found", Toast.LENGTH_SHORT)
                toast.show()
                username.background.setTint(Color.parseColor("#66ff0f0f"))
                password.background.setTint((Color.parseColor("#66ff0f0f")))
                username.setTextColor(Color.parseColor("#ff0f0f"))
                password.setTextColor(Color.parseColor("#ff0f0f"))
            }
        }


    }

    fun loginAsAdminPressed(view: View) {
        var username: EditText = findViewById(R.id.email)
        var password: EditText = findViewById(R.id.password)

        if ((username.text.toString().isEmpty() || username.text.toString().length < 4)  && !password.text.toString().isEmpty())
        {
            Toast.makeText(this,"Please enter a valid username of at least 4 characters", Toast.LENGTH_SHORT).show()
            username.background.setTint((Color.parseColor("#66ff0f0f")))
            username.setTextColor(Color.parseColor("#ff0f0f"))
            password.background.setTint((Color.parseColor("#ffffff")))
            password.setTextColor(resources.getColor(R.color.radarGreen))
        }
        else if (password.text.toString().isEmpty() && (!username.text.toString().isEmpty() && username.text.toString().length >= 4))
        {
            Toast.makeText(this,"Please enter your password", Toast.LENGTH_SHORT).show()
            password.background.setTint((Color.parseColor("#66ff0f0f")))
            password.setTextColor(Color.parseColor("#ff0f0f"))
            username.background.setTint((Color.parseColor("#ffffff")))
            username.setTextColor(resources.getColor(R.color.radarGreen))
        }
        else if (password.text.toString().isEmpty() && (username.text.toString().isEmpty() || username.text.toString().length < 4))
        {
            Toast.makeText(this,"Please enter your login information", Toast.LENGTH_SHORT).show()
            password.background.setTint((Color.parseColor("#66ff0f0f")))
            password.setTextColor(Color.parseColor("#ff0f0f"))
            username.background.setTint((Color.parseColor("#66ff0f0f")))
            username.setTextColor(Color.parseColor("#ff0f0f"))
        }
        else {
            val dbUser = db?.adminsDao()?.getAdminByUsername(username.text.toString())
            val dbUsername = dbUser?.getUsername()
            val dbPass = dbUser?.getPassword()

            if (username.text.toString() == dbUsername && password.text.toString() == dbPass) {
                val dbId = dbUser?.getId()
                val dbFirstname = dbUser?.firstname
                val dbLastname = dbUser?.lastname

                val preferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
                val editor = preferences.edit()
                editor.putInt("user_Id", dbId)
                editor.putString("user_Fname", dbFirstname)
                editor.putString("user_Lname", dbLastname)
                editor.putString("user_username", dbUsername)

                editor.commit()

                val intent = Intent(this, AdminActivity::class.java).apply {
                }
                startActivity(intent)
            } else if (username.text.toString() == dbUsername && password.text.toString() != dbPass) {
                val toast =
                    Toast.makeText(applicationContext, "Incorrect password", Toast.LENGTH_SHORT)
                toast.show()
                password.background.setTint(Color.parseColor("#66ff0f0f"))
                password.setTextColor(Color.parseColor("#ff0f0f"))
                username.background.setTint((Color.parseColor("#ffffff")))
                username.setTextColor(resources.getColor(R.color.radarGreen))
            } else {
                val toast =
                    Toast.makeText(applicationContext, "User not found", Toast.LENGTH_SHORT)
                toast.show()
                username.background.setTint(Color.parseColor("#66ff0f0f"))
                password.background.setTint((Color.parseColor("#66ff0f0f")))
                username.setTextColor(Color.parseColor("#ff0f0f"))
                password.setTextColor(Color.parseColor("#ff0f0f"))
            }
        }

    }

    fun needAnewAccountPressed(view: View){
        val intent = Intent(this, RegisterActivity::class.java).apply {
        }
        startActivity(intent)
    }
}