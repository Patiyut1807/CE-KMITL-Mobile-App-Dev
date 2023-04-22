package com.example.activity3_http

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody.Part.Companion.create
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException

val JSON = "application/json; charset=utf-8".toMediaTypeOrNull()
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val uname = findViewById<EditText>(R.id.username)
        val pass = findViewById<EditText>(R.id.password)
        val loginBtn = findViewById<Button>(R.id.loginBtn)
        loginBtn.setOnClickListener {
            if (uname.text.toString().isEmpty() || pass.text.toString().isEmpty()){
                Log.e("test","invalid username or password")
            }else{
                Log.d("test","OK 200")
//                try {
//                    run()
//                } catch (e: IOException) {
//                    e.printStackTrace()
//                }
                try {
                    val postUrl = ""
                    val postBody="{\n" +
                            "    \"name\": \"morpheus\",\n" +
                            "    \"job\": \"leader\"\n" +
                            "}"
                    postRequest(postUrl, postBody)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }


        }
    }

    @Throws(IOException::class)
    fun run() {
        val client = OkHttpClient()
        val request: Request = Request.Builder()
            .url("https://publicobject.com/helloworld.txt")
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("test",e.toString())
                call.cancel()
            }

            override fun onResponse(call: Call, response: Response) {

                val myResponse = response.body!!.string()
                Log.d("test",myResponse)
                runOnUiThread {
//                    txtString.setText(myResponse)

                }
            }
        })
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
            }
        })
    }
}