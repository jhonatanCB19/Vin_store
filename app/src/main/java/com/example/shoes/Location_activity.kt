package com.example.shoes

import android.app.Activity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.shoes.databinding.ActivityLocationBinding

class Location_activity : AppCompatActivity() {
    private val binding: ActivityLocationBinding by lazy {
        ActivityLocationBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val locationList : Array<String> = arrayOf("Bogota", "Cali", "Medellin", "Boyaca", "Cundinamarca")
        val adaptador = ArrayAdapter(this,android.R.layout.simple_list_item_1,locationList)
        val autoCompleteTextView: AutoCompleteTextView = binding.listOfLocation // llamamos al text list
        autoCompleteTextView.setAdapter(adaptador)
    }
}