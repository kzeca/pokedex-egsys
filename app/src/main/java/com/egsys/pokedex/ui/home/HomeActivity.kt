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
import com.egsys.pokedex.ui.home.search.SearchFragment
import kotlinx.android.synthetic.main.activity_home.*

/**
 * View da HomePage
 */
class HomeActivity : AppCompatActivity() {

    /**
     * Referencia da animação personalizada que surge do botão. Do botão para cima
     */
    private val fromBtn: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.from_button)}

    /**
     * Referencia da animação personalizada que vai ao botão. De cima ao botão
     */
    private val toBtn: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.to_button)}

    /**
     * Valor booleano usado para indicar se o FlatButton teve sua ação de clique
     * ou não
     */
    private var clicked = false

    /**
     * Referenciando o View Model da HomeActivity(View)
     */
    private lateinit var viewModel: HomeViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        initUI()
    }

    /**
     * Função direcionada para montar view, chamando o
     * PokemonListAdapter para formar o *RecyclerView*
     */
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

    /**
     * View Model settando o ViewModel, onde é chamado *getPokemonList()* para
     * dispor todos os pokemons gerados pela API, enquanto o observer serve para, caso
     * a lista sofra qualquer tipo de alteração o RecyclerView seja devidamente atualizado
     */
    private fun setViewModel() {
        viewModel.getPokemonList()
        viewModel.pokemonList.observe(this, Observer {
                list -> (rvPokemonList.adapter as PokemonListAdapter).setData(list)
        })

    }


    /**
     * Função que verifica se algum botão dessa activity foi acionado
     */
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

    /**
     * Função acionada toda vez que o FloatActionButton da opção de selecionar
     * randomicamente pokemons é acionada. Aqui, é selecionada a Intent para
     * DetailsActivity que leva de em um putExtra um número randômico de 1 a 200
     * que vai ser o id referenciando o pokemon randomicamente escolhido
     */
    private fun randomPokemonChoose() {

        val i = Intent(this, DetailsActivity::class.java)
        i.putExtra("pokemon", (0..201).random())
        startActivity(i)
    }

    /**
     * Função acionada toda vez que o FloatActionButton da opção de filtrar por
     * tipo ativado. Aqui, uma Intent chama o FilterActivity
     */
    private fun filterActivity() {
        val i = Intent(this, FilterActivity::class.java)
        startActivity(i)
    }

    /**
     * Função acionada toda vez que o FloatActionButton da opção
     * de fazer uma pesquisa de pokemons é ativado. Aqui, bottomSearchFragment
     * é aberto.
     */
    private fun searchDialog() {
        val bottomSearchFragment = SearchFragment()
        bottomSearchFragment.show(supportFragmentManager, "bottomSearchFragment")
    }


    /**
     * Função direcionada para abrir o menu com os FloatActionButtons da HomePage
     */
    private fun onMenuButtonClicked() {
        setVisibility(clicked)
        setAnimation(clicked)
        setClickable(clicked)
        clicked = !clicked
    }

    /**
     * Verifica se deve deixar visivel ou invisivel os botões do menu
     */
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

    /**
     * Verifica se deve usar a animação de fromBtn ou toBtn
     */
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

    /**
     * Verifica se deve deixar os botões de menu clicaveis ou não
     */
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