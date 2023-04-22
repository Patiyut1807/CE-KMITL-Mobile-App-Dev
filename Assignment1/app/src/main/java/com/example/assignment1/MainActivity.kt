package com.example.assignment1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var str = ""
        val plusBtn = findViewById<Button>(R.id.plus)
        val minusBtn = findViewById<Button>(R.id.minus)
        val multBtn = findViewById<Button>(R.id.multiply)
        val divBtn = findViewById<Button>(R.id.divide)
        val txtOperand = findViewById<TextView>(R.id.operation)

        plusBtn.setOnClickListener {
            str = "+"
            txtOperand.text = "+"
        }
        minusBtn.setOnClickListener {
            str = "-"
            txtOperand.text = "-"

        }
        multBtn.setOnClickListener {
            str = "*"
            txtOperand.text = "*"
        }
        divBtn.setOnClickListener {
            str = "/"
            txtOperand.text = "/"
        }

        val num1 = findViewById<EditText>(R.id.editTextNumber1)
        val num2 = findViewById<EditText>(R.id.editTextNumber2)
        val ansBtn = findViewById<Button>(R.id.ansBtn)
        val ansTxt = findViewById<TextView>(R.id.ansTxt)

        ansBtn.setOnClickListener {
            var res = 0.0F
            val number1 = num1.text.toString().toFloatOrNull()
            val number2 = num2.text.toString().toFloatOrNull()
            if (number1 != null && number2 != null){
                when(str){
                    "+"->res = number1 + number2
                    "-"->res = number1 - number2
                    "*"->res = number1 * number2
                    "/"->res = number1 / number2
                }
                ansTxt.text = res.toString()
            }

        }
    }
}