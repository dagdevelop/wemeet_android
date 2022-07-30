package com.dagdevelop.wemeet.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dagdevelop.wemeet.R
import com.dagdevelop.wemeet.UI.EventDetailsMenuFragment
import com.dagdevelop.wemeet.databinding.ActivityEventDetailsBinding

class EventDetailsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityEventDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val menu = EventDetailsMenuFragment.newInstance("MON EVENT", false)

        binding = ActivityEventDetailsBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}