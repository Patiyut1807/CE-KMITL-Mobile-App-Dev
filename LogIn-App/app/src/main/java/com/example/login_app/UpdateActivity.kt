package com.example.login_app

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import okhttp3.*
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException

class UpdateActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        val std_id = intent.getStringExtra("std_id")!!
        val txtSelected = intent.getStringExtra("field")!!
        val txtStdId = findViewById<TextView>(R.id.textStdId)
        txtStdId.setText(txtStdId.text.toString()+std_id+" At Item: "+txtSelected)
        val edtA = findViewById<EditText>(R.id.edtA)
        val edtB = findViewById<EditText>(R.id.edtB)
        val edtC = findViewById<EditText>(R.id.edtC)
        val edtD = findViewById<EditText>(R.id.edtD)
        val editBtn = findViewById<Button>(R.id.updateBtn)
        val delBtn = findViewById<Button>(R.id.delBtn)
        val exitBtn = findViewById<Button>(R.id.exitBtn)
        edtA.addTextChangedListener {
            editBtn.isEnabled =
                checkEditInput(edtA.text.toString(),edtB.text.toString(),edtC.text.toString(),edtD.text.toString())
        }
        edtB.addTextChangedListener {
            editBtn.isEnabled =
                checkEditInput(edtA.text.toString(),edtB.text.toString(),edtC.text.toString(),edtD.text.toString())
        }
        edtC.addTextChangedListener {
            editBtn.isEnabled =
                checkEditInput(edtA.text.toString(),edtB.text.toString(),edtC.text.toString(),edtD.text.toString())
        }
        edtD.addTextChangedListener {
            editBtn.isEnabled =
                checkEditInput(edtA.text.toString(),edtB.text.toString(),edtC.text.toString(),edtD.text.toString())
        }
        exitBtn.setOnClickListener {
            finish()
        }
        editBtn.setOnClickListener {
            if (!(edtA.text.isEmpty() || edtB.text.isEmpty() || edtC.text.isEmpty() || edtD.text.isEmpty())){
                try {
                    val postUrl = "https://demo.hashup.tech/std/items/$txtSelected"
                    val postBody="{" +
                            "\"std_id\": \"$std_id\",\n" +
                            "\"field_a\":\"${edtA.text.toString()}\",\n" +
                            "\"field_b\":\"${edtB.text.toString()}\",\n" +
                            "\"field_c\":\"${edtC.text.toString()}\",\n" +
                            "\"field_d\":\"${edtD.text.toString()}\"\n" +
                            "}"
                    putRequest(postUrl, postBody)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }

        }
        delBtn.setOnClickListener {
            try {
                val postUrl = "https://demo.hashup.tech/std/items/$txtSelected"
                delRequest(postUrl)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

    }
    private fun putRequest(postUrl: String, postBody: String?) {
        val client = OkHttpClient()
        val body: RequestBody = postBody.toString().toRequestBody(JSON)
        val request: Request = Request.Builder()
            .url(postUrl)
            .put(body)
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

    private fun delRequest(postUrl: String) {
        val client = OkHttpClient()
        val request: Request = Request.Builder()
            .url(postUrl)
            .delete()
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
    private fun checkEditInput(a:String, b:String, c:String, d:String):Boolean{
        if (a.isEmpty() || b.isEmpty() || c.isEmpty() || d.isEmpty() ){
            return false
        }
        return true
    }
}