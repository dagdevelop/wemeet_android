package com.dagdevelop.wemeet.Utils

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.dagdevelop.wemeet.dataAccess.dto.Event
import com.dagdevelop.wemeet.R
import com.dagdevelop.wemeet.dataAccess.dto.Calendar

class EventDetailsAdapter(
    private val context: Context,
    private val eventList: List<Event>,
    private val calendar: Calendar,
    private val lifecycleOwner: LifecycleOwner
) : RecyclerView.Adapter<EventDetailsAdapter.EventDetailsViewHolder>() {

    class EventDetailsViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val date: TextView = view.findViewById(R.id.item_view_event_nbParticipants_text)
        val title: TextView = view.findViewById(R.id.item_view_event_title)
        val description: TextView = view.findViewById(R.id.item_view_event_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventDetailsViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: EventDetailsViewHolder, position: Int) {
        TODO("Trouver comment placer les dates des evenements")
        val item = eventList[position]
        //holder.date.text =
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}