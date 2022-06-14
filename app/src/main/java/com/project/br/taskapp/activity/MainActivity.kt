package com.project.br.taskapp.activity

<<<<<<< HEAD
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.project.br.taskapp.R
import com.project.br.taskapp.adapter.TransactionAdapter
import com.project.br.taskapp.adapter.TransactionItemListener
import com.project.br.taskapp.repository.DatabaseUtil
import com.project.br.taskapp.repository.TransactionDAO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), TransactionItemListener {

    private lateinit var listTransaction: RecyclerView
    private lateinit var btAddTransaction: FloatingActionButton
    private lateinit var transactionAdapter: TransactionAdapter

    private var userId = -1

    private val handler = Handler(Looper.getMainLooper())

=======
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.project.br.taskapp.R

class MainActivity : AppCompatActivity() {
>>>>>>> 2284fe6c0cbb41a679d6fe9b4c82e02da5e02e4e
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

<<<<<<< HEAD
        userId = intent.getIntExtra("userId", -1)

        listTransaction = findViewById(R.id.main_recycleview_transactions)
        btAddTransaction = findViewById(R.id.main_fab_create_transactions)

        btAddTransaction.setOnClickListener {
            val intent = Intent(this, TransactionActivity::class.java)
            intent.putExtra("userId", userId)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()

        GlobalScope.launch {
            val transactionDAO = DatabaseUtil
                .getInstance(applicationContext)
                .getTransactionDAO()

            val userWithTransacion = transactionDAO.findByUserId(userId)

            transactionAdapter = TransactionAdapter(userWithTransacion.transactionApp)
            transactionAdapter.setOnTransactionListener(this@MainActivity)

            handler.post {
                listTransaction.layoutManager = LinearLayoutManager(this@MainActivity)
                listTransaction.adapter = transactionAdapter
            }


        }


    }

    override fun onTransactionItemClick(view: View, position: Int) {

        val it = Intent(this, TransactionActivity::class.java)
        it.putExtra("userId", userId)
        it.putExtra("transactionId", transactionAdapter.transactions[position].id)
        startActivity(it)
    }

    override fun onTransactionItemLongClick(view: View, position: Int) {

        val transaction = transactionAdapter.transactions[position]

        val dialog = AlertDialog.Builder(this@MainActivity)
                .setTitle("Gestão APP")
                .setMessage("Deseja realmente excluir a transação ${transaction.name} ?")
                .setCancelable(false)
                .setPositiveButton("Sim"){dialog, _ ->
                    GlobalScope.launch {
                        val transactionDAO = DatabaseUtil
                            .getInstance(applicationContext)
                            .getTransactionDAO()

                        transactionDAO.delete(transaction)

                        val transactions = transactionDAO.findAll()

                        handler.post {
                            transactionAdapter.transactions = transactions
                            transactionAdapter.notifyItemRemoved(position)
                        }

                    }
                    dialog.dismiss()
                }
                .setNegativeButton("Não"){dialog, _ ->
                    dialog.dismiss()
                }
                .create()
            dialog.show()
    }

=======

    }
>>>>>>> 2284fe6c0cbb41a679d6fe9b4c82e02da5e02e4e
}