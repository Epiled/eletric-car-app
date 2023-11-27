package com.example.eletriccarapp.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.eletriccarapp.R

class CalculaAutonomiaActivity : AppCompatActivity() {
    lateinit var preco: EditText
    lateinit var kmPercorrido: EditText
    lateinit var btnCalculcar: Button
    lateinit var resultado: TextView
    lateinit var btnClose: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calcular_autonomia)
        setupview()
        setupListeners()
        setupCachedResult()
    }

    private fun setupCachedResult() {
        val valorCalculado = getSharedPref()
        resultado.text = valorCalculado.toString()
    }

    fun setupListeners() {
        btnCalculcar.setOnClickListener {
            val textoDigitado = preco.text.toString()
            Log.d("texto digitado ->", textoDigitado)
            calcula()
        }
        btnClose.setOnClickListener {
            finish()
        }
    }

    fun setupview() {
        preco = findViewById(R.id.et_preco_kwh)
        kmPercorrido = findViewById(R.id.et_distancia)
        btnCalculcar = findViewById(R.id.btn_calcular)
        resultado = findViewById(R.id.tv_resultado)
        btnClose = findViewById(R.id.iv_close)
    }

    fun calcula() {
        val preco = preco.text.toString().toFloat()
        val km = kmPercorrido.text.toString().toFloat()
        var result = preco / km

        resultado.text = result.toString()
        saveSharedPref(result)
    }

    fun saveSharedPref(resultado : Float) {
        val sharedPref = getPreferences((Context.MODE_PRIVATE) ?: return)
        with(sharedPref.edit()) {
            putFloat(getString(R.string.saved_calc), resultado)
            apply()
        }
    }

    fun getSharedPref(): Float {
        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        return sharedPref.getFloat(getString(R.string.saved_calc), 0.0f)
    }
}