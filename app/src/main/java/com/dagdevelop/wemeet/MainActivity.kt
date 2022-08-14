package com.dagdevelop.wemeet

import android.content.Intent
import android.media.metrics.Event
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.dagdevelop.wemeet.dataAccess.viewModel.EventViewModel
import com.dagdevelop.wemeet.view.EventDetailsActivity
import com.dagdevelop.wemeet.view.LoginActivity
import kotlinx.android.synthetic.main.activity_main.*
import com.dagdevelop.wemeet.middleware.ApiConfig
import com.dagdevelop.wemeet.webService.UserApi
import com.dagdevelop.wemeet.databinding.ActivityMainBinding
import com.dagdevelop.wemeet.webService.EventApi
import kotlinx.coroutines.*
import kotlin.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val eventViewModel: EventViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.vm = eventViewModel

        binding.lifecycleOwner = this

        setContentView(binding.root)
    }


    // Requête API = async (mot-clé Kotlin = suspend)
    // Doit être dans un bloc de coroutine (= await)

    // val event = EventApi.getEvent(1)
    // binding.singleUserView.text = event.toString()
/*
        // pour passer à l'activité EventDetails en attendant
        eventDetailsActivityButton.setOnClickListener {
            startActivity(Intent(this, EventDetailsActivity::class.java))
        }

        loginActivityButton.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
        }

         */
}