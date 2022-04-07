package com.egsys.pokedex.ui.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.egsys.pokedex.R
import com.egsys.pokedex.model.api.Types
import kotlinx.android.synthetic.main.activity_details.*

/**
 * View da DetailsPage
 */
class DetailsActivity : AppCompatActivity() {

    /**
     * Declara a ViewModel da DetailsPage
     */
    lateinit var viewModel: DetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)
        initUi()
    }

    /**
     * Iniciar a UI da DetailsPage
     */
    private fun initUi() {
        val poke = intent.extras?.get("pokemon")

        // obter informação
        if (poke != null) {
            viewModel.getPokemonDetails(poke)
        }

        // realtime change table
        viewModel.pokemonDetails.observe(this, Observer { pokemon ->
            txtId.text = "#"+pokemon.id
            txtName.text = pokemon.name.capitalize()
            txtTypes.text = "Types(s): "+getTypes(pokemon.types)
            txtHeight.text = "Height: ${pokemon.height/10.0}m"
            txtWeight.text = "Weight: ${pokemon.weight/10.0}kg"
            Glide.with(this).load(pokemon.sprites.frontDefault).into(imgPokemonAvatar)
        })

        setButtons()
    }

    /**
     * Contem todos os ButtonsListeners
     */
    private fun setButtons() {
        btnBack.setOnClickListener {
            finish()
        }
    }

    /**
     * Função que separa os tipos do pokemon
     * @param typesList
     * @return pokemonTypes
     */
    private fun getTypes(typesList: List<Types>): String {
        var pokemonTypes = ""
        for (t in typesList){
            pokemonTypes +=
                if (t.type.name.equals(typesList.last().type.name)) t.type.name?.capitalize()+"." else t.type.name?.capitalize()+", "
        }
        return pokemonTypes
    }


}