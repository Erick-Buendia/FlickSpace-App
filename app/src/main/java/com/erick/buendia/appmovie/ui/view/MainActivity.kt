package com.erick.buendia.appmovie.ui.view

import android.os.Bundle
import android.util.Log

import androidx.activity.enableEdgeToEdge

import androidx.appcompat.app.AppCompatActivity

import androidx.fragment.app.commit
import androidx.fragment.app.add
import androidx.fragment.app.replace


import com.erick.buendia.appmovie.databinding.ActivityMainBinding

import com.erick.buendia.appmovie.R
import com.google.android.material.bottomnavigation.BottomNavigationView

import com.google.android.material.navigation.NavigationBarMenuView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.menuBtn.setOnItemSelectedListener(navListener)

        if (savedInstanceState == null) {
            binding.menuBtn.setSelectedItemId(R.id.item_movie);
        }
    }

    private val navListener = NavigationBarView.OnItemSelectedListener {
        when (it.itemId) {
            R.id.item_movie -> {
             //   Log.d("Frament", "Entra a este fragmen movie")
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace<MovieFragment>(R.id.frame_main)
                }
            }

            R.id.item_series -> {
              //  Log.d("Frament", "Entra a este fragmen")
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace<TvFragment>(R.id.frame_main)
                }
            }
        }
        true
    }

}