package com.example.shoes

import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.shoes.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val clothesName = intent.getStringExtra("MenuItemName")
        val clothesImage = intent.getIntExtra("MenuItemImage", 0)
        binding.detailClothesName.text = clothesName
        binding.DetailClothesImage.setImageResource(clothesImage)

        binding.imageButton.setOnClickListener{
            finish()
        }
    }
}