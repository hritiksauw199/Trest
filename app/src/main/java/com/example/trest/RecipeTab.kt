package com.example.trest

import Recipe
import RecommendationManager
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import android.content.Context
import com.chaquo.python.PyObject
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform
import org.apache.commons.io.IOUtils
import org.json.JSONArray
import java.io.InputStream


class RecipeTab : ComponentActivity() {

    private lateinit var recommendationManager: RecommendationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipe_tab)

        val selectedIngredients = intent.getStringArrayListExtra("selectedIngredients") ?: ArrayList()

        //val recommendationManager = RecommendationManager(this)
        //val recommendedRecipes = recommendationManager.getRecommendedRecipes(selectedIngredients)
        //println(recommendedRecipes)

        val recommendedRecipe = determineRecommendedRecipe(selectedIngredients)

        // Update the placeholders with recipe information
        updateRecipeInformation(recommendedRecipe)

    }

    private fun determineRecommendedRecipe(selectedIngredients: ArrayList<String>?): Recipe {
        // Example predefined mapping of ingredients to recipes
        val ingredientToRecipeMap = mapOf(
            listOf("Tomato", "Onion") to Recipe("Pizza",
                "Delicious pizza with tomato and onion toppings.",
                "Instructions for making pizza..."),
            listOf("Flour", "Mushroom", "Chicken") to Recipe("Butter Chicken",
                "NN.",
                "MM")
            // Add more mappings as needed
        )

        // Find a recipe based on the selected ingredients
        for ((ingredients, recipe) in ingredientToRecipeMap) {
            if (selectedIngredients?.containsAll(ingredients) == true) {
                return recipe
            }
        }

        // If no matching recipe found, return a default recipe or handle appropriately
        return Recipe("Unknown Recipe", "Recipes not found for selected ingredients.",
            "Select other ingredients")
    }


    private fun updateRecipeInformation(recipe: Recipe) {
        // Update TextViews and ImageView with recipe information
        findViewById<TextView>(R.id.textView_recipe_name).text = recipe.name
        findViewById<TextView>(R.id.textView_recipe_description).text = recipe.description
        findViewById<TextView>(R.id.textView_recipe_instructions).text = recipe.instructions
        // Update ImageView with recipe image (you may need to load the image asynchronously)
        //findViewById<ImageView>(R.id.imageView_recipe_image).setImageResource(recipe.imageResource)
    }


}

