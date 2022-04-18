package com.example.notepad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.notepad.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.AddTransaction.setOnClickListener {
            startActivity(Intent(this, AddNewTransactionActivity::class.java))
        }

        binding.MyHistoryButton.setOnClickListener {
            startActivity(Intent(this, DebitCreditActivity::class.java))
        }

        val name = findViewById<EditText>(R.id.editName)

    }
}