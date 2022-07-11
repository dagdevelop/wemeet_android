package com.dagdevelop.wemeet.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dagdevelop.wemeet.R

private const val EVENT_TITLE = "eventTitle"
private const val IS_PRIVATE = "isPrivate"

/**
 * A simple [Fragment] subclass.
 * Use the [EventDetailsMenuFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EventDetailsMenuFragment : Fragment() {
    private var eventTitle: String? = null
    private var isPrivate: Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            println("|-------------> on passe par onCreate du EventDetailsMenu Fragment")
           eventTitle = it.getString(EVENT_TITLE)
           isPrivate = it.getBoolean(IS_PRIVATE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        println("|-------------> on passe par onCreateView de EventDetailsMenu Fragment")
        return inflater.inflate(R.layout.fragment_event_details_menu, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param eventTitle Title of the selected event.
         * @param isPrivate Indicates if the event is private or not.
         * @return A new instance of fragment EventDetailsMenu.
         */
        @JvmStatic
        fun newInstance(eventTitle: String, isPrivate: Boolean) =
            EventDetailsMenuFragment().apply {
                arguments = Bundle().apply {
                    putString(EVENT_TITLE, eventTitle)
                    putBoolean(IS_PRIVATE, isPrivate)
                }
            }
    }

}