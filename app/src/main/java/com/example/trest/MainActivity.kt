package com.example.trest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    private val selectedIngredients = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val checkBox1 = findViewById<CheckBox>(R.id.checkBox1)
        val checkBox2 = findViewById<CheckBox>(R.id.checkBox2)
        val checkBox3 = findViewById<CheckBox>(R.id.checkBox3)
        val checkBox4 = findViewById<CheckBox>(R.id.checkBox4)
        val checkBox5 = findViewById<CheckBox>(R.id.checkBox5)
        val checkBox6 = findViewById<CheckBox>(R.id.checkBox6)
        val checkBox7 = findViewById<CheckBox>(R.id.checkBox7)
        val checkBox8 = findViewById<CheckBox>(R.id.checkBox8)
        val recipesButton = findViewById<Button>(R.id.button)

        checkBox1.setOnCheckedChangeListener { _, isChecked ->
            updateSelectedIngredients("Tomato", isChecked)
        }
        checkBox2.setOnCheckedChangeListener { _, isChecked ->
            updateSelectedIngredients("Onion", isChecked)
        }
        checkBox3.setOnCheckedChangeListener { _, isChecked ->
            updateSelectedIngredients("Chicken", isChecked)
        }
        checkBox4.setOnCheckedChangeListener { _, isChecked ->
            updateSelectedIngredients("Mushroom", isChecked)
        }
        checkBox5.setOnCheckedChangeListener { _, isChecked ->
            updateSelectedIngredients("Chilli", isChecked)
        }
        checkBox6.setOnCheckedChangeListener { _, isChecked ->
            updateSelectedIngredients("Butter", isChecked)
        }
        checkBox7.setOnCheckedChangeListener { _, isChecked ->
            updateSelectedIngredients("Flour", isChecked)
        }
        checkBox8.setOnCheckedChangeListener { _, isChecked ->
            updateSelectedIngredients("Capsicum", isChecked)
        }



        recipesButton.setOnClickListener {
            val intent = Intent(this, RecipeTab::class.java)
            startActivity(intent)
        }
    }

    private fun updateSelectedIngredients(ingredient: String, isChecked: Boolean) {
        if (isChecked) {
            selectedIngredients.add(ingredient)
        } else {
            selectedIngredients.remove(ingredient)
        }
    }
}