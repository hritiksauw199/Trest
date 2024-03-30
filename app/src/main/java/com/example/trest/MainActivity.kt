package com.example.trest

import IngredientsManager
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import androidx.activity.ComponentActivity
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform

class MainActivity : ComponentActivity() {

    val selectedIngredients = mutableListOf<String>()
    private val ingredientsManager = IngredientsManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Here the checkbox variable are initialized
        val checkBox1 = findViewById<CheckBox>(R.id.checkBox1)
        val checkBox2 = findViewById<CheckBox>(R.id.checkBox2)
        val checkBox3 = findViewById<CheckBox>(R.id.checkBox3)
        val checkBox4 = findViewById<CheckBox>(R.id.checkBox4)
        val checkBox5 = findViewById<CheckBox>(R.id.checkBox5)
        val checkBox6 = findViewById<CheckBox>(R.id.checkBox6)
        val checkBox7 = findViewById<CheckBox>(R.id.checkBox7)
        val checkBox8 = findViewById<CheckBox>(R.id.checkBox8)
        val recipesButton = findViewById<Button>(R.id.button)


        // This add the ingredients value if it is checked
        val checkBoxClickListener = View.OnClickListener { view ->
            val checkBox = view as CheckBox
            val isChecked = checkBox.isChecked
            val ingredient = checkBox.text.toString()

            ingredientsManager.updateSelectedIngredients(selectedIngredients, ingredient, isChecked)
        }

        // This generates a click sound when the checkbox is selected
        checkBox1.setOnClickListener(checkBoxClickListener)
        checkBox2.setOnClickListener(checkBoxClickListener)
        checkBox3.setOnClickListener(checkBoxClickListener)
        checkBox4.setOnClickListener(checkBoxClickListener)
        checkBox5.setOnClickListener(checkBoxClickListener)
        checkBox6.setOnClickListener(checkBoxClickListener)
        checkBox7.setOnClickListener(checkBoxClickListener)
        checkBox8.setOnClickListener(checkBoxClickListener)

        //The items are added in a list and sent to next activity
        recipesButton.setOnClickListener {
            val intent = Intent(this, RecipeTab::class.java)
            intent.putStringArrayListExtra("selectedIngredients", ArrayList(selectedIngredients))
            startActivity(intent)
        }
    }

}