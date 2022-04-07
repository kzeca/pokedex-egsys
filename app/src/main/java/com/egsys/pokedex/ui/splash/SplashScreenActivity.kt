package com.egsys.pokedex.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.egsys.pokedex.R

/**
 * Primeira tela do app, que apresenta o nome do aplicativo e
 * logo da empresa
 */
class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        supportActionBar?.hide()
    }
}