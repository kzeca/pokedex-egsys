package com.egsys.pokedex.ui.splash.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.egsys.pokedex.R
import com.egsys.pokedex.ui.splash.onboarding.pages.FirstPageFragment
import com.egsys.pokedex.ui.splash.onboarding.pages.SecondPageFragment
import com.egsys.pokedex.ui.splash.onboarding.pages.ThirdPageFragment
import kotlinx.android.synthetic.main.fragment_view_pager.view.*

/**
 * Fragment da viewPager, onde delimita-se as 3 ViewPages
 * de apresentação do SlideShow
 */
class ViewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)
        val fragmentList = arrayListOf(
            FirstPageFragment(),
            SecondPageFragment(),
            ThirdPageFragment()
        )

        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        view.viewPagerSplash.adapter = adapter

        return view
    }

}