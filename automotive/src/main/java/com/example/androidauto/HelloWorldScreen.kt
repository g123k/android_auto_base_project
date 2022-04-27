package com.example.androidauto

import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.Session
import androidx.car.app.model.*

class HelloWorldScreen(carContext: CarContext, val sessions: Session) : Screen(carContext) {

    override fun onGetTemplate(): Template {
        val row = Row.Builder().setTitle("Hello World !").build()

        return PaneTemplate.Builder(Pane.Builder().addRow(row).build())
            .setHeaderAction(Action.APP_ICON)
            .build()
    }

}