package com.example.notepad

import android.content.Intent
import android.graphics.drawable.Icon
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class TransactionDoneActivity : AppCompatActivity() {

    lateinit var tvAmount: TextView
    lateinit var check: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction_done)

        tvAmount = findViewById(R.id.showAmount)

        val amount = intent.getIntExtra("amount", 0)
        val name = intent.getStringExtra("name")
        tvAmount.text = "Congratulations Mak, your transaction of $amount has been added"

        check = findViewById(R.id.check)

        check.setOnClickListener {
            val int = Intent(this, DebitCreditActivity::class.java)
            int.putExtra("name", name)
            int.putExtra("amount", amount)
            startActivity(int)
        }

    }
}