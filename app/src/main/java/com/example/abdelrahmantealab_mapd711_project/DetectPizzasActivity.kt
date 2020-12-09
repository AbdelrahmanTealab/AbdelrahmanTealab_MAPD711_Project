package com.example.abdelrahmantealab_mapd711_project

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.HashMap

class DetectPizzasActivity : AppCompatActivity() {
    var northYorkPizzas: HashMap<String, String> = HashMap<String,String>()
    var torontoDowntownPizzas: HashMap<String, String> = HashMap<String,String>()
    var scarboroughPizzas: HashMap<String, String> = HashMap<String,String>()
    var mississaugaPizzas: HashMap<String, String> = HashMap<String,String>()
    var oakvillePizzas: HashMap<String, String> = HashMap<String,String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detect_pizzas)
        northYorkPizzas.put("Pizzaiolo Gourmet Pizza", "4920 Yonge St, North York, ON M2N 5N5")
        northYorkPizzas.put("Blaze Pizza", "4841 Yonge St, Toronto, ON M2N 5X2")
        northYorkPizzas.put("Pizza Pizza", "618 Sheppard Ave W, North York, ON M3H 2S1")
        northYorkPizzas.put("Domino's Pizza", "201 Sheppard Ave E, North York, ON M2N 3A8")
        northYorkPizzas.put("Mamma's Pizza", "4903 Yonge St, North York, ON M2N 5N6")
        northYorkPizzas.put("Boston Pizza", "100-5170 Yonge St, North York, ON M2N 0G1")
        northYorkPizzas.put("IL FORNELLO - Bayview Village", "2901 Bayview Ave, North York, ON M2K 2S3")
        northYorkPizzas.put("Express Pizza", "4917 Bathurst St, North York, ON M2R 1X8")

        torontoDowntownPizzas.put("Cora Pizza","656 Spadina Ave A, Toronto, ON M5S 2H7")
        torontoDowntownPizzas.put("Village Pizza", "761 Dundas St W, Toronto, ON M6J 1T9")
        torontoDowntownPizzas.put("North of Brooklyn Pizzeria", "469 Church St, Toronto, ON M4Y 2C5")
        torontoDowntownPizzas.put("Pizzeria Via Mercanti", "87 Elm St, Toronto, ON M5G 1X8")
        torontoDowntownPizzas.put("Pizzeria Libretto University", "155 University Ave, Toronto, ON M5H 3B7")
        torontoDowntownPizzas.put("Panago Pizza", "44 Gerrard St W, Toronto, ON M5G 2K2")
        torontoDowntownPizzas.put("Pizzaiolo Gourmet Pizza", "270 Adelaide St W, Toronto, ON M5H 1X6")
        torontoDowntownPizzas.put("Blaze Pizza", "10 Dundas St E #124, Toronto, ON M5B 2G9")

        scarboroughPizzas.put("Pizza Nova", "2201 Ellesmere Rd, Scarborough, ON M1G 3M6")
        scarboroughPizzas.put("Double Double Pizza & Chicken", "1221 Markham Rd #12, Scarborough, ON M1H 3E2")
        scarboroughPizzas.put("Pizza Depot", "2060 Ellesmere Rd, Scarborough, ON M1H 3B7")
        scarboroughPizzas.put("Gino's Pizza", "900 Progress Ave, Scarborough, ON M1H 2Z9")
        scarboroughPizzas.put("La Sani Grill", "2058 Ellesmere Rd #3, Scarborough, ON M1H 2V6")
        scarboroughPizzas.put("Canbe Foods Inc", "1760 Ellesmere Rd, Scarborough, ON M1H 2T9")
        scarboroughPizzas.put("The Real McCoy", "1033 Markham Rd, Toronto, ON M1H 2G1")
        scarboroughPizzas.put("Gerhard's Cafe", "1085 Bellamy Rd N, Scarborough, ON M1H 3C7")

        mississaugaPizzas.put("Domino's Pizza", "20 Kingsbridge Garden Cir, Mississauga, ON L5R 3K6")
        mississaugaPizzas.put("3 For 2 Pizza & Wings", "4646 Heritage Hills Blvd, Mississauga, ON L5R 1N4")
        mississaugaPizzas.put("Pizza Nova", "660 Eglinton Ave W, Mississauga, ON L5R 3V2")
        mississaugaPizzas.put("Pizza Hut", "848 Burnhamthorpe Rd W, Mississauga, ON L5C 2S3")
        mississaugaPizzas.put("Double Double Pizza and Chicken", "3095 Hurontario St, Mississauga, ON L5B 1N7")
        mississaugaPizzas.put("Boston Pizza", "35 Square One Dr, Mississauga, ON L5B 0E2")
        mississaugaPizzas.put("Popular Pizza", "5380 Terry Fox Way, Mississauga, ON L5V 0A5")
        mississaugaPizzas.put("Pizza Pros", "223 Ceremonial Dr, Mississauga, ON L5R 2N8")

        oakvillePizzas.put("Domino's Pizza", "380 Iroquois Shore Rd, Oakville, ON L6H 1M4")
        oakvillePizzas.put("Panago Pizza", "321 Cornwall Rd, Oakville, ON L6J 7Z5")
        oakvillePizzas.put("Topper's Pizza - Oakville", "220 North Service Rd W, Oakville, ON L6M 2T3")
        oakvillePizzas.put("Vili's Pizza & Wings", "562 Kerr St, Oakville, ON L6K 3C7")
        oakvillePizzas.put("Oakville Pizzeria - Authentic Afghan bakery", "404 Kerr St, Oakville, ON L6K 3C1")
        oakvillePizzas.put("Gino's Pizza", "1289 Marlborough Ct, Oakville, ON L6H 2N7")
        oakvillePizzas.put("Pizzaville", "2163 Sixth Line, Oakville, ON L6H 3N7")
        oakvillePizzas.put("Martino's Pizza & Wings", "201 River Oaks Blvd W, Oakville, ON L6H 3S7")
    }

    fun citySelected(view: View){
        val button = view as Button
        val city = button.text.toString()
        println(city)
        var cityPizzas: HashMap<String, String> = HashMap<String,String>()
        if (city == "North York") {cityPizzas=northYorkPizzas}
        else if (city == "Toronto Downtown") {cityPizzas=torontoDowntownPizzas}
        else if (city == "Scarborough") {cityPizzas=scarboroughPizzas}
        else if (city == "Mississauga") {cityPizzas=mississaugaPizzas}
        else if (city == "Oakville") {cityPizzas=oakvillePizzas}

        val intent = Intent(this, MapsActivity::class.java).apply {
            putExtra("city",city)
            putExtra("cityPizzas",cityPizzas)
        }
        startActivity(intent)
    }

}