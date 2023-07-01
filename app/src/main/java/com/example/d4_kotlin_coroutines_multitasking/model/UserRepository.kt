package com.example.d4_kotlin_coroutines_multitasking.model

import kotlinx.coroutines.delay

class UserRepository {
    suspend fun getUsers() : List<User>{//will return a list of user
        delay(8000)
        val users : List<User> = listOf(
            User(1,"sam"),
            User(2,"tac"),
            User(3,"toe"),
            User(4,"hee"),
        )
        return users
    }
}