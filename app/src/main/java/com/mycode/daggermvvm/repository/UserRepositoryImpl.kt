package com.mycode.daggermvvm.repository

import com.mycode.daggermvvm.model.User
import com.mycode.mvvmkotlin.network.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepositoryImpl(private val api: ApiInterface) : UserRepository {

    override fun getUser(username: String, onSuccess: (user: User) -> Unit, onFailure: (t: Throwable) -> Unit) {
        api.getUser(username).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                response.body()?.let { user ->
                    onSuccess.invoke(user)
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                onFailure.invoke(t)
            }
        })
    }
}