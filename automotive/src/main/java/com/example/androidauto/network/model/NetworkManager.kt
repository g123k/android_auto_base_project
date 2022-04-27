package com.example.androidauto.network.model

import com.example.androidauto.network.IDFElevatorsAPI

object NetworkManager {

    private val idfElevatorsAPI = IDFElevatorsAPI.getInstance()

    suspend fun listIdfElevators() : IdfElevators {
        return idfElevatorsAPI.listElevators().await()
    }

}