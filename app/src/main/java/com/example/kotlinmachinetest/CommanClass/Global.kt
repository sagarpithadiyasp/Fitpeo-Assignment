package com.example.kotlinmachinetest.CommanClass

import android.R
import android.app.Activity
import android.content.Context
import android.view.Window
import android.view.WindowManager
import androidx.core.content.ContextCompat

class Global {
    companion object {

        fun StatusBar(activity: Activity) {
            val window: Window = activity.getWindow()
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.setStatusBarColor(ContextCompat.getColor(activity, R.color.black))
        }
    }
}