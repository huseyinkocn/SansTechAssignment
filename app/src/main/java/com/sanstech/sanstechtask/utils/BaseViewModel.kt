package com.sanstech.sanstechtask.utils

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


open class BaseViewModel : ViewModel(), INetworkResponseHandling {
    private val errorMessage: MutableLiveData<String> = MutableLiveData()
    private val loading: MutableLiveData<Boolean> = MutableLiveData()

    //region interface
    override fun loading(switch: Boolean) {
        loading.value = switch
    }

    override fun onErrorPopUp(header: String, body: String, showError: Boolean) {
        if (showError) {
            errorMessage.value = body
        }
    }
    //endregion




    
}
