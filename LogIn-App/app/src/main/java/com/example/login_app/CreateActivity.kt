package com.example.login_app

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import okhttp3.*
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException

class CreateActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        val std_id = intent.getStringExtra("std_id")!!
        val txtStdId = findViewById<TextView>(R.id.textStdId)
        txtStdId.setText(txtStdId.text.toString()+std_id)
        val edtA = findViewById<EditText>(R.id.edtA)
        val edtB = findViewById<EditText>(R.id.edtB)
        val edtC = findViewById<EditText>(R.id.edtC)
        val edtD = findViewById<EditText>(R.id.edtD)
        val createBtn = findViewById<Button>(R.id.delBtn)
        val exitBtn = findViewById<Button>(R.id.exitBtn)
        exitBtn.setOnClickListener {
            finish()
        }
        createBtn.setOnClickListener {
            if (!(edtA.text.isEmpty() || edtB.text.isEmpty() || edtC.text.isEmpty() || edtD.text.isEmpty())){
                try {
                    val postUrl = "https://demo.hashup.tech/std/items"
                    val postBody="{" +
                            "\"std_id\": \"$std_id\",\n" +
                            "\"field_a\":\"${edtA.text.toString()}\",\n" +
                            "\"field_b\":\"${edtB.text.toString()}\",\n" +
                            "\"field_c\":\"${edtC.text.toString()}\",\n" +
                            "\"field_d\":\"${edtD.text.toString()}\"\n" +
                            "}"
                    postRequest(postUrl, postBody)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }

        }

    }


    fun postRequest(postUrl: String, postBody: String?) {
        val client = OkHttpClient()
        val body: RequestBody = postBody.toString().toRequestBody(JSON)
        val request: Request = Request.Builder()
            .url(postUrl)
            .post(body)
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                call.cancel()
            }

            override fun onResponse(call: Call, response: Response) {
                Log.d("TAG", response.body!!.string())
                finish()
            }
        })
    }
}