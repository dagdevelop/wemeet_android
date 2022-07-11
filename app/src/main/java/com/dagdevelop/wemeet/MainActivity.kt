package com.dagdevelop.wemeet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import com.dagdevelop.wemeet.dataAccess.configuration.RetrofitConfig
import com.dagdevelop.wemeet.dataAccess.dto.MyDataItem
import com.dagdevelop.wemeet.dataAccess.dto.User
import com.dagdevelop.wemeet.dataAccess.webService.TestApiInterface
import com.dagdevelop.wemeet.dataAccess.webService.UserApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val retrofit = RetrofitConfig.getClient()
    private val retroTest  = RetrofitConfig.getTestClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //getMyData()
        getUser(1)
    }

    private fun getMyData() {
        val data = retroTest.create(TestApiInterface::class.java).getData()

        data.enqueue(object : Callback<List<MyDataItem>?> {
            override fun onResponse(call: Call<List<MyDataItem>?>, response: Response<List<MyDataItem>?>) {
                Log.d("MainActivity", "Download")

                val responseBody = response.body()!!

                val stringResponse = StringBuilder()
                for(myData in responseBody){
                    stringResponse.append(myData.id)
                    stringResponse.append("\n")
                }

                singleUserView.text = stringResponse
            }

            override fun onFailure(call: Call<List<MyDataItem>?>, t: Throwable) {
                Log.d("MainActivity", "onFailure"+t.message)
            }
        })
    }

    private fun getUser(id : Int) {
        val data = retrofit.create(UserApi::class.java).getUser(id)

        println("Téléchargement")
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