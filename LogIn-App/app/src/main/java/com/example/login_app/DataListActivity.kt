package com.example.login_app

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Klaxon
import okhttp3.*
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.internal.wait
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException

class DataListActivity : AppCompatActivity() {
    private var stListView: ListView? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_list)
        val std_id = intent.getStringExtra("std_id")!!
        this.stListView =  findViewById(R.id.firstListView)
        val exitBtn = findViewById<Button>(R.id.exitBtn)
        val newBtn = findViewById<Button>(R.id.newBtn)
        newBtn.setOnClickListener {
            val createActivityIntent = Intent(this, CreateActivity::class.java)
            createActivityIntent.putExtra("std_id",std_id)
            startActivity(createActivityIntent)

        }
        exitBtn.setOnClickListener {
            finish()

        }
    }

    override fun onStart() {
        super.onStart()

        val std_id = intent.getStringExtra("std_id")!!
        try {
            run(std_id)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
    @Throws(IOException::class)
    fun run(std_id: String){
        val client = OkHttpClient()
        val request: Request = Request.Builder()
            .url("https://demo.hashup.tech/std/items?std_id=$std_id")
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("test",e.toString())
                call.cancel()
            }

            override fun onResponse(call: Call, response: Response) {

                val myResponse = response.body!!.string()
                var res = JSONObject(myResponse)
                var data = res.getJSONArray("data")
                var dataList = mutableListOf<String>()
                for (i in 0 until  data.length()){

                    dataList.add(data.getJSONObject(i).getString("field_a"))
                }
                runOnUiThread {
                    val arrayAdapter =
                        ArrayAdapter(this@DataListActivity, R.layout.activity_listview, R.id.textView, dataList)
                    stListView?.adapter = arrayAdapter
                    stListView?.setOnItemClickListener { adapterView, view, i, l ->
                        val updateActivityIntent = Intent(this@DataListActivity, UpdateActivity::class.java)
                        updateActivityIntent.putExtra("std_id",std_id)
                        updateActivityIntent.putExtra("field",dataList[i])
                        startActivity(updateActivityIntent)
                    }
                }

            }
        })
    }


}