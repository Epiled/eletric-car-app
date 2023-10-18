package com.example.eletriccarapp.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.eletriccarapp.R

class MainActivity : AppCompatActivity() {
    lateinit var preco: EditText
    lateinit var kmPercorrido: EditText
    lateinit var btnCalculcar: Button
    lateinit var resultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupview()
        setupListeners()
    }

    fun setupview() {
        preco = findViewById(R.id.et_preco_kwh)
        kmPercorrido = findViewById(R.id.et_distancia)
        btnCalculcar = findViewById(R.id.btn_calcular)
        resultado = findViewById(R.id.tv_resultado)
    }

    fun setupListeners() {
        btnCalculcar.setOnClickListener {
            val textoDigitado = preco.text.toString()
            Log.d("texto digitado ->", textoDigitado)

            //calcula()
            startActivity(Intent(this, CalculaAutonomiaActivity::class.java))
        }
    }

    fun calcula() {
        val preco = preco.text.toString().toFloat()
        val km = kmPercorrido.text.toString().toFloat()
        var result = preco / km

        resultado.text = result.toString()
    }
}