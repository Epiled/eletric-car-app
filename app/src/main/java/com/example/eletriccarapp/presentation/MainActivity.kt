package com.example.eletriccarapp.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import com.example.eletriccarapp.R

class MainActivity : AppCompatActivity() {
    lateinit var btnTela: Button
    lateinit var lista: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupview()
        setupListeners()
        setupList()
    }

    fun setupview() {
        btnTela = findViewById(R.id.btn_tela)
        lista = findViewById(R.id.lv_informacoes)
    }

    fun setupList() {
        var dados = arrayOf(
            "Cupcake", "Donut", "Froyo", "Gingerbread", "Honeycomb"
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dados)

        lista.adapter = adapter
    }

    fun setupListeners() {
        btnTela.setOnClickListener {
            startActivity(Intent(this, CalculaAutonomiaActivity::class.java))
        }
    }

}