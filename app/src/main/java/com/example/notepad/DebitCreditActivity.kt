package com.example.notepad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notepad.databinding.ActivityDebitCreditBinding
import com.example.notepad.databinding.ActivityMainBinding

class DebitCreditActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDebitCreditBinding

    private lateinit var mainAdapter: MainAdapter
    lateinit var namee : TextView
    lateinit var amountt: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDebitCreditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val amount = intent.getIntExtra("amount", 0)
        val name = intent.getStringExtra("name")
        var transactionList = mutableListOf(TransactionData("Ashim", 12), TransactionData("Mitra", 23))

        transactionList.add(TransactionData(name, amount))
        val spinner: Spinner = findViewById(R.id.spinner)
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.planets_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }
       val mainAdapter = MainAdapter(transactionList)
        binding.recyclerViewMain.adapter = mainAdapter
        binding.recyclerViewMain.layoutManager = LinearLayoutManager(
            this
        )
    }
}