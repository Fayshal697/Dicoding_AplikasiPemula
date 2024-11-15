package com.example.speedstormapp

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.MenuItem
import android.widget.Adapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvRacer: RecyclerView
    private val list = ArrayList<Racer>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(2000)
        val splashScreen = installSplashScreen()
        setContentView(R.layout.activity_main)
        rvRacer = findViewById(R.id.rv_racer)
        rvRacer.setHasFixedSize(true)
        list.addAll(getListRacer())
        showRecyclerList()
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvRacer.layoutManager = GridLayoutManager(this, 2)
        } else {
            rvRacer.layoutManager = LinearLayoutManager(this)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvRacer.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvRacer.layoutManager = GridLayoutManager(this, 2)
            }
            R.id.about_page -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListRacer(): ArrayList<Racer> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listRacer = ArrayList<Racer>()
        for (i in dataName.indices) {
            val racer = Racer(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listRacer.add(racer)
        }
        return listRacer
    }

    private fun showRecyclerList() {
        rvRacer.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = Adapter(list)
        rvRacer.adapter = listHeroAdapter
    }

}