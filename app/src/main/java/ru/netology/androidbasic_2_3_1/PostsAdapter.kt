package ru.netology.androidbasic_2_3_1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.netology.androidbasic_2_3_1.databinding.CardPostBinding

typealias OnLikeListener = (post: Post) -> Unit

class PostsAdapter(
    private val onLikeListener: OnLikeListener)
    : ListAdapter<Post, PostViewHolder>(PostDiffCallback()){
//    var list = emptyList<Post>()
//        set(value) {
//            field = value
//            notifyDataSetChanged()
//        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = CardPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding, onLikeListener)
    }

//    override fun getItemCount(): Int {
//        return list.size
//    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = getItem(position)
        holder.bind(post)
    }


}