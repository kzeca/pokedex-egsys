package com.egsys.pokedex.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.egsys.pokedex.R

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        supportActionBar?.hide()
    }
}