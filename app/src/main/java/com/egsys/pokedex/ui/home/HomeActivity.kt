package com.egsys.pokedex.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.egsys.pokedex.R
import com.egsys.pokedex.ui.details.DetailsActivity
import com.egsys.pokedex.ui.filter.FilterActivity
import com.egsys.pokedex.ui.home.search.BottomSearchFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private val fromBtn: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.from_button)}
    private val toBtn: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.to_button)}

    private var clicked = false

    // todo: declarar vm
    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // todo: Inicializar VM
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        initUI()

    }

    private fun initUI() {

        rvPokemonList.layoutManager = LinearLayoutManager(this)
        rvPokemonList.adapter = PokemonListAdapter{
            val i = Intent(this, DetailsActivity::class.java)
            i.putExtra("pokemon", it)
            startActivity(i)
        }
        setViewModel()
        buttonsClicked()
    }

    private fun setViewModel() {
        // todo: Solicitar Lista
        viewModel.getPokemonList()

        // todo: Observar se a lista mudar
        viewModel.pokemonList.observe(this, Observer {
                list -> (rvPokemonList.adapter as PokemonListAdapter).setData(list)
        })

    }

    private fun buttonsClicked() {
        btnMenu.setOnClickListener {
            onMenuButtonClicked()
        }
        btnSearch.setOnClickListener {
            searchDialog()
        }
        btnFilter.setOnClickListener {
            filterActivity()
        }
        btnRandom.setOnClickListener {
            randomPokemonChoose()
        }
    }

    private fun randomPokemonChoose() {

        val i = Intent(this, DetailsActivity::class.java)
        i.putExtra("pokemon", (0..101).random())
        startActivity(i)
    }

    private fun filterActivity() {
        val i = Intent(this, FilterActivity::class.java)
        startActivity(i)
    }

    private fun searchDialog() {
        val bottomSearchFragment = BottomSearchFragment()
        bottomSearchFragment.show(supportFragmentManager, "TAG")
    }


    private fun onMenuButtonClicked() {
        setVisibility(clicked)
        setAnimation(clicked)
        setClickable(clicked)
        clicked = !clicked
    }

    private fun setVisibility(clicked: Boolean) {
        if(!clicked){
            btnSearch.visibility = View.VISIBLE
            btnFilter.visibility = View.VISIBLE
            btnRandom.visibility = View.VISIBLE
            txtSearch.visibility = View.VISIBLE
            txtFilter.visibility = View.VISIBLE
            txtRandom.visibility = View.VISIBLE
        }
        else{
            btnSearch.visibility = View.INVISIBLE
            btnFilter.visibility = View.INVISIBLE
            btnRandom.visibility = View.INVISIBLE
            txtSearch.visibility = View.INVISIBLE
            txtFilter.visibility = View.INVISIBLE
            txtRandom.visibility = View.INVISIBLE
        }
    }

    private fun setAnimation(clicked: Boolean) {
        if (!clicked) {
            btnSearch.startAnimation(fromBtn)
            btnFilter.startAnimation(fromBtn)
            btnRandom.startAnimation(fromBtn)
            txtSearch.startAnimation(fromBtn)
            txtFilter.startAnimation(fromBtn)
            txtRandom.startAnimation(fromBtn)
            btnMenu.setImageResource(R.drawable.ic_close)
        } else {
            btnSearch.startAnimation(toBtn)
            btnFilter.startAnimation(toBtn)
            btnRandom.startAnimation(toBtn)
            txtSearch.startAnimation(toBtn)
            txtFilter.startAnimation(toBtn)
            txtRandom.startAnimation(toBtn)
            btnMenu.setImageResource(R.drawable.ic_menu)
        }
    }

    private fun setClickable(clicked: Boolean) {
        if(!clicked) {
            btnSearch.isClickable = true
            btnFilter.isClickable = true
            btnRandom.isClickable = true
        }else{
            btnSearch.isClickable = false
            btnFilter.isClickable = false
            btnRandom.isClickable = false
        }
    }

}