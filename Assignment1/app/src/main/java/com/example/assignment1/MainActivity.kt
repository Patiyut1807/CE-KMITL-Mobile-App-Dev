package com.example.assignment1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val plusBtn = findViewById<Button>(R.id.plus)
        val minusBtn = findViewById<Button>(R.id.minus)
        val multBtn = findViewById<Button>(R.id.multiply)
        val divBtn = findViewById<Button>(R.id.divide)

        plusBtn.setOnClickListener {
            val activityIntent2 = Intent(this,MainActivity2::class.java)
            activityIntent2.putExtra("operator","+")
            startActivity(activityIntent2)
        }
        minusBtn.setOnClickListener {
            val activityIntent2 = Intent(this,MainActivity2::class.java)
            activityIntent2.putExtra("operator","-")
            startActivity(activityIntent2)
        }
        multBtn.setOnClickListener {
            val activityIntent2 = Intent(this,MainActivity2::class.java)
            activityIntent2.putExtra("operator","*")
            startActivity(activityIntent2)
        }
        divBtn.setOnClickListener {
            val activityIntent2 = Intent(this,MainActivity2::class.java)
            activityIntent2.putExtra("operator","/")
            startActivity(activityIntent2)
        }
    }
}