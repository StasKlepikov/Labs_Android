package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.example.lab1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.place_holder, FragmentCalc.newInstance())
            .commit()

        binding.btnInfo.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.place_holder, FragmentInfo.newInstance())
                .commit()
        }

        binding.btnCalc.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.place_holder, FragmentCalc.newInstance())
                .commit() }

    }
}