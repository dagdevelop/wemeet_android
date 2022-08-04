package com.dagdevelop.wemeet.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.dagdevelop.wemeet.dataAccess.viewModel.EventViewModel
import com.dagdevelop.wemeet.databinding.FragmentEventDetailsTopBinding

private const val EVENT_TITLE = "eventTitle"
private const val IS_PRIVATE = "isPrivate"

/**
 * A simple [Fragment] subclass.
 * Use the [EventDetailsMenuFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EventDetailsMenuFragment : Fragment() {
    private val viewModel: EventViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentEventDetailsTopBinding.inflate(inflater)

        // allows data binding to observe LiveData with the lifecycle of this fragment
        binding.lifecycleOwner = this

        // give the binding access to the EventViewModel
        binding.eventViewModel = viewModel

        return binding.root
    }
}