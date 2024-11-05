package com.example.speedstormapp

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.speedstormapp.GridFragment
import com.example.speedstormapp.AboutFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var rvRacer: RecyclerView
    private val list = ArrayList<Racer>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(2000)
        val splashScreen = installSplashScreen()
        setContentView(R.layout.activity_main)

        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val tabLayout: TabLayout = findViewById(R.id.tabLayout)

        // Set adapter untuk ViewPager
        viewPager.adapter = ViewPagerAdapter(this)

        // Hubungkan TabLayout dengan ViewPager
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "List"
                1 -> "Grid"
                2 -> "About"
                else -> null
            }
        }.attach()
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
            val racer = Racer(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1).toString())
            listRacer.add(racer)
        }
        return listRacer
    }

    private fun showRecyclerList() {
        rvRacer.layoutManager = LinearLayoutManager(this)
        val listRacerAdapter = ListRacerAdapter(list)
        rvRacer.adapter = listRacerAdapter
    }

    private fun showSelectedRacer(racer: Racer) {
        Toast.makeText(this, "Kamu memilih " + racer.name, Toast.LENGTH_SHORT).show()
    }

}

class ViewPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ListFragment()
            1 -> GridFragment()
            2 -> AboutFragment()
            else -> throw IllegalStateException("Unexpected position $position")
        }
    }
}
