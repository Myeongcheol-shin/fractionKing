package com.shino72.fractionking.game

import android.app.AlertDialog
import android.content.Intent
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.shino72.fractionking.R
import com.shino72.fractionking.databinding.ActivityGameBinding
import com.shino72.fractionking.global.BaseActivity
import com.shino72.fractionking.main.MainActivity

class GameActivity : BaseActivity<ActivityGameBinding>() {
    override var layoutResourceId: Int = R.layout.activity_game
    private lateinit var gameViewModel: GameViewModel

    override fun initBinding() {
        gameViewModel = ViewModelProvider(this)[GameViewModel::class.java]
        binding.gameActivity = gameViewModel

        // Observing game status
        gameViewModel.status.observe(this, Observer {
            if(it == false)
            {
                val builder = AlertDialog.Builder(this)
                val dialogView = layoutInflater.inflate(R.layout.dialog_end, null)
                dialogView.findViewById<AppCompatButton>(R.id.end).setOnClickListener{
                    finish()
                }
                builder.setView(dialogView).setCancelable(false).show()
            }
        })

        // score observe
        gameViewModel.score.observe(this, Observer {
            binding.score.text = it.toString()
        })

        // leftNumerator observe
        gameViewModel.leftNumerator.observe(this, Observer {
            binding.leftNum.text = it.toInt().toString()
        })

        // leftDemon observe
        gameViewModel.leftDemon.observe(this, Observer {
            binding.leftDm.text = it.toInt().toString()
        })

        // rightDemon observe
        gameViewModel.rightDemon.observe(this, Observer {
            binding.rightDm.text = it.toInt().toString()
        })

        // rightNumerator observe
        gameViewModel.rightNumerator.observe(this, Observer {
            binding.rightNum.text = it.toInt().toString()
        })
    }
}