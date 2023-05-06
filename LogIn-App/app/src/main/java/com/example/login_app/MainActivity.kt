package com.example.login_app

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.beust.klaxon.Klaxon
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException


val JSON = "application/json; charset=utf-8".toMediaTypeOrNull()
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val uname = findViewById<EditText>(R.id.username)
        val loginBtn = findViewById<Button>(R.id.loginBtn)
        loginBtn.setOnClickListener {
            if (uname.text.toString().isEmpty() ){
                if(uname.text.toString().isEmpty()){
                    uname.setBackgroundColor(R.drawable.rectangle)
                }
            }else{
                val dataListintent = Intent(this,DataListActivity::class.java)
                dataListintent.putExtra("std_id",uname.text.toString())
                startActivity(dataListintent)
            }


        }
    }


}