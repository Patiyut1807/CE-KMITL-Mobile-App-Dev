package com.example.activity1_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val nextButton = findViewById<Button>(R.id.nextButton)
        nextButton.setOnClickListener {
            val activityIntent2 = Intent(this,MainActivity2::class.java)
            startActivity(activityIntent2)
        }
    }
}