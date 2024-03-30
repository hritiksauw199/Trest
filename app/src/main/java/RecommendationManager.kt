import android.content.Context
import com.chaquo.python.PyObject
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform

class RecommendationManager(private val context: Context) {

    fun getRecommendedRecipes(selectedIngredients: ArrayList<String>): PyObject? {
        // Ensure Chaquopy is initialized
        if (!Python.isStarted()) {
            Python.start(AndroidPlatform(context))
        }

        // Load Python module
        val python = Python.getInstance()
        val module = python.getModule("script")

        val f = module["recipe_recom"]
        val ingre = selectedIngredients
        val h = f?.call(ingre)

        return h
    }
}


