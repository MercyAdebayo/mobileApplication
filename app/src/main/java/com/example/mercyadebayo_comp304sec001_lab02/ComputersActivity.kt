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

class ComputersActivity : AppCompatActivity() {
    private val sharedPreferenceFile = "kotlinsharedpreference"

    private var checkBoxComputer1: CheckBox? = null
    private var checkBoxComputer2: CheckBox? = null
    private var checkBoxComputer3: CheckBox? = null
    private var checkBoxComputer4: CheckBox? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_computers)
        checkBoxComputer1 = findViewById<CheckBox>(R.id.checkBoxComp1)
        checkBoxComputer2 = findViewById<CheckBox>(R.id.checkBoxComp2)
        checkBoxComputer3 = findViewById<CheckBox>(R.id.checkBoxComp3)
        checkBoxComputer4 = findViewById<CheckBox>(R.id.checkBoxComp4)
        val checkoutBtn = findViewById<Button>(R.id.checkOut_Btn)

        val actionBar: android.app.ActionBar? = getActionBar()
        if (actionBar != null) {

            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setDisplayShowHomeEnabled(true)
            actionBar.show()
        }

        var title = "Computers"
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
        val comp1State = checkBoxComputer1!!.isChecked
        val comp2State = checkBoxComputer2!!.isChecked
        val comp3State = checkBoxComputer3!!.isChecked
        val comp4State = checkBoxComputer4!!.isChecked

        preferenceEditor.putBoolean("comp1State", comp1State)
        preferenceEditor.putString("comp1Name", checkBoxComputer1!!.text as String?)
        preferenceEditor.putBoolean("comp2State",comp2State)
        preferenceEditor.putString("comp2Name", checkBoxComputer2!!.text as String?)
        preferenceEditor.putBoolean("comp3State", comp3State)
        preferenceEditor.putString("comp3Name",checkBoxComputer3!!.text as String?)
        preferenceEditor.putBoolean("comp4State", comp4State)
        preferenceEditor.putString("comp4Name", checkBoxComputer4!!.text as String?)

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