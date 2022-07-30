package com.dagdevelop.wemeet.dataAccess.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dagdevelop.wemeet.dataAccess.dto.FOO_users
import com.dagdevelop.wemeet.dataAccess.dto.User
import com.dagdevelop.wemeet.dataAccess.webService.UserApi
import kotlinx.coroutines.launch
import java.lang.Exception

const val TAG_VM = "UserViewModel"

class UserViewModel : ViewModel() {
    /*
    private val _firstName = MutableLiveData<String>()
    val firstName: LiveData<String> = _firstName

    private val _lastName = MutableLiveData<String>()
    val lastName: LiveData<String> = _lastName

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _address = MutableLiveData<String?>()
    val address: LiveData<String?> = _address

    private val _postalCode = MutableLiveData<Int?>()
    val postalCode: LiveData<Int?> = _postalCode

    private val _isAdmin = MutableLiveData<Boolean>()
    val isAdmin: LiveData<Boolean> = _isAdmin
     */

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