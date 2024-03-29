// IngredientsManager.kt
class IngredientsManager {
    fun updateSelectedIngredients(
        selectedIngredients: MutableList<String>,
        ingredient: String,
        isChecked: Boolean
    ) {
        if (isChecked) {
            selectedIngredients.add(ingredient)
        } else {
            selectedIngredients.remove(ingredient)
        }
    }
}
