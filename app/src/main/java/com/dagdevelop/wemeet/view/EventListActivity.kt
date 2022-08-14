package com.dagdevelop.wemeet.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dagdevelop.wemeet.dataAccess.dto.Event
import com.dagdevelop.wemeet.databinding.ActivityEventListBinding
import com.dagdevelop.wemeet.webService.EventApi

class EventListActivity : AppCompatActivity() {

    private lateinit var binding : ActivityEventListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var events: List<Event> = EventApi.getAllEvents()

        binding = ActivityEventListBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}