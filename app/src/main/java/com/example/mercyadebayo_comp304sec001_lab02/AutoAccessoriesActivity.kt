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

class AutoAccessoriesActivity : AppCompatActivity() {

    private val sharedPreferenceFile = "kotlinsharedpreference"

    private var checkBoxAuto1: CheckBox? = null
    private var checkBoxAuto2: CheckBox? = null
    private var checkBoxAuto3: CheckBox? = null
    private var checkBoxAuto4: CheckBox? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auto_accessories)
        checkBoxAuto1 = findViewById<CheckBox>(R.id.checkBoxAuto1)
        checkBoxAuto2 = findViewById<CheckBox>(R.id.checkBoxAuto2)
        checkBoxAuto3 = findViewById<CheckBox>(R.id.checkBoxAuto3)
        checkBoxAuto4 = findViewById<CheckBox>(R.id.checkBoxAuto4)
        val checkoutBtn = findViewById<Button>(R.id.checkOut_Btn)

        val actionBar: android.app.ActionBar? = getActionBar()
        if (actionBar != null) {

            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setDisplayShowHomeEnabled(true)
            actionBar.show()
        }

        var title = "Auto Accessories"
        checkoutBtn.setOnClickListener {

            check(it);
            intent = Intent(applicationContext, CheckOutActivity::class.java)

            //intent.putExtra("selected",result)
            intent.putExtra("title", title)
            startActivity(intent)
        }
    }

    fun check(view: View?){
        val myPreference = getSharedPreferences("info", 0)
        //prepare it for edit by creating an Edit object
        val preferenceEditor = myPreference.edit()

        //checking and saving info from checkboxes
        val auto1State = checkBoxAuto1!!.isChecked
        val auto2State = checkBoxAuto2!!.isChecked
        val auto3State = checkBoxAuto3!!.isChecked
        val auto4State = checkBoxAuto4!!.isChecked

        preferenceEditor.putBoolean("auto1State", auto1State)
        preferenceEditor.putString("auto1Name", checkBoxAuto1!!.text as String?)
        preferenceEditor.putBoolean("auto2State",auto2State)
        preferenceEditor.putString("auto2Name", checkBoxAuto2!!.text as String?)
        preferenceEditor.putBoolean("auto3State", auto3State)
        preferenceEditor.putString("auto3Name",checkBoxAuto3!!.text as String?)
        preferenceEditor.putBoolean("auto4State", auto4State)
        preferenceEditor.putString("auto4Name", checkBoxAuto4!!.text as String?)

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