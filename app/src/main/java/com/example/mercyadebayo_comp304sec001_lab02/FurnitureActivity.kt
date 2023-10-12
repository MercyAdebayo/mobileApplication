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

class FurnitureActivity : AppCompatActivity() {
    private val sharedPreferenceFile = "kotlinsharedpreference"

    private var checkBoxFurniture1: CheckBox? = null
    private var checkBoxFurniture2: CheckBox? = null
    private var checkBoxFurniture3: CheckBox? = null
    private var checkBoxFurniture4: CheckBox? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_furniture)

        checkBoxFurniture1 = findViewById<CheckBox>(R.id.checkBoxFurniture1)
        checkBoxFurniture2 = findViewById<CheckBox>(R.id.checkBoxFurniture2)
        checkBoxFurniture3 = findViewById<CheckBox>(R.id.checkBoxFurniture3)
        checkBoxFurniture4 = findViewById<CheckBox>(R.id.checkBoxFurniture4)
        val checkoutBtn = findViewById<Button>(R.id.checkOut_Btn)

        val actionBar: android.app.ActionBar? = getActionBar()
        if (actionBar != null) {

            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setDisplayShowHomeEnabled(true)
            actionBar.show()
        }

        var title = "Furnitures"
        checkoutBtn.setOnClickListener {

            check(it);
            intent = Intent(applicationContext, CheckOutActivity::class.java)

            //intent.putExtra("selected",result)
            intent.putExtra("title", title)
            startActivity(intent)
        }
    }

    fun check(view: View?) {
        val myPreference = getSharedPreferences("info", 0)
        //prepare it for edit by creating an Edit object
        val preferenceEditor = myPreference.edit()

        //checking and saving info from checkboxes
        val furniture1State = checkBoxFurniture1!!.isChecked
        val furniture2State = checkBoxFurniture2!!.isChecked
        val furniture3State = checkBoxFurniture3!!.isChecked
        val furniture4State = checkBoxFurniture4!!.isChecked

        preferenceEditor.putBoolean("furniture1State", furniture1State)
        preferenceEditor.putString("furniture1Name", checkBoxFurniture1!!.text as String?)
        preferenceEditor.putBoolean("furniture2State", furniture2State)
        preferenceEditor.putString("furniture2Name", checkBoxFurniture2!!.text as String?)
        preferenceEditor.putBoolean("furniture3State", furniture3State)
        preferenceEditor.putString("furniture3Name", checkBoxFurniture3!!.text as String?)
        preferenceEditor.putBoolean("furniture4State", furniture4State)
        preferenceEditor.putString("furniture4Name", checkBoxFurniture4!!.text as String?)

        preferenceEditor.commit()
        Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_product_type, menu)
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