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
class AppliancesActivity : AppCompatActivity() {
    private val sharedPreferenceFile = "kotlinsharedpreference"

    private var checkBoxAppliance1: CheckBox? = null
    private var checkBoxAppliance2: CheckBox? = null
    private var checkBoxAppliance3: CheckBox? = null
    private var checkBoxAppliance4: CheckBox? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appliances)
        val checkBoxAppliance1 = findViewById<CheckBox>(R.id.checkBoxAppliance1)
        val checkBoxAppliance2 = findViewById<CheckBox>(R.id.checkBoxAppliance2)
        val checkBoxAppliance3 = findViewById<CheckBox>(R.id.checkBoxAppliance3)
        val checkBoxAppliance4 = findViewById<CheckBox>(R.id.checkBoxAppliance4)
        val checkoutBtn = findViewById<Button>(R.id.checkOut_Btn)

        val actionBar: android.app.ActionBar? = getActionBar()
        if (actionBar != null) {

            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setDisplayShowHomeEnabled(true)
            actionBar.show()
        }

        var title = "Appliances"
        checkBoxAppliance1.setOnCheckedChangeListener { buttonView, isChecked ->
            //val myProductCategories = Product
            // Add or remove the product from selected products
            if (isChecked) {
                // Checkbox is checked, add the product to the selected products
                //SelectedProductsManager.addSelectedProduct(product)
            } else {
                // Checkbox is unchecked, remove the product from the selected products
                //SelectedProductsManager.removeSelectedProduct(product)

            }

            checkBoxAppliance2.setOnCheckedChangeListener { buttonView, isChecked ->
                // Handle checkbox state change for Appliance 2
                // Add or remove the product from selected products
            }

            checkBoxAppliance3.setOnCheckedChangeListener { buttonView, isChecked ->
                // Handle checkbox state change for Appliance 2
                // Add or remove the product from selected products
            }

            checkBoxAppliance4.setOnCheckedChangeListener { buttonView, isChecked ->
                // Handle checkbox state change for Appliance 2
                // Add or remove the product from selected products
            }

            checkoutBtn.setOnClickListener {

                //check(it);
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
            val appliance1State = checkBoxAppliance1!!.isChecked
            val appliance2State = checkBoxAppliance2!!.isChecked
            val appliance3State = checkBoxAppliance3!!.isChecked
            val appliance4State = checkBoxAppliance4!!.isChecked

            preferenceEditor.putBoolean("appliance1State", appliance1State)
            preferenceEditor.putString("appliance1Name", checkBoxAppliance1!!.text as String?)
            preferenceEditor.putBoolean("appliance2State",appliance2State)
            preferenceEditor.putString("appliance2Name", checkBoxAppliance2!!.text as String?)
            preferenceEditor.putBoolean("appliance3State", appliance3State)
            preferenceEditor.putString("appliance3Name",checkBoxAppliance3!!.text as String?)
            preferenceEditor.putBoolean("appliance4State", appliance4State)
            preferenceEditor.putString("appliance4Name", checkBoxAppliance4!!.text as String?)

            preferenceEditor.commit()
            Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show()
        }

        fun onCreateOptionsMenu(menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.menu_product_type,menu)
            return super.onCreateOptionsMenu(menu)
        }
        fun onOptionsItemSelected(item: MenuItem): Boolean {
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
}