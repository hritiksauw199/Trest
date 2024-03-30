import com.example.trest.R

// Define a DSL context class for recipes
@RecipeDSL
class RecipeBuilder {
    val recipes = mutableListOf<Recipe>()

    // DSL function for adding a recipe
    fun recipe(name: String, block: Recipe.() -> Unit) {
        val recipe = Recipe(name = name).apply(block)
        recipes.add(recipe)
    }
}

// Extension function to initialize RecipeBuilder with DSL
fun recipes(block: RecipeBuilder.() -> Unit): List<Recipe> {
    val builder = RecipeBuilder()
    builder.block()
    return builder.recipes
}

// DSL marker annotation
@DslMarker
annotation class RecipeDSL

// Example usage of the DSL
fun main() {
    val recipeList = recipes {
        recipe("Pizza") {
            description = "Delicious pizza with tomato, capsicum and onion toppings."
            instructions = "Bake at 200°C for 15 minutes."
            imageResources = R.drawable.pizza
        }
        recipe("Butter Chicken") {
            description = "Delicious Indian style Butter Chicken"
            instructions = "Cook chicken in butter and spices, then simmer in creamy tomato sauce."
            imageResources = R.drawable.butterchicken
        }
        // Add more recipes as needed
    }

    // Print the recipes
    recipeList.forEach { println(it) }
}

