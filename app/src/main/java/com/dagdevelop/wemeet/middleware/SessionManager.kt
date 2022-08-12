package com.dagdevelop.wemeet.middleware

import android.content.Context
import android.content.SharedPreferences
import com.auth0.android.jwt.JWT
import com.dagdevelop.wemeet.R

/**
 * Session manager to save and fetch data from SharedPreferences
 */
class SessionManager(context: Context) {
    private var prefs: SharedPreferences =
        context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    companion object {
        const val USER_TOKEN = "user_token"
    }

    /**
     * Function to save auth token
     */
    fun saveAuthToken(stringToken: String) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, stringToken)
        editor.apply()
    }

    fun saveAuthToken(jwt: JWT) {
        val stringToken: String = jwt.toString()
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, stringToken)
        editor.apply()
    }

    /**
     * Function to fetch auth token as a string
     */
    fun fetchAuthTokenAsString(): String? {
        return prefs.getString(USER_TOKEN, null)
    }

    /**
     * Function to fetch auth token as a JWT object
     */
    fun fetchAuthTokenAsJWT(): JWT? {
        return when (val token = fetchAuthTokenAsString()) {
            null -> token
            else -> JWT(token)
        }
    }
}