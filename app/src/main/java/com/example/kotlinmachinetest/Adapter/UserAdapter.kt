package com.example.kotlinmachinetest.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmachinetest.User
import com.example.kotlinmachinetest.databinding.ItemListUserBinding
import com.squareup.picasso.Picasso

class UserAdapter(
    private val userList: List<User>,
    val clickListener: (user: User) -> Unit
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemListUserBinding.inflate(inflater, parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    inner class UserViewHolder(private val binding: ItemListUserBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User) {
            binding.user = user
            Picasso.get()
                .load(user.thumbnailUrl)
                .into(binding.ivImage)

            binding.clMain.setOnClickListener {
                clickListener.invoke(user)
            }

            binding.executePendingBindings()
        }
    }
}