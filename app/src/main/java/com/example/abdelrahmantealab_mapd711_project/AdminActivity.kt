package com.example.abdelrahmantealab_mapd711_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.TextView
import android.widget.Toast

class AdminActivity : AppCompatActivity() {
    var db: AADatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)
        db = AADatabase.getInstance(applicationContext)

        var customerList = findViewById<TextView>(R.id.customerListView)
        customerList.text = ""
        customerList.setMovementMethod(ScrollingMovementMethod())
        db?.customersDao()?.getAllCustomers()?.forEach{
            customerList.append(
                it.firstname + " " + it.lastname +
                        "\n------\n" +
                        "ID: " + it.getId() + "\n" +
                        "Email: " + it.getEmail() + "\n" +
                        "Address: " + it.getAddress() + "\n" +
                        "City: " + it.getCity() + "\n" +
                        "Postal: " + it.getPostal() + "\n" +
                        "Phone: " + it.getPhone() + "\n" +
                        "\n------\n" +
                        "\n\n"
            )}
        customerList.setMovementMethod(ScrollingMovementMethod())
    }

    fun searchPressed(view: View){
        var customerList = findViewById<TextView>(R.id.customerListView)
        var searchName = findViewById<TextView>(R.id.searchCustomerName).text.toString()
        customerList.text = ""
        db?.customersDao()?.getByName(searchName)?.forEach{
            customerList.append(
                it.firstname + " " + it.lastname +
                        "\n------\n" +
                        "ID: " + it.getId() + "\n" +
                        "Email: " + it.getEmail() + "\n" +
                        "Address: " + it.getAddress() + "\n" +
                        "City: " + it.getCity() + "\n" +
                        "Postal: " + it.getPostal() + "\n" +
                        "Phone: " + it.getPhone() + "\n" +
                        "\n------\n" +
                        "\n\n"
            )}
        customerList.setMovementMethod(ScrollingMovementMethod())
    }
    fun resetPressed(view: View) {
        var customerList = findViewById<TextView>(R.id.customerListView)
        customerList.text = ""
        db?.customersDao()?.getAllCustomers()?.forEach{
            customerList.append(
                it.firstname + " " + it.lastname +
                        "\n------\n" +
                        "ID: " + it.getId() + "\n" +
                        "Email: " + it.getEmail() + "\n" +
                        "Address: " + it.getAddress() + "\n" +
                        "City: " + it.getCity() + "\n" +
                        "Postal: " + it.getPostal() + "\n" +
                        "Phone: " + it.getPhone() + "\n" +
                        "\n------\n" +
                        "\n\n"
            )}
        customerList.setMovementMethod(ScrollingMovementMethod())

    }

    fun deletePressed(view: View){

        var searchID = findViewById<TextView>(R.id.searchCustomerName).text.toString()
        var isNumeric = true
        isNumeric = searchID.matches("-?\\d+(\\.\\d+)?".toRegex())
        if (isNumeric)
        {
            val intID = searchID.toInt()
            db?.customersDao()?.getById(intID)
            if (db?.customersDao()?.getById(intID) != null){
                db?.customersDao()?.delete(db?.customersDao()?.getById(intID)!!)
                val toast = Toast.makeText(applicationContext, "User ID "+searchID+ " delete", Toast.LENGTH_SHORT)
                toast.show()
            }
            else{
                val toast = Toast.makeText(applicationContext, "ID not found", Toast.LENGTH_SHORT)
                toast.show()
            }
        }
        else{
            val toast = Toast.makeText(applicationContext, "ID must be a number", Toast.LENGTH_SHORT)
            toast.show()
        }
    }
}