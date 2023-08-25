package com.vinicius.imc

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* Instrções */
        val btnIntro = findViewById<Button>(R.id.instrucao)
        btnIntro.setOnClickListener{
            // Inflar o layout do modal
            val dialogView = LayoutInflater.from(this).inflate(R.layout.modal_instructions, null)

            // Criar o AlertDialog
            val alertDialog = AlertDialog.Builder(this)
                .setView(dialogView)
                .create()

            // Definir o botão Fechar para fechar o modal
            dialogView.findViewById<Button>(R.id.closeButton).setOnClickListener {
                alertDialog.dismiss()
            }

            // Mostrar o modal
            alertDialog.show()
        }

        /* Calcular Imc */

        findViewById<Button>(R.id.calcular).setOnClickListener {
            //Captar informações do input

            val altura = Integer.parseInt(findViewById<EditText>(R.id.altura).text.toString())
            val peso = Integer.parseInt(findViewById<EditText>(R.id.peso).text.toString())

            val calculo = peso/((altura * altura)/10000)

            val resultado = findViewById<TextView>(R.id.resultado)

            if (calculo < 18.5) {
                resultado.setText("Seu resultado foi: ${calculo}" + "\n" + "Você esta abaixo do peso!")
                resultado.setTextColor(Color.RED)
        } else if (calculo > 18.5 && calculo < 24.9){
                resultado.setText("Seu resultado foi: ${calculo}" + "\n" + "Você esta com peso normal!")
                resultado.setTextColor(Color.parseColor("#07F1D4"))
            } else if(calculo >= 25) {
                resultado.setText("Seu resultado foi: ${calculo}" + "\n" + "Você esta acima do peso!")
                resultado.setTextColor(Color.RED)
            }else {
                resultado.setText("Ocorreu um erro inesperado, favor reiniciar o calculo.")
                resultado.setTextColor(Color.RED)
            }

            //limpar campos após 5 segundos
            Handler().postDelayed({
                findViewById<EditText>(R.id.altura).text.clear()
                findViewById<EditText>(R.id.peso).text.clear()
                resultado.text = ""
            }, 5000)
        }

    }

}