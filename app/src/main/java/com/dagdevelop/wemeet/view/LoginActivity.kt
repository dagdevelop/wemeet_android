package com.dagdevelop.wemeet.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.auth0.android.jwt.JWT
import com.dagdevelop.wemeet.middleware.ApiConfig
import com.dagdevelop.wemeet.middleware.LoginRequest
import com.dagdevelop.wemeet.middleware.SessionManager
import com.dagdevelop.wemeet.webService.UserApi
import com.dagdevelop.wemeet.databinding.ActivityLoginBinding
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import java.lang.Exception

class LoginActivity : AppCompatActivity() {
    private lateinit var sessionManager: SessionManager
    private lateinit var apiClient: Retrofit
    private lateinit var jwt: JWT
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        apiClient = ApiConfig.getClient()
        sessionManager = SessionManager(this)

        binding.loginSubmitButton.setOnClickListener {
            val email = binding.loginEmailInputEditText.text.toString()
            val password = binding.loginPasswordInputEditText.text.toString()
            val encodedToken = UserApi.login(email, password)!!
            jwt = JWT(encodedToken)
            sessionManager.saveAuthToken(jwt)

            if(sessionManager.fetchAuthTokenAsString() != null)
                startActivity(Intent(this, EventListActivity::class.java))
        }

        /*
        try {
            runBlocking {
                val encodedToken =
                    UserApi.service.login(LoginRequest(email = "po@mail.com", password = "1234"))
                        .body()!!
                val jwt: JWT = JWT(encodedToken)
                val status: String = jwt.getClaim("status").asString()!!
                sessionManager.saveAuthToken(jwt)
            }
        } catch (e: Exception) {
            val errorPopup = Toast.makeText(this, "${e.message}", Toast.LENGTH_LONG)
            errorPopup.show()
        }

         */
    }
}
