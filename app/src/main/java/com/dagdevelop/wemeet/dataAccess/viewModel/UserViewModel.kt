package com.dagdevelop.wemeet.dataAccess.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dagdevelop.wemeet.dataAccess.dataTransferObject.FOO_users
import com.dagdevelop.wemeet.dataAccess.dataTransferObject.User
import com.dagdevelop.wemeet.webService.UserApi
import kotlinx.coroutines.launch

const val TAG_VM = "UserViewModel"

class UserViewModel : ViewModel() {

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    init {
        _user.value = FOO_users[1]
    }

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
}