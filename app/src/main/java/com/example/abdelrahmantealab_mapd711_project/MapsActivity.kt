package com.example.abdelrahmantealab_mapd711_project



import android.location.Geocoder
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Switch
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.libraries.places.api.Places
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.util.*


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val cityName = intent.extras?.getString("city")
        var toggleButton = findViewById<Switch>(R.id.switch_view)
        toggleButton.setOnClickListener(View.OnClickListener {
            if (toggleButton.isChecked)
            {
                mMap.mapType = GoogleMap.MAP_TYPE_SATELLITE
            }
            else{
                mMap.mapType = GoogleMap.MAP_TYPE_NORMAL
            }
        })
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onMapReady(googleMap: GoogleMap) {
        //get city name and specify location and coords
        mMap = googleMap

        var cityName = intent.extras?.getString("city") + " ONTARIO"
        cityName = cityName.replace("\\s".toRegex(), "+")
        val geocoder = Geocoder(this, Locale.getDefault())
        val cityLocation = geocoder.getFromLocationName(cityName, 1)
        val cityLat = cityLocation[0].latitude
        val cityLong = cityLocation[0].longitude
        val cityCoords = LatLng(cityLat, cityLong)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cityCoords, 14F))

        val cityPizzas:HashMap<String, String> = intent.getSerializableExtra("cityPizzas") as HashMap<String, String>
        cityPizzas.forEach { (store, address) ->
            val addressLocation = geocoder.getFromLocationName(address, 1)
            val addressLat = addressLocation[0].latitude
            val addressLong = addressLocation[0].longitude
            val addressCoords = LatLng(addressLat, addressLong)
            mMap.addMarker(MarkerOptions().position(addressCoords).title(store))
        }
    }

}