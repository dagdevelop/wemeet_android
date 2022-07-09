package com.dagdevelop.wemeet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dagdevelop.wemeet.dataAccess.webService.ApiService
import com.dagdevelop.wemeet.dataAccess.webService.UserDAO

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun getUser() {
        UserDAO.getUserById(1)
    }
}