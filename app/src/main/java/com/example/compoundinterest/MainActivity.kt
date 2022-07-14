package com.example.compoundinterest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var inputA: EditText = findViewById(R.id.Input1)
        var inputB: EditText = findViewById(R.id.Input2)
        var inputC: EditText = findViewById(R.id.Input3)
        var btnMul: Button = findViewById(R.id.btnMul)
        var result: TextView = findViewById(R.id.txtResults)

        btnMul.text = "Click here to Multiply"

        //listeners

        btnMul.setOnClickListener{

            var firstText = inputA.text.toString().trim()
            var secondText = inputB.text.toString().trim()
            var thirdText = inputC .text.toString().trim()

            if (firstText.isEmpty() || secondText.isEmpty() || thirdText.isEmpty()) {
                Toast.makeText (applicationContext,"Enter valid values",Toast.LENGTH_SHORT )
                    .show()
                return@setOnClickListener
            }
            try {
                var deposit = firstText.toDouble()
                var rate = secondText.toDouble()
                var time = thirdText.toDouble()

                var amount1 = 1 + (rate/100)
                var amount2 = Math.pow (amount1,time)
                var amount = amount2 * deposit

                result.text = "The compound interest is $amount"

            }catch (e:Exception){
                Toast.makeText(applicationContext,"Enter valid values", Toast.LENGTH_SHORT)
                    .show()
            }


        }

    }
}