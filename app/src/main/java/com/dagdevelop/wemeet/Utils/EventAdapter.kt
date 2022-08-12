package com.dagdevelop.wemeet.Utils

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.dagdevelop.wemeet.dataAccess.dto.Event
import androidx.lifecycle.LiveData
import com.dagdevelop.wemeet.R

class EventAdapter(
    private val context: Context,
    private val eventList: List<Event>,
    private val lifecycleOwner: LifecycleOwner
) : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    class EventViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val date: TextView = view.findViewById(R.id.item_view_event_date_text)
        val title: TextView = view.findViewById(R.id.item_view_event_title)
        val description: TextView = view.findViewById(R.id.item_view_event_description)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        TODO("Trouver comment placer les dates des evenements")
        val item = eventList[position]
        //holder.date.text =
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}