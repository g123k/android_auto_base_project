package com.example.androidauto

import android.content.Intent
import androidx.car.app.Screen
import androidx.car.app.Session

class AppSession : Session() {

    override fun onCreateScreen(intent: Intent): Screen {
        return HelloWorldScreen(carContext, this)
    }

}
