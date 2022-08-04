package com.dagdevelop.wemeet.UI

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dagdevelop.wemeet.R
import com.dagdevelop.wemeet.dataAccess.middleware.ApiConfig
import com.dagdevelop.wemeet.dataAccess.middleware.LoginRequest
import com.dagdevelop.wemeet.dataAccess.middleware.LoginResponse
import com.dagdevelop.wemeet.dataAccess.middleware.SessionManager
import com.dagdevelop.wemeet.dataAccess.webService.UserApi
import com.dagdevelop.wemeet.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import java.lang.Exception
import javax.security.auth.callback.Callback
import kotlin.math.log

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
