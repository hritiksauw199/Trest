// IngredientsManagerTest.kt
import org.junit.Assert.*
import org.junit.Test

class IngredientsManagerTest {

    @Test
    fun testUpdateSelectedIngredients_AddIngredient() {
        // Arrange
        val ingredientsManager = IngredientsManager()
        val selectedIngredients = mutableListOf<String>()
        val ingredient = "tomato"

        // Act
        ingredientsManager.updateSelectedIngredients(selectedIngredients, ingredient, true)

        // Assert
        assertTrue(selectedIngredients.contains(ingredient))
    }


    @Test
    fun testUpdateSelectedIngredients_RemoveIngredient() {
        // Arrange
        val selectedIngredients = mutableListOf("tomato", "onion", "lettuce")
        val ingredient = "onion"
        val isChecked = false
        val ingredientsManager = IngredientsManager()

        // Act
        ingredientsManager.updateSelectedIngredients(selectedIngredients, ingredient, isChecked)

        // Assert
        assertFalse(selectedIngredients.contains(ingredient))
    }
}
