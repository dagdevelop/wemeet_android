package com.dagdevelop.wemeet.dataAccess.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dagdevelop.wemeet.dataAccess.dto.FOO_events
import com.dagdevelop.wemeet.dataAccess.dto.Event
import com.dagdevelop.wemeet.dataAccess.webService.EventApi
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

    private val _event = MutableLiveData<Event>()
    val event: LiveData<Event> = _event

    init {
        _allEvents.value = FOO_events
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
                val res = EventApi.service.getEvent(id)
                _event.value = res.body()
                _status.value = res.code().toString()
            }
        } catch (e : Exception) {
            _status.value = "Failure : ${e.message}"
        }
    }


}