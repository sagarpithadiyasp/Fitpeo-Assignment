package com.example.kotlinmachinetest

import android.os.Parcel
import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinmachinetest.ApiClient.UserRepository
import kotlinx.coroutines.launch

class UserViewModel() : ViewModel(), Parcelable {
    private val userRepository = UserRepository()

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = _users

    constructor(parcel: Parcel) : this() {
    }

    fun getUsers() {
        viewModelScope.launch {
            try {
                val userList = userRepository.getUsers()
                _users.value = userList
            } catch (e: Exception) {
                // Handle error
            }
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserViewModel> {
        override fun createFromParcel(parcel: Parcel): UserViewModel {
            return UserViewModel(parcel)
        }

        override fun newArray(size: Int): Array<UserViewModel?> {
            return arrayOfNulls(size)
        }
    }

    /*private fun createOnClickListener(itemId: Int): View.OnClickListener {
        return View.OnClickListener {
            // Handle item click event here
            // You can access the clicked item using itemId parameter
        }
    }*/
}