package com.example.lab1

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.lab1.databinding.ActivityHistoryBinding

class History : AppCompatActivity() {
    lateinit var binding: ActivityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val results = realm.where(Result::class.java).findAll().toMutableList().map { "Sum: ${it.plus}, \n Difference: ${it.minus}, \n Product: ${it.multiply}, \n Fraction: ${it.divide}" }
        binding.lvHistory.adapter = ArrayAdapter(this, R.layout.simple_expandable_list_item_1, results)
        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "History"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}