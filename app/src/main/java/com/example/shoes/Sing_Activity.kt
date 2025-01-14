package com.example.shoes

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.shoes.databinding.ActivitySingBinding

class Sing_Activity : AppCompatActivity() {

    private val binding : ActivitySingBinding by lazy{
        ActivitySingBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing)


        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.yatienecuentabutton.setOnClickListener{
            val intent = Intent(this,LoginActivity:: class.java)
            startActivity(intent)
        }



    }
}