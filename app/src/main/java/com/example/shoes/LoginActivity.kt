package com.example.shoes

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.shoes.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private val binding:ActivityLoginBinding by lazy{
        ActivityLoginBinding.inflate((layoutInflater))
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
        binding.loginbutton.setOnClickListener { //para que el click mande a la pagina login
            val intent=Intent(this,Sing_Activity::class.java)
            startActivity(intent)
        }
        binding.notienebutton.setOnClickListener{ // el que no tiene boton si no lectura
            val intent=Intent(this,Sing_Activity::class.java)
            startActivity(intent)
        }
    }
}