package com.shino72.fractionking.global

import androidx.lifecycle.MutableLiveData

object Difficulty {
    private val difficulty = MutableLiveData<Int>()
    init {
        difficulty.value = 1
    }
    fun setDifficulty(num : Int) {
        difficulty.value = num
    }
    fun getDifficulty() = difficulty
}