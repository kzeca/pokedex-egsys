package com.egsys.pokedex.ui.splash

import android.content.Context
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.egsys.pokedex.R


/**
 * Fragment da SplashScreen
 */
class SplashScreenFragment : Fragment() {

    /**
     * Cria a View, verifica se o navigation controller deve ir para a Home ou,
     * em caso de primeira entrada no app, para o onBoarding (SlideShow)
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Handler().postDelayed({
            if(onBoardingComplete()) {
                findNavController().navigate(R.id.action_splashScreenFragment_to_homeActivity)
            }
            else {
                findNavController().navigate(R.id.action_splashScreenFragment_to_viewPagerFragment)
            }

        }, 3500)

        return inflater.inflate(R.layout.fragment_splash_screen, container, false)
    }

    /**
     * Verifica se o onBoarding já foi visto
     * @return validação via sharedPref. Verdadeiro para sim, Falso para não
     */
    private fun onBoardingComplete(): Boolean{
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("lets", false)
    }

}