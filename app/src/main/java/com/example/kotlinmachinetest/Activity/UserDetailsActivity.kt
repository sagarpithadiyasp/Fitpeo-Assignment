package com.example.kotlinmachinetest.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinmachinetest.CommanClass.Global
import com.example.kotlinmachinetest.R
import com.example.kotlinmachinetest.User
import com.example.kotlinmachinetest.databinding.ActivityUserDetailsBinding
import com.squareup.picasso.Picasso

class UserDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Global.StatusBar(this);
        binding = ActivityUserDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        val data: User = intent.getSerializableExtra("data") as User

        binding.model = data
        Picasso.get()
            .load(data.url)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.placeholder)
            .into(binding.ivImage)

        Picasso.get()
            .load(data.thumbnailUrl)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.placeholder)
            .into(binding.ivImage1)

        binding.ivImageBack.setOnClickListener { onBackPressed() }

    }
}