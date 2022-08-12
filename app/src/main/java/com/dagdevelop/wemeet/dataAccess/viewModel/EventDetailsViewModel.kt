package com.dagdevelop.wemeet.dataAccess.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dagdevelop.wemeet.dataAccess.dto.Calendar
import com.dagdevelop.wemeet.dataAccess.dto.Event
import com.dagdevelop.wemeet.dataAccess.dto.EventRole
import com.dagdevelop.wemeet.dataAccess.dto.User

class EventDetailsViewModel : ViewModel() {
    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status

    private val _event = MutableLiveData<Event>()
    val event: LiveData<Event> = _event

    private val _eventRoles = MutableLiveData<List<EventRole>>()
    val eventRoles: LiveData<List<EventRole>> = _eventRoles

    private val _calendars = MutableLiveData<List<Calendar>>()
    val calendar: LiveData<List<Calendar>> = _calendars

    private val _organizer = MutableLiveData<User>()
    val organizer: LiveData<User> = _organizer

    private val _participants = MutableLiveData<List<User>>()
    val participants: LiveData<List<User>> = _participants
}