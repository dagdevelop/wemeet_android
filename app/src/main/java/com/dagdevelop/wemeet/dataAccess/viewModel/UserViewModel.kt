package com.dagdevelop.wemeet.dataAccess.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dagdevelop.wemeet.dataAccess.dto.User
import com.dagdevelop.wemeet.webService.UserApi
import kotlinx.coroutines.launch

const val TAG_VM = "UserViewModel"

class UserViewModel : ViewModel() {

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    init {
        _user.value = getUser(1)
    }

    private fun getUser(id: Int): User? {
        var user: User? = null
        try {
            viewModelScope.launch {
                val res = UserApi.service.getUser(id)
                Log.d(TAG_VM, "getUser in ${TAG_VM} successful !!!")
                user = res.body()!!
            }
        } catch (e: Exception) {
            Log.e(TAG_VM, "Error in ${TAG_VM} : ${e.message}")
        }
        return user
    }
}