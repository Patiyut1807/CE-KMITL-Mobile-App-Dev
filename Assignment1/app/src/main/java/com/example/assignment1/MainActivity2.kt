package com.example.assignment1


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val txtOperand = findViewById<TextView>(R.id.operation)
        val str = intent.getStringExtra("operator")
        txtOperand.text = str

        val num1 = findViewById<EditText>(R.id.editTextNumber1)
        val num2 = findViewById<EditText>(R.id.editTextNumber2)
        val ansBtn = findViewById<Button>(R.id.ansBtn)
        val backBtn = findViewById<Button>(R.id.backBtn)
        val ansTxt = findViewById<TextView>(R.id.ansTxt)

        ansBtn.setOnClickListener {
            var res:Float = 0.0F
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
        backBtn.setOnClickListener {
            finish()
        }

    }
}