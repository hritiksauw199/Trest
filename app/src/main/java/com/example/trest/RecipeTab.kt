package com.example.trest

import Recipe
import RecommendationManager
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import android.widget.ImageView


class RecipeTab : ComponentActivity() {

    private lateinit var recommendationManager: RecommendationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipe_tab)

        //val recommendationManager = RecommendationManager(this)
        //val recommendedRecipes = recommendationManager.getRecommendedRecipes(selectedIngredients)
        //println(recommendedRecipes)

        val selectedIngredients = intent.getStringArrayListExtra("selectedIngredients") ?: ArrayList()
        val getRecipe = determineRecommendedRecipe(selectedIngredients)
        // Update the placeholders with recipe information
        updateRecipeInformation(getRecipe)


    }

    private fun determineRecommendedRecipe(selectedIngredients: ArrayList<String>?): MutableMap<String, Recipe> {
        // Example predefined mapping of ingredients to recipes
        val ingredientToRecipeMap = mapOf(
            listOf("tomato", "onion", "flour", "capsicum") to Recipe("Pizza",
                "Delicious pizza with tomato, capsicum and onion toppings.",
                "Averge rating: 4.3 out of 5.0", imageResources = R.drawable.pizza),
            listOf("butter", "chicken") to Recipe("Butter Chicken",
                "Delicious Indian style Butter Chicken",
                "MM", imageResources = R.drawable.butterchicken),
            listOf("chicken", "chilli") to Recipe("BBQ Chicken",
                "A spicy BBQ Chicken awaits!",
                "In", imageResources = R.drawable.bbqchicken),
            listOf("tomato", "onion", "mushroom") to Recipe("Mushroom Fry",
                "Crispy fried mushrooms.",
                "NN", imageResources = R.drawable.friedmushrooms),
            listOf("tomato", "onion", "flour", "mushroom") to Recipe("Mushroom Gravy",
                "Tangy & Spicy Mushroom gravy with Roti",
                "CC", imageResources = R.drawable.mushroommasala)
            // Add more mappings as needed
        )

        val recommendedRecipes = mutableMapOf<String, Recipe>()

        for ((ingredientList, recipe) in ingredientToRecipeMap) {
            if (selectedIngredients != null && selectedIngredients.all { ingredientList.contains(it.toLowerCase()) }) {
                recommendedRecipes[recipe.name] = recipe
            }
        }

        return recommendedRecipes
    }

    private fun updateRecipeInformation(recipes: Map<String, Recipe>) {
        val recipeViews = listOf(
            Triple(R.id.image1_place, R.id.name1_place, R.id.star1_place),
            Triple(R.id.image2_place, R.id.name2_place, R.id.star2_place),
            Triple(R.id.image3_place, R.id.name3_place, R.id.star3_place)
        )

        var index = 0
        for ((recipeName, recipe) in recipes) {
            if (index >= recipeViews.size) {
                // Handle the case where you have more recipes than available placeholders
                break
            }

            val (imageId, nameId, starId) = recipeViews[index]

            // Update image
            val imageView = findViewById<ImageView>(imageId)
            // Assuming you have an image for the recipe, you can set it here
            imageView.setImageResource(recipe.imageResources)

            // Update name
            val nameTextView = findViewById<TextView>(nameId)
            nameTextView.text = recipe.name

            // Update instructions
            val instructionsTextView = findViewById<TextView>(starId)
            instructionsTextView.text = recipe.description

            index++
        }
    }

}

