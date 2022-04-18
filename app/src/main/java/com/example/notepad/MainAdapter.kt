package com.example.notepad

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(
    private val data: MutableList<TransactionData>
) : RecyclerView.Adapter<MainAdapter.CustomViewHolder>() {


    override fun getItemCount(): Int {
        return data.size
    }

    fun addTransaction(datas: TransactionData) {
        data.add(datas)
        notifyItemInserted(data.size - 1)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.transaction_layout, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val currentItem = data[position]

        holder.textView1.text = currentItem.name
        holder.textView2.text = currentItem.sum.toString()


    }

    class CustomViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        val textView1: TextView = v.findViewById(R.id.textView1)
        val textView2: TextView = v.findViewById(R.id.textView2)
    }
}



