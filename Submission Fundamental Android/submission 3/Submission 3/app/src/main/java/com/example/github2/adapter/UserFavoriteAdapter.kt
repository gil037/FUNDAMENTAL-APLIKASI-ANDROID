package com.example.github2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.github2.R
import com.example.github2.data.database.UserFavorite
import com.example.github2.databinding.ItemUserBinding

class UserFavoriteAdapter(
    private val userFavorites: List<UserFavorite>,
    private val onItemClickCallback: UserFavoriteAdapter.OnItemClickCallback
) : RecyclerView.Adapter<UserFavoriteAdapter.UserFavoriteViewHolder>() {

    class UserFavoriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemUserBinding.bind(itemView)

        fun bind(userFavorites: UserFavorite) {
            binding.apply {
                nameTextview.text = userFavorites.login
                Glide.with(itemView.context)
                    .load(userFavorites.avatar)
                    .into(photoUserImageview)
            }
        }
    }

    interface OnItemClickCallback {
        fun onClick(userFavorites: UserFavorite)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserFavoriteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserFavoriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserFavoriteViewHolder, position: Int) {
        holder.bind(userFavorites[position])
        holder.itemView.setOnClickListener {
            onItemClickCallback.onClick(userFavorites[position])
        }
    }

    override fun getItemCount() = userFavorites.size
}