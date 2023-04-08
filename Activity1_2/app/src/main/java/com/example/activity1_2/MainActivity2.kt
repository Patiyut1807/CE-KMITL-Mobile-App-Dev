package com.example.activity1_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import kotlin.math.min

class MainActivity2 : AppCompatActivity() {
    var num = 0
    var maxNumber = 0
    var minNumber = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val backButton = findViewById<Button>(R.id.backButton)
        val addButton = findViewById<Button>(R.id.addButton)
        val decreaseBTN = findViewById<Button>(R.id.decreaseButton)
        val maxNumberBox = findViewById<EditText>(R.id.editTextNumberDecimal)
        val minNumberBox = findViewById<EditText>(R.id.editTextNumberDecimal2)
        val txt = findViewById<TextView>(R.id.countTextView)
        txt.text = num.toString()
        backButton.setOnClickListener {
            finish()
        }
        maxNumberBox.addTextChangedListener {
            if(maxNumberBox.text.toString().toIntOrNull() != null){
                maxNumber = maxNumberBox.text.toString().toInt()
                if (maxNumber<= minNumber){
                    maxNumber= minNumber+1
                    maxNumberBox.setText(maxNumber.toString())
                }
                if(txt.text.toString().toInt()>maxNumber ){
                    txt.text = maxNumber.toString()
                }
            }

        }
        minNumberBox.addTextChangedListener {
            if(minNumberBox.text.toString().toIntOrNull() != null){
                minNumber = minNumberBox.text.toString().toInt()
                if(minNumber >= maxNumber){
                    minNumber=maxNumber-1
                    minNumberBox.setText(minNumber.toString())
                }
                if(txt.text.toString().toInt() < minNumber ){
                    txt.text = minNumber.toString()
                }
            }


        }
        addButton.setOnClickListener {
            if (num <maxNumber){
                num += 1
                txt.text = num.toString()
            }
        }
        decreaseBTN.setOnClickListener {
            if(num>minNumber){
                num -= 1
                txt.text = num.toString()
            }
        }
    }
}