@file:Suppress("DEPRECATION")

package com.example.mykotlinproject.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.kaopiz.kprogresshud.KProgressHUD

@SuppressLint("Registered")
 class CommonClass(val _context: Context) : AppCompatActivity() {


    internal lateinit var c: Activity
    internal  var hud: KProgressHUD=KProgressHUD(_context)

    fun showSnackBar(view: View, msg: String) {
        Snackbar.make(view, msg, Snackbar.LENGTH_LONG)
            .setAction("Action", null).show()
    }

    fun isConnectingToInternet(): Boolean {
        val connectivity = _context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val info = connectivity.allNetworkInfo
        for (i in info.indices)
            if (info[i].state == NetworkInfo.State.CONNECTED) {
                return true
            }

        return false
    }

    fun ShowProgress(c: Activity) {
        this.c = c
        hud = KProgressHUD.create(c)
            .setBackgroundColor(Color.parseColor("#C797C7"))
            .setWindowColor(Color.parseColor("#AA1776"))
            .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
    }



    fun showProgress() {
        hud.show()
    }
    fun dismissProgress() {
        hud.dismiss()
    }


}