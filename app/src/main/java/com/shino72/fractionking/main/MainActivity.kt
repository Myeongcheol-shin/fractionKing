package com.shino72.fractionking.main

import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.shino72.fractionking.game.GameActivity
import com.shino72.fractionking.R
import com.shino72.fractionking.databinding.ActivityMainBinding
import com.shino72.fractionking.global.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override var layoutResourceId: Int = R.layout.activity_main
    private lateinit var mainViewModel: MainViewModel
    override fun initBinding() {
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.mainActivity = mainViewModel

        // 난이도 observe
        mainViewModel.difficult.observe(this, Observer {
            binding.numTV.text = it.toString()
        })

        // Start Button
        binding.startBTN.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }
    }
}