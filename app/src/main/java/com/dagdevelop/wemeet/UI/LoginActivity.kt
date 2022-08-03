package com.dagdevelop.wemeet.UI

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dagdevelop.wemeet.R
import com.dagdevelop.wemeet.dataAccess.middleware.ApiConfig
import com.dagdevelop.wemeet.dataAccess.middleware.LoginRequest
import com.dagdevelop.wemeet.dataAccess.middleware.LoginResponse
import com.dagdevelop.wemeet.dataAccess.middleware.SessionManager
import com.dagdevelop.wemeet.dataAccess.webService.UserApi
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import javax.security.auth.callback.Callback

class LoginActivity : AppCompatActivity() {
    private lateinit var sessionManager: SessionManager
    private lateinit var apiClient: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        apiClient = ApiConfig.getClient()
        sessionManager = SessionManager(this)
/*
        UserApi.service.login(LoginRequest(email = "po@mail.com", password = "1234"))
            .enqueue(object : Callback<LoginResponse> {
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    // Error logging in
                }

                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    val loginResponse = response.body()

                    if (loginResponse?.statusCode == 200 && loginResponse.user != null) {
                        sessionManager.saveAuthToken(loginResponse.authToken)
                    } else {
                        // Error logging in
                    }
                }
            })
*/
    }
}
