package ru.netology.androidbasic_2_3_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.observe
import ru.netology.androidbasic_2_3_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)

        val viewModel: PostViewModel by viewModels()
        viewModel.data.observe(this) { post ->
            with(binding) {
                textViewAuthor.text = post.author
                textViewMessage.text = post.content
                textViewPublished.text = post.published
                textViewLikes.text = convertIntToStr(post.likes)
                textViewShares.text = convertIntToStr(post.shares)
                textViewViews.text = convertIntToStr(post.views)
                imageButtonLikes.setImageResource(
                    if (post.likedByMe) R.drawable.ic_liked_24 else R.drawable.ic_like_outline_24
                )
            }
        }
        binding.imageButtonLikes.setOnClickListener { viewModel.like() }
        binding.imageButtonShares.setOnClickListener { viewModel.share() }
    }

    private fun convertIntToStr(value: Int): String{
        return when(value){
            in 0..999 -> value.toString()
            in 1000..1099 -> (value / 1000).toString() + "K"
            in 1100..9999 -> ((value / 100).toDouble() / 10).toString() + "K"
            in 10000..999000 -> (value / 1000).toString() + "K"
            in 1000000..1099999 -> (value / 1000000).toString() + "M"
            in 1100000..9999999 -> ((value / 100000).toDouble() / 10).toString() + "M"
            in 10000000..999999999 -> (value / 1000000).toString() + "M"
            else -> value.toString()
        }
    }
}