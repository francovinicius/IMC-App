package com.vinicius.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.view.LayoutInflater
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
        } else {
                resultado.setText("${calculo}" )
            }
        }

    }

}