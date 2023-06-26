package com.example.kotlinmachinetest.Activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinmachinetest.CommanClass.Global
import com.example.kotlinmachinetest.Adapter.UserAdapter
import com.example.kotlinmachinetest.UserViewModel
import com.example.kotlinmachinetest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userViewModel: UserViewModel
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Global.StatusBar(this);
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        userViewModel.getUsers()

        userViewModel.users.observe(this) { users ->
            userAdapter = UserAdapter(users, clickListener = {
                val intent = Intent(this@MainActivity, UserDetailsActivity::class.java)
                intent.putExtra("data", it)
                startActivity(intent)
            })
            binding.tvText.visibility = View.GONE;
            binding.rvItems.adapter = userAdapter
        }
    }
}