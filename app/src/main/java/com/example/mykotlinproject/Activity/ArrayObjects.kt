package com.example.mykotlinproject.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mykotlinproject.Adapter.ArrayObjectAdapter


import com.example.mykotlinproject.ModelClass.ArrayObjectPojo

import com.example.mykotlinproject.R
import com.example.mykotlinproject.Retrofit.ApiClient
import com.example.mykotlinproject.Retrofit.ApiInterface
import com.example.mykotlinproject.utils.CommonClass
import kotlinx.android.synthetic.main.activity_array_obj.*

import okhttp3.OkHttpClient

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import retrofit2.Retrofit
import java.io.IOException

import java.util.HashMap
import java.util.concurrent.TimeUnit

class ArrayObjects : AppCompatActivity() {

    private var retrofit: Retrofit? = null
    private var retrofitGoogle: Retrofit? = null
    private val okHttpClient = OkHttpClient.Builder().connectTimeout(90, TimeUnit.SECONDS)
        .build()

    lateinit var cd: CommonClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_array_obj)
        init()
    }

    private fun init() {
        cd = CommonClass(this)

        if (cd.isConnectingToInternet()) {
            booking()
        } else {
            cd.showSnackBar(Tv_no_internet, resources.getString(R.string.internet_connection))
        }


    }

    fun booking() {

        cd.showProgress();
        val apiService = ApiClient.getClient()?.create(ApiInterface::class.java)

        //passing header files
        val header = HashMap<String, String>()
//        header["AuthToken"] =
//            "eyJ0eXAiOiJqd3QiLCJhbGciOiJIUzI1NiIsImNydCI6IjE1ODMyMjAzNTkifQ==.eyJ1c2VyaWQiOiI1MSIsImFjY2VzcyI6Ikd1ZXN0IiwibGlmZXRpbWUiOiI0OCJ9.N2I3ZjRkODU0ZGRkYzdmZjBhNTBlYmVhNzU0NGQ0ZThkYjNhNWZmYzEzN2QyNmM2MTZlZjYwN2M3OTg4ZTYwNw=="
//        header["Currency"] = "USD"
        var response = apiService?.albums(header)

        Log.e("albums_response", response.toString())

        response!!.enqueue(object : Callback<List<ArrayObjectPojo>> {
            override fun onResponse(call: Call<List<ArrayObjectPojo>>, response: Response<List<ArrayObjectPojo>>) {
                try {

                    println("------success----------")
                    if (!response.isSuccessful) {
                        try {
                            Log.e("LOG", "Retrofit Response: " + response.errorBody()!!.string())
                        } catch (e: IOException) {
                            e.printStackTrace()
                        }

                    }
                    if (response.body() != null) {
                        val Str_response = response.body()!!.toString()
                        Log.e("album Response-->", Str_response)
//                        val `object` = JSONObject(Str_response)
                        recycler_booking.layoutManager = LinearLayoutManager(applicationContext) as RecyclerView.LayoutManager?
                        recycler_booking.adapter = ArrayObjectAdapter(response.body() as ArrayList<ArrayObjectPojo>, applicationContext)
                    }
//                            no_history.setVisibility(View.VISIBLE);
                    cd.dismissProgress()
                } catch (e: Exception) {
                    cd.dismissProgress()

                    e.printStackTrace()
                }

            }

            override fun onFailure(call: Call<List<ArrayObjectPojo>>, t: Throwable) {
                cd.dismissProgress()
                val str_server_erro = t.message
                println("----failure----->$str_server_erro")
            }


        })


    }
}
