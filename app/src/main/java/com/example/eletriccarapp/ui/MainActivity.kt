package com.example.eletriccarapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.eletriccarapp.R
import com.example.eletriccarapp.data.CarFactory
import com.example.eletriccarapp.ui.adapter.CarAdapter
import com.example.eletriccarapp.ui.adapter.TabAdapter
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Lifecycle", "Create")

        setupview()
        setupTabs()
    }

    override fun onResume() {
        super.onResume()
        Log.d("Lifecycle", "Resume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Lifecycle", "Restart")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Lifecycle", "Pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Lifecycle", "Stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Lifecycle", "Destroy")
    }

    fun setupview() {
        tabLayout = findViewById(R.id.tab_layout)
        viewPager = findViewById(R.id.vt_view_page)
    }

    fun setupTabs() {
    val tabsAdapter = TabAdapter(this)
        viewPager.adapter = tabsAdapter
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    viewPager.currentItem = it.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabLayout.getTabAt(position)?.select()
            }
        })
    }

}