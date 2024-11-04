package com.example.speedstormapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvRacer: RecyclerView
    private val list = ArrayList<Racer>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvRacer = findViewById(R.id.rv_racer)
        rvRacer.setHasFixedSize(true)
        list.addAll(getListRacer())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
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
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListRacer(): ArrayList<Racer> {
        val dataName = resources.getStringArray(R.array.data_name)
        val datadescription = resources.getStringArray(R.array.data_description)
        val dataphoto = resources.getStringArray(R.array.data_photo)
        val listRacer = ArrayList<Racer>()
        for (i in dataName.indices) {
            val racer = Racer(dataName[i], datadescription[i], dataphoto[i])
            listRacer.add(racer)
        }
        return listRacer
    }

    private fun showRecyclerList() {
        rvRacer.layoutManager = LinearLayoutManager(this)
        val listRacerAdapter = ListRacerAdapter(list)
        rvRacer.adapter = listRacerAdapter

        listRacerAdapter.setOnItemClickCallback(object : ListRacerAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Racer) {
                showSelectedRacer(data)
            }
        })
    }

    private fun showSelectedRacer(racer: Racer) {
        Toast.makeText(this, "Kamu memilih " + racer.name, Toast.LENGTH_SHORT).show()
    }
}
