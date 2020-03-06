package com.example.mykotlinproject.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mykotlinproject.R
import kotlinx.android.synthetic.main.activity_all_class.*

class AllClassActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_class)
        init()
    }

    private fun init() {
        Tv_RetrofitRecycler.setOnClickListener {
            val intent = Intent(this, ArrayObjects::class.java)
            startActivity(intent)
        }
        Tv_obj_multiarray.setOnClickListener {
            val intent = Intent(this, ObjectWithMultiArray::class.java)
            startActivity(intent)
        }


    }
}
