package com.sanstech.sanstechtask.utils

interface INetworkResponseHandling {
    fun loading(switch: Boolean)
    fun onErrorPopUp(header: String, body: String, showError : Boolean)
}