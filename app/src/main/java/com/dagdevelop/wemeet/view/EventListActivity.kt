package com.dagdevelop.wemeet.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dagdevelop.wemeet.databinding.ActivityEventListBinding

class EventListActivity : AppCompatActivity() {

    private lateinit var binding : ActivityEventListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEventListBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}