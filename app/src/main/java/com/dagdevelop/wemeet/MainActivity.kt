package com.dagdevelop.wemeet

import android.content.Intent
import android.media.metrics.Event
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
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
    private val retrofit = ApiConfig

    // nécessaire pour pouvoir cibler manuellement les éléments de activity_main.xml
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Pour pouvoir cibler "manuellement" les éléments de activity_main.xml
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Requête API = async (mot-clé Kotlin = suspend)
        // Doit être dans un bloc de coroutine (= await)

        val event = EventApi.getEvent(1)
        binding.singleUserView.text = event.toString()
        /*
        try {
            runBlocking {
                //val user = UserApi.service.getUser(1).body()
                //val user = EventApi.service.getParticipants(1).body()!!
                val user = EventApi.service.getParticipants(1).body()!!
                binding.singleUserView.text = user.toString()
                // val res = EventApi.service.getEvent(1).body()!!
                // binding.singleUserView.text =  "${res.id} ${res.cityName} ${res.description}"
            }
        } catch (e: Exception) {
            binding.singleUserView.text = e.message
        }

         */
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
}