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

class SplashScreenFragment : Fragment() {

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

    private fun onBoardingComplete(): Boolean{
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("lets", false)
    }

}