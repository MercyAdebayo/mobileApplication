package com.example.mercyadebayo_comp304sec001_lab02

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CheckOutActivity : AppCompatActivity() {

    private val sharedPreferenceFile = "kotlinsharedpreference"
    @SuppressLint("ResourceType")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_out)
        val recyclerView = findViewById<RecyclerView>(R.id.productRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        //val selectedProducts = // Populate this list with selected products
            //recyclerView.adapter = ProductAdapter(selectedProducts)
        val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPreferenceFile, Context.MODE_PRIVATE)

        clearSharedPreferences()
        // val selectProduct = findViewById<View>(R.id.select)
    }
    private fun clearSharedPreferences() {
        // Clear the shared preferences file
        val sharedPref = getSharedPreferences(sharedPreferenceFile, Context.MODE_PRIVATE)
        sharedPref.edit().clear().apply()
    }
}