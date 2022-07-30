package com.dagdevelop.wemeet.dataAccess.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dagdevelop.wemeet.dataAccess.dto.FOO_events
import com.dagdevelop.wemeet.dataAccess.dto.Event
import kotlinx.coroutines.launch

class EventViewModel {
    private val _event = MutableLiveData<Event>()
    val event: LiveData<Event> = _event

    init {
        _event.value = FOO_events[1]
    }

    /*
    private fun getUser(id: Int) {
        try {
            viewModelScope.launch {
                val res = UserApi.service.getUser(id)
                Log.d(TAG_VM, "getUser in ${TAG_VM} successful !!!")
            }
        } catch (e: Error) {
            Log.e(TAG_VM, "Error in ${TAG_VM} : ${e.message}")
        }
    }

     */
}