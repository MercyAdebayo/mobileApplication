package com.example.mercyadebayo_comp304sec001_lab02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class ProductSelectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_select)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_product_type, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.m_appliances -> {
                intent = Intent(applicationContext, AppliancesActivity::class.java)
                startActivity(intent)
            }
            R.id.m_tvs -> {
                intent = Intent(applicationContext, TVsActivity::class.java)
                startActivity(intent)
            }
            R.id.m_computers -> {
                intent = Intent(applicationContext, ComputersActivity::class.java)
                startActivity(intent)
            }
            R.id.m_furniture -> {
                intent = Intent(applicationContext, FurnitureActivity::class.java)
                startActivity(intent)
            }
            R.id.m_auto_accessories -> {
                intent = Intent(applicationContext, AutoAccessoriesActivity::class.java)
                startActivity(intent)
            }

        }
        return super.onOptionsItemSelected(item)
    }
}