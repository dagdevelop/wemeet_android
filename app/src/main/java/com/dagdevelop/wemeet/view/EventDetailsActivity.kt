package com.dagdevelop.wemeet.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.dagdevelop.wemeet.dataAccess.viewModel.EventDetailsViewModel
import com.dagdevelop.wemeet.databinding.ActivityEventDetailsBinding
import com.dagdevelop.wemeet.webService.EventApi

class EventDetailsActivity(eventId: Int) : AppCompatActivity() {

    private lateinit var binding : ActivityEventDetailsBinding

    private val viewModel: EventDetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEventDetailsBinding.inflate(layoutInflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        setContentView(binding.root)
    }
}