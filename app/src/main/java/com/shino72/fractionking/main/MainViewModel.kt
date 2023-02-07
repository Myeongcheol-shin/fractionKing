package com.shino72.fractionking.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shino72.fractionking.global.Difficulty

class MainViewModel() : ViewModel() {
    private val _difficult : MutableLiveData<Int> = Difficulty.getDifficulty()

    val difficult : LiveData<Int> get() = _difficult

    fun increase() {
        if(_difficult.value == 4) _difficult.value = 1
        else _difficult.value = _difficult.value?.plus(1)
        Difficulty.setDifficulty(_difficult.value!!)
    }

    fun decrease() {
        if(_difficult.value == 1) _difficult.value = 4
        else _difficult.value = _difficult.value?.minus(1)
        Difficulty.setDifficulty(_difficult.value!!)
    }
}