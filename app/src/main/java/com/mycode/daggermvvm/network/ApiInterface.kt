package com.mycode.mvvmkotlin.network


import com.mycode.daggermvvm.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("users/{user}")
    fun getUser(@Path("user") user: String): Call<User>
}