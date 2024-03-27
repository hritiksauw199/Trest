package com.example.trest

import Recipe
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity

class RecipeTab : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipe_tab)

        val selectedIngredients = intent.getStringArrayListExtra("selectedIngredients")

        // Determine the recommended recipe based on selected ingredients
        val recommendedRecipe = determineRecommendedRecipe(selectedIngredients)

        // Update the placeholders with recipe information
        updateRecipeInformation(recommendedRecipe)
    }

    private fun determineRecommendedRecipe(selectedIngredients: ArrayList<String>?): Recipe {
        // Example predefined mapping of ingredients to recipes
        val ingredientToRecipeMap = mapOf(
            listOf("Tomato", "Onion") to Recipe("Pizza",
                "Delicious pizza with tomato and onion toppings.",
                "Instructions for making pizza...", R.drawable.mushroom1),
            // Add more mappings as needed
        )

        // Find a recipe based on the selected ingredients
        for ((ingredients, recipe) in ingredientToRecipeMap) {
            if (selectedIngredients?.containsAll(ingredients) == true) {
                return recipe
            }
        }

        // If no matching recipe found, return a default recipe or handle appropriately
        return Recipe("Unknown Recipe", "Recipe not found for selected ingredients.",
            "Select other ingredients", R.drawable.tomato)
    }


    private fun updateRecipeInformation(recipe: Recipe) {
        // Update TextViews and ImageView with recipe information
        findViewById<TextView>(R.id.textView_recipe_name).text = recipe.name
        findViewById<TextView>(R.id.textView_recipe_description).text = recipe.description
        findViewById<TextView>(R.id.textView_recipe_instructions).text = recipe.instructions
        // Update ImageView with recipe image (you may need to load the image asynchronously)
        findViewById<ImageView>(R.id.imageView_recipe_image).setImageResource(recipe.imageResource)
    }


}

