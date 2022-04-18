package com.example.notepad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.notepad.databinding.ActivityAddNewTransactionBinding
import com.example.notepad.databinding.ActivityMainBinding

class AddNewTransactionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddNewTransactionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddNewTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addbutton.setOnClickListener {
            if (binding.editName.text.toString().isNotEmpty() && binding.editAmount.text.toString()
                    .isNotEmpty()
            ) {
                val name = binding.editName.text.toString()
                val amount = binding.editAmount.text.toString().toInt()
                val intent = Intent(this, TransactionDoneActivity::class.java)

                intent.putExtra("name", name)
                intent.putExtra("amount", amount)
                startActivity(intent)
            }else{
                Toast.makeText(this, "fill the requirement", Toast.LENGTH_LONG).show()
            }
        }
    }
}