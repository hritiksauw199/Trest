package com.example.trest

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.trest.ui.theme.TrestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val checkBox1 = findViewById<CheckBox>(R.id.checkBox1) as CheckBox
        val checkBox2 = findViewById<CheckBox>(R.id.checkBox2) as CheckBox
        val checkBox3 = findViewById<CheckBox>(R.id.checkBox3) as CheckBox
        val checkBox4 = findViewById<CheckBox>(R.id.checkBox4) as CheckBox
        val btn = findViewById<Button>(R.id.button) as Button


        btn.setOnClickListener {
            if (checkBox1.isChecked == true && checkBox2.isChecked == true)
            {
                Toast.makeText(this@MainActivity,
                    "All Selected", Toast.LENGTH_LONG)
                    .show()
            }else if(checkBox3.isChecked == true && checkBox4.isChecked == true)
            {
                Toast.makeText(this@MainActivity,
                    "Last 2 selected", Toast.LENGTH_LONG)
                    .show()
            }


        }
    }
}
