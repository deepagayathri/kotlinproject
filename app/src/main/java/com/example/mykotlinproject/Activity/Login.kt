package com.example.mykotlinproject.Activity

import android.app.AlertDialog
import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mykotlinproject.R
import com.example.mykotlinproject.utils.CommonClass

import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {

    internal lateinit var cd: CommonClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
    }

    private fun init() {
//        var ET_username = findViewById(R.id.ET_username) as EditText
//        var ET_pwd = findViewById(R.id.ET_pwd) as EditText
        cd=CommonClass(this)

        BTN_Login.setOnClickListener {
            signInValidation()
        }
    }

    private fun signInValidation() {

        val userNameStr = ET_username.text
        val passwordStr = ET_pwd.text

        when {
            userNameStr.trim().isEmpty() -> alertFun(
                resources.getString(R.string.oops),
                resources.getString(R.string.user_errr)
            )
            passwordStr.trim().isEmpty() -> alertFun(
                resources.getString(R.string.oops),
                resources.getString(R.string.user_pwd)
            )
            else -> {
                if (cd.isConnectingToInternet()) {
                    val intent = Intent(this, AllClassActivity::class.java)
                    startActivity(intent)
                } else {
                    alertFun(resources.getString(R.string.oops), resources.getString(R.string.internet_connection))
                }
            }
        }

    }


    private fun alertFun(title: String, msg: String) {
        val dialogVar = AlertDialog.Builder(this)
        dialogVar.setMessage(msg)
            .setCancelable(false)
            .setPositiveButton(resources.getString(R.string.ok)) { _, _ ->
                finish()
            }
            // negative button text and action
            .setNegativeButton(resources.getString(R.string.cancel)) { dialog, _ ->
                dialog.cancel()
            }

        // create dialog box
        val alert = dialogVar.create()
        // set title for alert dialog box
        alert.setTitle(title)
        // show alert dialog
        alert.show()

    }

}
