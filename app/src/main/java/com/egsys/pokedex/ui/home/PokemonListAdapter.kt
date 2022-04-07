package com.egsys.pokedex.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.egsys.pokedex.R
import com.egsys.pokedex.model.api.PokemonResult
import kotlinx.android.synthetic.main.card_pokemon.view.*

/**
 * ListAdapter do RecyclerView da HomePage, onde está a lista com todos os pokemons.
 */
class PokemonListAdapter (val pokemon: (Int) -> Unit): RecyclerView.Adapter<PokemonListAdapter.SearchViewHolder>() {


    class SearchViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)


    var pokemonList: List<PokemonResult> = emptyList()

    fun setData(list: List<PokemonResult>){
        pokemonList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_pokemon, parent,false))
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        holder.itemView.txtPokeId.text = "#${position + 1}"
        holder.itemView.txtPokemonName.text = "${pokemon.name.trim().capitalize()}"
        holder.itemView.setOnClickListener {
            this.pokemon(position+1)
        }
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

}