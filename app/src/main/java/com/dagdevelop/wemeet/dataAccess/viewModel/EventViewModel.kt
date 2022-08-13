package com.dagdevelop.wemeet.dataAccess.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dagdevelop.wemeet.dataAccess.dto.*
import com.dagdevelop.wemeet.webService.EventApi
import kotlinx.coroutines.launch
import java.lang.Exception

val TAG_EVM = "EventViewModel"

class EventViewModel : ViewModel() {
    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<String>()

    // The external immutable LiveData for the request status
    val status: LiveData<String> = _status

    private val _allEvents = MutableLiveData<List<Event>>()
    val allEvents: LiveData<List<Event>> = _allEvents

    private val _event = MutableLiveData<EventDetailsResponse>()
    val event: LiveData<EventDetailsResponse> = _event

    private val _surveys = MutableLiveData<List<Survey>>()
    val surveys: LiveData<List<Survey>> = _surveys

    private val _calendars = MutableLiveData<List<Calendar>>()
    val calendars: LiveData<List<Calendar>> = _calendars

    private val _eventRoles = MutableLiveData<List<EventRole>>()
    val eventRoles: LiveData<List<EventRole>> = _eventRoles

    init {
        getAllEvents()
    }

    private fun getAllEvents() {
        try {
            viewModelScope.launch {
                val res = EventApi.service.getAllEvents()
                _allEvents.value = res.body()
                _status.value = res.code().toString()
            }
        } catch (e: Exception) {
            _status.value = "Failure : ${e.message}"
        }
    }

    private fun getEvent(id: Int) {
        try {
            viewModelScope.launch {
                //val res = EventApi.service.getEvent(id)
                //_event.value = res.body()
                //_status.value = res.code().toString()
//
                //Log.d(TAG_EVM, "${_event.value.toString()}")
            }
        } catch (e : Exception) {
            _status.value = "Failure : ${e.message}"
        }
    }

    /*
    private fun deleteEvent(id: Int) {
        try {
            viewModelScope.launch {
                val res = Event
            }
        }
    }

     */
}