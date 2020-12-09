package com.example.abdelrahmantealab_mapd711_project

import android.app.Service
import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaPlayer
import android.os.IBinder
import android.preference.PreferenceManager
import android.widget.Toast


class BackgroundSoundService : Service() {
    var mediaPlayer: MediaPlayer? = null
    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        mediaPlayer = MediaPlayer.create(this, R.raw.bgm)
        mediaPlayer!!.isLooping = true
        mediaPlayer!!.setVolume(100f, 100f)
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val preferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        val editor = preferences.edit()
        editor.putBoolean("BgmOn", true)
        editor.commit()
        mediaPlayer!!.start()
        Toast.makeText(applicationContext, "Playing background music", Toast.LENGTH_SHORT).show()
        return startId
    }

    override fun onStart(intent: Intent, startId: Int) {}
    override fun onDestroy() {
        val preferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        val editor = preferences.edit()
        editor.putBoolean("BgmOn", false)
        editor.commit()
        Toast.makeText(applicationContext, "Background music stopped", Toast.LENGTH_SHORT).show()
        mediaPlayer!!.stop()
        mediaPlayer!!.release()
    }

    override fun onLowMemory() {}
}