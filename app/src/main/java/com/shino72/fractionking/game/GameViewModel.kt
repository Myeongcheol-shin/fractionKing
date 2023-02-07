package com.shino72.fractionking.game

import android.app.AlertDialog
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shino72.fractionking.global.Difficulty


class GameViewModel : ViewModel() {
    private val _status = MutableLiveData<Boolean>()
    private val _score = MutableLiveData<Int>()
    private val _leftDemon = MutableLiveData<Float>()
    private val _leftNumerator = MutableLiveData<Float>()
    private val _rightDemon = MutableLiveData<Float>()
    private val _rightNumerator = MutableLiveData<Float>()

    val status : LiveData<Boolean> get() = _status
    val leftDemon : LiveData<Float> get() = _leftDemon
    val leftNumerator : LiveData<Float> get() = _leftNumerator
    val rightDemon : LiveData<Float> get() = _rightDemon
    val rightNumerator : LiveData<Float> get() = _rightNumerator
    val score : LiveData<Int> get() = _score

    init {
        _score.value = 0
        _status.value = true
        setFraction()
    }

    private fun setFraction(){
        _leftDemon.value = randomNumber()
        _leftNumerator.value = randomNumber()
        _rightDemon.value = randomNumber()
        _rightNumerator.value = randomNumber()
    }

    private fun randomNumber() : Float{
        val range : IntRange

        when (Difficulty.getDifficulty().value)
        {
            1 -> {range = (1..9)}
            2 -> {range = (1..99)}
            3 -> {range = (1..999)}
            4 -> {range = (1..9999)}
            else -> {range = (1..9)}
        }
        return range.random().toFloat()
    }

    fun leftButton(){
        if(compare() == 1){
            _score.value = _score.value?.plus(1)
            setFraction()
        }
        else _status.value = false
    }

    fun rightButton(){
        if(compare() == -1){
            _score.value = _score.value?.plus(1)
            setFraction()
        }
        else _status.value = false
    }

    fun sameButton(){
        if(compare() == 0){
            _score.value = _score.value?.plus(1)
            setFraction()
        }
        else _status.value = false
    }

    private fun compare() : Int{
        val leftFraction : Float = _leftDemon.value!! / _leftNumerator.value!!
        val rightFraction : Float = _rightDemon.value!! / _rightNumerator.value!!
        if(leftFraction > rightFraction) return 1
        else if(leftFraction == rightFraction) return 0
        else return -1
    }
}
