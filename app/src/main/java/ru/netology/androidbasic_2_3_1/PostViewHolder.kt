package ru.netology.androidbasic_2_3_1

import androidx.recyclerview.widget.RecyclerView
import ru.netology.androidbasic_2_3_1.databinding.CardPostBinding

class PostViewHolder(
    private val binding: CardPostBinding,
    private val onLikeListener: OnLikeListener
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(post: Post) {
        binding.apply {
            textViewAuthor.text = post.author
            textViewMessage.text = post.content
            textViewPublished.text = post.published
            imageButtonLikes.setImageResource(
                if (post.likedByMe) R.drawable.ic_liked_24 else R.drawable.ic_like_outline_24
            )
            imageButtonLikes.setOnClickListener { onLikeListener(post) }
        }
    }
}
