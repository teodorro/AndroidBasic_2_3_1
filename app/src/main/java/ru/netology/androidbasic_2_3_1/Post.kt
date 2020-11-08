package ru.netology.androidbasic_2_3_1

data class Post (
    val id: Int,
    val author: String,
    val content: String,
    val published: String,
    val likedByMe: Boolean,
    val likes: Int,
    val shares: Int,
    val views: Int
)