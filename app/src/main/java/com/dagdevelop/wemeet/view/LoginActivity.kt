package com.dagdevelop.wemeet.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dagdevelop.wemeet.middleware.ApiConfig
import com.dagdevelop.wemeet.middleware.LoginRequest
import com.dagdevelop.wemeet.middleware.LoginResponse
import com.dagdevelop.wemeet.middleware.SessionManager
import com.dagdevelop.wemeet.webService.UserApi
import com.dagdevelop.wemeet.databinding.ActivityLoginBinding
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import java.lang.Exception

class LoginActivity : AppCompatActivity() {
    private lateinit var sessionManager: SessionManager
    private lateinit var apiClient: Retrofit
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        apiClient = ApiConfig.getClient()
        sessionManager = SessionManager(this)

        try {
            runBlocking {
                val token: LoginResponse? = UserApi.service.login(LoginRequest(email = "po@mail.com", password = "1234")).body()
                binding.loginAppTitleTxt.text = token.toString()
            }
        } catch (e : Exception) {
            val errorPopup = Toast.makeText(this, "${e.message}", Toast.LENGTH_LONG)
            errorPopup.show()
        }
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
