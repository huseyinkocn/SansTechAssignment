package com.sanstech.sanstechtask.ui.mainPage.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sanstech.sanstechtask.data.model.ScoreServiceEntity
import com.sanstech.sanstechtask.data.repository.ScoreListRepository
import com.sanstech.sanstechtask.utils.BaseViewModel
import com.sanstech.sanstechtask.utils.DataHolder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScoreListViewModel @Inject constructor(private val repository: ScoreListRepository) : BaseViewModel() {

    val scoreListData: MutableLiveData<ScoreServiceEntity?> = MutableLiveData()

    fun getScoreList() {
        viewModelScope.launch {

            val response = repository.getScoreList(this@ScoreListViewModel)

            response.let {
                if (it is DataHolder.Success) {
                    if (it.body.success == true) {
                        scoreListData.postValue(it.body)
                    }
                }
            }

        }
    }

}