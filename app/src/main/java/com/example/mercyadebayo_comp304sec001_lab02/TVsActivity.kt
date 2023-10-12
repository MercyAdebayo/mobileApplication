package com.example.mercyadebayo_comp304sec001_lab02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast

class TVsActivity : AppCompatActivity() {
    private val sharedPreferenceFile = "kotlinsharedpreference"

    private var checkBoxTv1: CheckBox? = null
    private var checkBoxTv2: CheckBox? = null
    private var checkBoxTv3: CheckBox? = null
    private var checkBoxTv4: CheckBox? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tvs)
        checkBoxTv1 = findViewById<CheckBox>(R.id.checkBoxTv1)
        checkBoxTv2 = findViewById<CheckBox>(R.id.checkBoxTv2)
        checkBoxTv3 = findViewById<CheckBox>(R.id.checkBoxTv3)
        checkBoxTv4 = findViewById<CheckBox>(R.id.checkBoxTv4)
        val checkoutBtn = findViewById<Button>(R.id.checkOut_Btn)

        val actionBar: android.app.ActionBar? = getActionBar()
        if (actionBar != null) {

            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setDisplayShowHomeEnabled(true)
            actionBar.show()
        }

        var title = "TVs"
        checkoutBtn.setOnClickListener {

            check(it);
            intent = Intent(applicationContext,CheckOutActivity::class.java)

            //intent.putExtra("selected",result)
            intent.putExtra("title",title)
            startActivity(intent)
        }
    }
    fun check(view: View?){
        val myPreference = getSharedPreferences("info", 0)
        //prepare it for edit by creating an Edit object
        val preferenceEditor = myPreference.edit()

        //checking and saving info from checkboxes
        val tv1State = checkBoxTv1!!.isChecked
        val tv2State = checkBoxTv2!!.isChecked
        val tv3State = checkBoxTv3!!.isChecked
        val tv4State = checkBoxTv4!!.isChecked

        preferenceEditor.putBoolean("tv1State", tv1State)
        preferenceEditor.putString("tv1Name", checkBoxTv1!!.text as String?)
        preferenceEditor.putBoolean("tv2State",tv2State)
        preferenceEditor.putString("tv2Name", checkBoxTv2!!.text as String?)
        preferenceEditor.putBoolean("tv3State", tv3State)
        preferenceEditor.putString("tv3Name",checkBoxTv3!!.text as String?)
        preferenceEditor.putBoolean("tv4State", tv4State)
        preferenceEditor.putString("tv4Name", checkBoxTv4!!.text as String?)

        preferenceEditor.commit()
        Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_product_type,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.m_appliances -> {
                check(view = null)
                intent = Intent(applicationContext, AppliancesActivity::class.java)
                startActivity(intent)
            }
            R.id.m_tvs -> {
                check(view = null)
                intent = Intent(applicationContext, TVsActivity::class.java)
                startActivity(intent)
            }
            R.id.m_computers -> {
                check(view = null)
                intent = Intent(applicationContext, ComputersActivity::class.java)
                startActivity(intent)
            }
            R.id.m_furniture -> {
                check(view = null)
                intent = Intent(applicationContext, FurnitureActivity::class.java)
                startActivity(intent)
            }
            R.id.m_auto_accessories -> {
                check(view = null)
                intent = Intent(applicationContext, AutoAccessoriesActivity::class.java)
                startActivity(intent)
            }

        }
        return super.onOptionsItemSelected(item)
    }
}