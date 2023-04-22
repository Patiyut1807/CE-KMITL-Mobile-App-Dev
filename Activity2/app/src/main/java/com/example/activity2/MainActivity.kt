package com.example.activity2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val countryList = arrayOf("India", "China", "australia", "Portugol", "America", "NewZealand")
    private var stListView: ListView? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.stListView =  findViewById(R.id.firstListView)
        val txtSelected = findViewById<TextView>(R.id.txtSelected)
        val arrayAdapter =
            ArrayAdapter(this, R.layout.activity_listview, R.id.textView, countryList)
        stListView?.adapter = arrayAdapter
        stListView?.setOnItemClickListener { adapterView, view, i, l ->
            txtSelected.text = countryList[i].toString()
        }
    }
}