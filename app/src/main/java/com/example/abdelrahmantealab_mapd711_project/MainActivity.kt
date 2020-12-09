package com.example.abdelrahmantealab_mapd711_project

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.animation.AlphaAnimation
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var db: AADatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        db = AADatabase.getInstance(applicationContext)
        var clickHereImage: ImageView = findViewById(R.id.clickhere)
        clickHereImage.alpha = 0F
    }
    fun logOut(){

    }
    fun bgmPressed(view: View){
        val intentBGM = Intent(this@MainActivity, BackgroundSoundService::class.java)
        val preferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        val BgmOn = preferences.getBoolean("BgmOn", false)
        if (BgmOn){
            stopService(intentBGM)
            val preferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
            val editor = preferences.edit()
            editor.putBoolean("BgmOn", false)
            editor.commit()
        }
        else{
            startService(intentBGM)
            val preferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
            val editor = preferences.edit()
            editor.putBoolean("BgmOn", true)
            editor.commit()
        }
    }
    fun orderPressed(view: View){
        var clickHereImage: ImageView = findViewById(R.id.clickhere)
        clickHereImage.alpha = 1F

        val animation1 = AlphaAnimation(1f, 0f)
        animation1.duration = 1000
        animation1.startOffset = 2400
        animation1.fillAfter = true
        clickHereImage.startAnimation(animation1)
    }
    fun accountPressed(view: View){
        val intent = Intent(this, AccountActivity::class.java).apply {
        }
        startActivity(intent)
    }
    fun detectPizzasPressed(view: View){
        val intent = Intent(this, DetectPizzasActivity::class.java).apply {
        }
        startActivity(intent)
    }    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var inflater: MenuInflater = getMenuInflater();
        inflater.inflate(R.menu.pizza_menu, menu)
        return true;
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        //i take the ID of the item and depending on what the item is then pass on the variables to the next activity
        when (item.itemId) {

            R.id.smallMeatSupreme -> {
                val intent = Intent(this, Toppings::class.java).apply {
                    putExtra("pizzaType", "Meat Supreme")
                    putExtra("pizzaSize", "Small")
                }
                startActivity(intent)
            }
            R.id.mediumMeatSupreme -> {
                val intent = Intent(this, Toppings::class.java).apply {
                    putExtra("pizzaType", "Meat Supreme")
                    putExtra("pizzaSize", "Medium")
                }
                startActivity(intent)
            }
            R.id.largeMeatSupreme -> {
                val intent = Intent(this, Toppings::class.java).apply {
                    putExtra("pizzaType", "Meat Supreme")
                    putExtra("pizzaSize", "Large")
                }
                startActivity(intent)
            }

            R.id.smallSuperHawaiian -> {
                val intent = Intent(this, Toppings::class.java).apply {
                    putExtra("pizzaType", "Super Hawaiian")
                    putExtra("pizzaSize", "Small")
                }
                startActivity(intent)
            }
            R.id.mediumSuperHawaiian -> {
                val intent = Intent(this, Toppings::class.java).apply {
                    putExtra("pizzaType", "Super Hawaiian")
                    putExtra("pizzaSize", "Medium")
                }
                startActivity(intent)
            }
            R.id.largeSuperHawaiian -> {
                val intent = Intent(this, Toppings::class.java).apply {
                    putExtra("pizzaType", "Super Hawaiian")
                    putExtra("pizzaSize", "Large")
                }
                startActivity(intent)
            }

            R.id.smallVeggie -> {
                val intent = Intent(this, Toppings::class.java).apply {
                    putExtra("pizzaType", "Veggie")
                    putExtra("pizzaSize", "Small")
                }
                startActivity(intent)
            }
            R.id.mediumVeggie -> {
                val intent = Intent(this, Toppings::class.java).apply {
                    putExtra("pizzaType", "Veggie")
                    putExtra("pizzaSize", "Medium")
                }
                startActivity(intent)
            }
            R.id.largeVeggie -> {
                val intent = Intent(this, Toppings::class.java).apply {
                    putExtra("pizzaType", "Veggie")
                    putExtra("pizzaSize", "Large")
                }
                startActivity(intent)
            }

            R.id.smallMediterranean -> {
                val intent = Intent(this, Toppings::class.java).apply {
                    putExtra("pizzaType", "Mediterranean")
                    putExtra("pizzaSize", "Small")
                }
                startActivity(intent)
            }
            R.id.mediumMediterranean -> {
                val intent = Intent(this, Toppings::class.java).apply {
                    putExtra("pizzaType", "Mediterranean")
                    putExtra("pizzaSize", "Medium")
                }
                startActivity(intent)
            }
            R.id.largeMediterranean -> {
                val intent = Intent(this, Toppings::class.java).apply {
                    putExtra("pizzaType", "Mediterranean")
                    putExtra("pizzaSize", "Large")
                }
                startActivity(intent)
            }

            R.id.smallCheddar -> {
                val intent = Intent(this, Toppings::class.java).apply {
                    putExtra("pizzaType", "Cheddar Supreme")
                    putExtra("pizzaSize", "Small")
                }
                startActivity(intent)
            }
            R.id.mediumCheddar -> {
                val intent = Intent(this, Toppings::class.java).apply {
                    putExtra("pizzaType", "Cheddar Supreme")
                    putExtra("pizzaSize", "Medium")
                }
                startActivity(intent)
            }
            R.id.largeCheddar -> {
                val intent = Intent(this, Toppings::class.java).apply {
                    putExtra("pizzaType", "Cheddar Supreme")
                    putExtra("pizzaSize", "Large")
                }
                startActivity(intent)
            }
            //this line is just for debugging
            else -> print("unknown")
        }
        return super.onOptionsItemSelected(item)
    }

}