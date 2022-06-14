package com.project.br.taskapp.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.project.br.taskapp.R
import com.project.br.taskapp.entity.TransactionApp

class TransactionAdapter(var transactions: List<TransactionApp>) :
    RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>() {

    var listener: TransactionItemListener? = null

    class TransactionViewHolder(view: View, listener: TransactionItemListener?) :
        RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.transaction_item_name)
        val value: TextView = view.findViewById(R.id.transaction_item_value)
        val indicator: View = view.findViewById(R.id.transaction_item_indicator)
        val cardView: CardView = view.findViewById(R.id.transaction_item_cardview)

        init {
            view.setOnClickListener {
                listener?.onTransactionItemClick(it, adapterPosition)
            }
            view.setOnLongClickListener {
                listener?.onTransactionItemLongClick(it, adapterPosition)
                true
            }
        }

    }

    fun setOnTransactionListener(listener: TransactionItemListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return TransactionViewHolder(view, listener)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        holder.name.text = transactions[position].name
        holder.value.text = "R$: ${transactions[position].value.toString()}"

        //indicator está apenas para teste já que esta mudando a cor do cardview
        if (!transactions[position].isExpense) {
            holder.cardView.setCardBackgroundColor(Color.GREEN)
            holder.indicator.setBackgroundColor(Color.GREEN)
        } else {
            holder.cardView.setCardBackgroundColor(Color.RED)
            holder.indicator.setBackgroundColor(Color.RED)
        }

    }

    override fun getItemCount(): Int {
        return transactions.size
    }

}