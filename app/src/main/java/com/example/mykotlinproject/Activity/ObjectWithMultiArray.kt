package com.example.mykotlinproject.Activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mykotlinproject.Adapter.DeliveryTypeAdapter
import com.example.mykotlinproject.ModelClass.DeliveryTypesItem
import com.example.mykotlinproject.ModelClass.ObjWithMultiPojo
import com.example.mykotlinproject.R
import com.example.mykotlinproject.Retrofit.ApiClient
import com.example.mykotlinproject.Retrofit.ApiInterface
import com.example.mykotlinproject.utils.CommonClass
import kotlinx.android.synthetic.main.activity_array_obj.*
import kotlinx.android.synthetic.main.activity_object_with_multi_array.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class ObjectWithMultiArray : AppCompatActivity() {
    lateinit var cd: CommonClass
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_object_with_multi_array)
        init();
    }

    private fun init() {
        cd = CommonClass(this)
        if (cd.isConnectingToInternet()) {
            provider_Api()
        } else {
            cd.showSnackBar(Tv_no_internet, resources.getString(R.string.internet_connection))
        }


    }


    //    Body:
//    user_id:5df32ff54c7f333a8845e402
    private fun provider_Api() {
        cd.showProgress();
        val apiService = ApiClient.getClient()?.create(ApiInterface::class.java)

        val header = HashMap<String, String>()
        header["Content-Type"] = "application/x-www-form-urlencoded"
        header["Authkey"] = "1tyuf4uiyig5hjh68"
        val map = HashMap<String, String>()
        map["user_id"] = "5df32ff54c7f333a8845e402"

        var response = apiService?.post_provider(header, map)
        Log.e("provider_response", response.toString())


        response!!.enqueue(object : Callback<ObjWithMultiPojo> {
            override fun onResponse(call: Call<ObjWithMultiPojo>, response: Response<ObjWithMultiPojo>) = try {

                println("------success----------")
                if (response.body() != null) {

                    if (response.body()!!.status.equals("1")) {
                        Tvstatus.text = response.body()!!.status
                        Tv_msg.text = response.body()!!.message

                        delivery_RV.layoutManager =
                            LinearLayoutManager(applicationContext)
                        delivery_RV.adapter =
                            DeliveryTypeAdapter(response.body()!!.response!!.deliveryTypes as ArrayList<DeliveryTypesItem>, applicationContext)
                    }
                }
                cd.dismissProgress()
            } catch (e: Exception) {
                cd.dismissProgress()

                e.printStackTrace()
            }

            override fun onFailure(call: Call<ObjWithMultiPojo>, t: Throwable) {
                cd.dismissProgress()
                val str_server_erro = t.message
                println("----failure----->$str_server_erro")
            }


        })

    }
}
