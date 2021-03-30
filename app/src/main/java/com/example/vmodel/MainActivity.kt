package com.example.vmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var textView: EditText
    lateinit var btnDados: Button
    lateinit var btnMostrar: Button

    lateinit var mainViewModel: MainViewModel

    var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logar(valor = "onCreate")

        initDados()
        initClick()

        //finalizarApp()
    }

    private fun finalizarApp() {
        finish()
    }

    override fun onStart() {
        super.onStart()

        logar(valor = "onStart")
    }

    override fun onResume() {
        super.onResume()

        logar(valor = "onResume")
    }

    override fun onPause() {
        super.onPause()

        logar(valor = "onPause")
    }

    override fun onStop() {
        super.onStop()

        logar(valor = "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun logar(tag: String = "Ciclo de vida", valor: String) {
        Log.d(tag, valor)
    }

    private fun initDados() {

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        textView = findViewById(R.id.TextView)
        btnDados = findViewById(R.id.btnDados)
        btnMostrar = findViewById(R.id.btnMostrar)

        mainViewModel.mContador.observe(this, Observer { valor ->
            textView.setText(valor)
        })
    }

    private fun initClick() {
        btnDados.setOnClickListener {
            mainViewModel.Contador()
        }

        btnMostrar.setOnClickListener {
            Toast.makeText(applicationContext, "Valor: " + mainViewModel.mContador.value.toString(), Toast.LENGTH_SHORT).show()
        }
    }

}