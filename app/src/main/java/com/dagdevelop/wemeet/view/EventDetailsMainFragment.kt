package com.dagdevelop.wemeet.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.dagdevelop.wemeet.dataAccess.viewModel.EventViewModel
import com.dagdevelop.wemeet.databinding.FragmentEventDetailsMainBinding

class EventDetailsMainFragment : Fragment() {
    private val viewModel: EventViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentEventDetailsMainBinding.inflate(inflater)

        // allows data binding to observe LiveData with the lifecycle of this fragment
        binding.lifecycleOwner = this

        // give the binding access to the EventViewModel
        binding.eventViewModel = viewModel

        return binding.root
    }
}