package com.egsys.pokedex.ui.splash.onboarding.pages

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.egsys.pokedex.R
import kotlinx.android.synthetic.main.fragment_third_page.view.*

/**
 * Terceira tela do onBoarding
 */
class ThirdPageFragment : Fragment() {

    /**
     * Cria a View e direciona a navcontrol para a HomePage
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_third_page, container, false)

        view.btnLets.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_homeActivity)
            onBoardingFinished()
        }

        return view

    }

    /**
     * Ativa quando o onBoarding acaba e edita uma sharedPref para não abrir mais
     * ele nas próximas entradas do app
     */
    private fun onBoardingFinished(){
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("lets", true)
        editor.apply()
    }

}