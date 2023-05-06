package com.example.login_app

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Klaxon
import okhttp3.*
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException

class DataListActivity : AppCompatActivity() {
    private var dataList = mutableListOf<String>()
    private var stListView: ListView? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_list)
        val std_id = intent.getStringExtra("std_id")!!
        this.stListView =  findViewById(R.id.firstListView)

        try {
            val client = OkHttpClient()
            val request: Request = Request.Builder()
                .url("https://demo.hashup.tech/std/items?std_id=$std_id")
                .build()
            var arr = client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Log.e("test",e.toString())
                    call.cancel()
                }

                override fun onResponse(call: Call, response: Response) {

                    val myResponse = response.body!!.string()
                    var res = JSONObject(myResponse)
                    var data = res.getJSONArray("data")

                    for (i in 0 until  data.length()){
//                        Log.d("data",data.getJSONObject(i).getString("field_a"))
                       dataList.add(data.getJSONObject(i).getString("field_a"))
                    }

                    runOnUiThread {

                    }

                }
            })

        } catch (e: IOException) {
            e.printStackTrace()
        }
        val arrayAdapter =
            ArrayAdapter(this, R.layout.activity_listview, R.id.textView, dataList)
        stListView?.adapter = arrayAdapter
        stListView?.setOnItemClickListener { adapterView, view, i, l ->
//            txtSelected.text = countryList[i].toString()
        }
//                try {
//                    val postUrl = ""
//                    val postBody="{\n" +
//                            "    \"name\": \"morpheus\",\n" +
//                            "    \"job\": \"leader\"\n" +
//                            "}"
//                    postRequest(postUrl, postBody)
//                } catch (e: IOException) {
//                    e.printStackTrace()
//                }
    }
    @Throws(IOException::class)
    fun run(userid: String){
        val client = OkHttpClient()
        val request: Request = Request.Builder()
            .url("https://demo.hashup.tech/std/items?std_id=$userid")
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("test",e.toString())
                call.cancel()
            }

            override fun onResponse(call: Call, response: Response) {

                val myResponse = response.body!!.string()
               var res = JSONObject(myResponse)
                res.getJSONArray("data")

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