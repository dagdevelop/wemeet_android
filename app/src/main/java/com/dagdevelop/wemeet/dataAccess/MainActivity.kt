package com.dagdevelop.wemeet.dataAccess

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dagdevelop.wemeet.R
import com.dagdevelop.wemeet.UI.EventDetailsActivity
import kotlinx.android.synthetic.main.activity_main.*
import com.dagdevelop.wemeet.dataAccess.configuration.ApiConfig
import com.dagdevelop.wemeet.dataAccess.dto.User
import com.dagdevelop.wemeet.dataAccess.webService.UserApi
import com.dagdevelop.wemeet.dataAccess.webService.UserApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val retrofit = ApiConfig
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        eventDetailsActivityButton.setOnClickListener {
            startActivity(Intent(this, EventDetailsActivity::class.java))
        }
    }
}