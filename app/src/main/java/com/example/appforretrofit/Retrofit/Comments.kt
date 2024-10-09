package com.example.appforretrofit.Retrofit

// если нужно будет получить полный список комментариев
data class Osnova(
    val comments: List<Comment>
)

data class Comment(
    val id: Int,
    val body: String,
    val postId: Int,
    val likes: Int,
    val user: User
    )

data class User (
    val id: Int,
    val username: String,
    val fullName: String
)