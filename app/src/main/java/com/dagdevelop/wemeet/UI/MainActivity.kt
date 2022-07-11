package com.dagdevelop.wemeet.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dagdevelop.wemeet.R
import kotlinx.android.synthetic.main.activity_main.*
import com.dagdevelop.wemeet.dataAccess.configuration.RetrofitConfig
import com.dagdevelop.wemeet.dataAccess.dto.User
import com.dagdevelop.wemeet.dataAccess.webService.UserApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val retrofit = RetrofitConfig.getClient()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        eventDetailsActivityButton.setOnClickListener {
            startActivity(Intent(this, EventDetailsActivity::class.java))
        }
    }

    private fun getUser(id : Int) {
        val data = retrofit.create(UserApi::class.java).getUser(id)

        data.enqueue(object : Callback<User?> { // CTRL + SHIFT + SPACE
            override fun onResponse(call: Call<User?>, response: Response<User?>) {

                val responseBody = response.body()

                val stringResponse = StringBuilder()

                stringResponse.append(responseBody?.firstName)
                stringResponse.append(" ")
                stringResponse.append(responseBody?.lastName)

                singleUserView.text = stringResponse
            }

            override fun onFailure(call: Call<User?>, t: Throwable) {
                Log.d("MainActivity", "onFailure"+t.message)
            }
        })
    }


}