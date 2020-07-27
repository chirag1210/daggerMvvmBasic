package com.mycode.daggermvvm.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mycode.daggermvvm.model.User
import com.mycode.daggermvvm.repository.UserRepository
import com.mycode.daggermvvm.repository.UserRepositoryImpl
import com.mycode.mvvmkotlin.network.ApiInterface
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val userRepository: UserRepository) : ViewModel() {

    val liveData = MutableLiveData<String>()

    fun searchUser(username: String) {
        /*api.getUser(username).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                response.body()?.let { user ->
                    liveData.postValue(user.name)
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.e("MainActivity", "onFailure: ", t)
            }
        })*/
        userRepository.getUser(
            username,
            { user -> liveData.value = user.name },
            { t -> Log.e("MainActivity", "onFailure: ", t) }
        )
    }
}