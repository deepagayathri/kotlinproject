package com.example.mykotlinproject.Retrofit

import com.example.mykotlinproject.ModelClass.ArrayObjectPojo
import com.example.mykotlinproject.ModelClass.ObjWithMultiPojo
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*
import java.util.HashMap

public interface ApiInterface {


    @GET("json/your-booking")
    fun your_booking(@HeaderMap header: HashMap<String, String>): Call<ResponseBody>

    @GET("albums")
    fun albums(@HeaderMap header: HashMap<String, String>): Call<List<ArrayObjectPojo>>

    @FormUrlEncoded
    @POST("json/get_plan_detail")
    fun get_plan_detail(@HeaderMap header: HashMap<String, String>, @FieldMap data: HashMap<String, String>): Call<ResponseBody>



    @FormUrlEncoded
    @POST("api/providers/get")
    fun post_provider(@HeaderMap header: HashMap<String, String>,@FieldMap data: HashMap<String, String>):Call<ObjWithMultiPojo>

    @Multipart
    @POST("api/v1/user/update_photo")
    fun update_photo(@HeaderMap header: HashMap<String, String>, @Part filePart: MultipartBody.Part): Call<ResponseBody>

//    @GET("albums")
//    fun MyPojoCall(): List<MyModel>

}


//
//fun getOpenList(mId: String) {
//    if (AppUtils.isNetworkAvailable(activity!!)) {
//        ShowLoader()
//        val apiService = ApiInterface.create()
//        var call = apiService.getOpenshift(App.prefs?.agencyid!!, mId)
//        call.observeOn(Schedulers.newThread())
//            .subscribeOn(Schedulers.io())
//            .subscribe({ result ->
//                var res = result
//                HideLoader()
//                val gson = Gson()
//                val respone = result.string()
//                Log.e("getOpenList", "getOpenList " + respone)
//                val jsonObject = JSONObject(respone)
//                //                  Log.e("getTodayList", "Response " + jsonObject)
//                val mResponse = gson.fromJson(respone, UpcomingShift::class.java)
//                //                Log.e("getTodayList", "mResponse " + mResponse)
//                try {
//                    //  logLargeString()
//                    if (jsonObject.has("status")) {
//                        if (Integer.parseInt(jsonObject.getString("status")) == 1) {
//                            setAdapter(mResponse.response!!)
//                        }
//                    }
//                } catch (ex: java.lang.Exception) {
//                    Log.e(TAG, "Exception@@ ", ex)
//                    HideLoader()
//                }
//            }, { error ->
//                Log.e(TAG, "ERROR@@ ", error.cause)
//                HideLoader()
//            })
//    }
//}
//
//
//
//
//
//11:02
//fun getDirections(str_origin: String, str_dest: String, mSource: LatLng, mDestination: LatLng) {
//    if (AppUtils.isNetworkAvailable(mContext!!)) {
//        ShowLoader()
//        val apiService = ApiInterface.create(AppConstants.MAPBASE_URL)
//        var call = apiService.getDirections(str_origin, str_dest, "driving", getString(R.string.google_maps_key))
//        call.observeOn(Schedulers.newThread())
//            .subscribeOn(Schedulers.io())
//            .subscribe({ result ->
//                HideLoader()
//                try {
//                    val gson = Gson()
//                    val mResponses = result.string()
//                    val mResponse = gson.fromJson(mResponses, Direction::class.java)
//                    if (mResponse.status.equals("OK")) {
//                        //  mResponse.routes[0].legs[0].distance.text
//                        Log.e(TAG, "distance@@ " + mResponse.routes[0].legs[0].distance.text)
//                        runOnUiThread {
//                            DistanceText.setText(mResponse.routes[0].legs[0].distance.text)
//                        }
//                        val jsonObject = JSONObject(mResponses)
//                        getRouteResponse(parse(jsonObject), mSource, mDestination)
//                        /*  mResponse.routes[0].legs[0].steps
//                          for (i in 0 until mResponse.routes[0].legs[0].steps.size) {
//                          }*/
//                    } else {
//                        if (mResponse.status.equals("ZERO_RESULTS")) {
//                            AppUtils.toast(mActivity, mContext, getResources().getString(R.string.map_view))
//                        }
//                    }
//                } catch (ex: java.lang.Exception) {
//                    Log.e(TAG, "Exception@@ ", ex)
//                    HideLoader()
//                }
//            }, { error ->
//                Log.e(TAG, "ERROR@@ ", error.cause)
//                Log.e(TAG, "ERROR@@ " + error.message)
//                HideLoader()
//            })
//    }
//}
//11:04
//val apiService = ApiInterface.create()
//ShowLoader()
//var call = apiService.getProfileEdit(
//    mImage!!,
//    userIdBody,
//    mConnfirmPassword,
//    mFirstname,
//    number,
//    emailid,
//    code,
//    dailcountry
//)
//call.observeOn(Schedulers.newThread())
//.subscribeOn(Schedulers.io())
//.subscribe({ result ->
//    var res = result
//    try {
//        val gson = Gson()
//        val mResponsee = result.string()
//        Log.e("getEditProfile", mResponsee.toString())
//        HideLoader()
//        val jsonObject = JSONObject(mResponsee)
//        Log.e("Response", "Response " + jsonObject)
//        if (jsonObject.has("status")) {
//            if (Integer.parseInt(jsonObject.getString("status")) == 1) {
//                AppUtils.toast(mActivity!!, mContext!!, jsonObject.getString("response"))
//                if (AppUtils.checkEmpty(jsonObject.getString("profileImage").toString())) {
//                    Log.e("Response", "Response " + jsonObject)
//                    //   {"status":1,"response":"Profile Updated Successfully","profileImage":"uploads\/images\/employee\/1571314018088.jpg"}
//                    mUrl =
//                        AppConstants.Companion.BASE_URL + "/" + jsonObject.getString("profileImage").toString()
//                    Log.e("Response", "mUrl " + mUrl)
//                    if (mActivity != null) {
//                        mActivity!!.runOnUiThread {
//                            App.prefs?.isUserLogined = "false"
//                            App.prefs?.clearPrefAll()
//                            ActivityLauncher.startLoginActivity(mActivity!!)
//                            mActivity!!.finish()
//                        }
//                    }
//                    //   Glide.with(this).load(mUrl).into(imageviewcircle);
//                }
//            }
//        }
//    } catch (ex: java.lang.Exception) {
//        //     Log.e(TAG, "Exception@@ ", ex)
//        HideLoader()
//    }
//}, { error ->
//    //    Log.e(TAG, "ERROR@@ ", error.cause)
//    //       Log.e(TAG, "ERROR@@ " + error.message)
//    HideLoader()
//})