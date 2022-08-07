package com.dagdevelop.wemeet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dagdevelop.wemeet.view.EventDetailsActivity
import com.dagdevelop.wemeet.view.LoginActivity
import kotlinx.android.synthetic.main.activity_main.*
import com.dagdevelop.wemeet.middleware.ApiConfig
import com.dagdevelop.wemeet.webService.UserApi
import com.dagdevelop.wemeet.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import java.lang.Exception

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
        try {
            runBlocking {
                val user = UserApi.service.getUser(1).body()
                binding.singleUserView.text = "${ user?.firstName } ${user?.lastName} ${user?.address}"
            }
        } catch (e: Exception) {
            binding.singleUserView.text = e.message
        }

        // pour passer à l'activité EventDetails en attendant
        eventDetailsActivityButton.setOnClickListener {
            startActivity(Intent(this, EventDetailsActivity::class.java))
        }

        loginActivityButton.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}