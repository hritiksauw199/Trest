// MainActivityUnitTest.kt
import org.junit.Assert.*
import org.junit.Test

class MainActivityUnitTest {

    @Test
    fun testCheckboxClick_AddIngredient() {
        // Arrange
        val mainActivity = MainActivity()
        val selectedIngredients = mutableListOf<String>()
        val checkBox = CheckBoxStub("tomato", true) // Simulate checkbox click for "tomato"

        // Act
        mainActivity.onCheckboxClicked(checkBox)

        // Assert
        assertTrue(mainActivity.selectedIngredients.contains(checkBox.text))
    }

    @Test
    fun testCheckboxClick_RemoveIngredient() {
        // Arrange
        val mainActivity = MainActivity()
        mainActivity.selectedIngredients.addAll(listOf("tomato", "onion", "lettuce"))
        val checkBox = CheckBoxStub("onion", false) // Simulate checkbox click for "onion"

        // Act
        mainActivity.onCheckboxClicked(checkBox)

        // Assert
        assertFalse(mainActivity.selectedIngredients.contains(checkBox.text))
    }

    // Stub class to simulate checkbox clicks
    private class CheckBoxStub(val text: String, val isChecked: Boolean) : CheckBox {
        override fun isChecked(): Boolean = isChecked
        override fun getText(): String = text
        // Implement other methods as needed for your tests
    }
}
