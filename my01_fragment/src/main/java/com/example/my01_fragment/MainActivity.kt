package com.example.my01_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.my01_fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstFragment = FragmentOne()
        val secondFragment = FragmentTwo()
        val thirdFragment = FragmentThree()

        setCurrentFragment(firstFragment)

        binding.bottomNaviView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.first -> setCurrentFragment(firstFragment)
                R.id.second -> setCurrentFragment(secondFragment)
                R.id.third -> setCurrentFragment(thirdFragment)
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(binding.flFragment.id, fragment)
            commit()
        }

}