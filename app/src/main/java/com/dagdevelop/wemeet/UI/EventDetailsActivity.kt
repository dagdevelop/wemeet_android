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
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_event_details_menu, menu, "fragment menu")
        transaction.commit()

        binding = ActivityEventDetailsBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}