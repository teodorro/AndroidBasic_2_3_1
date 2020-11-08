package ru.netology.androidbasic_2_3_1

import androidx.lifecycle.LiveData

interface PostRepository {
    fun get(): LiveData<Post>
    fun like()
    fun share()
}