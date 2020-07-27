package com.mycode.daggermvvm.repository

import com.mycode.daggermvvm.model.User

interface UserRepository {

    fun getUser(username: String, onSuccess: (user: User) -> Unit, onFailure: (t: Throwable) -> Unit)
}