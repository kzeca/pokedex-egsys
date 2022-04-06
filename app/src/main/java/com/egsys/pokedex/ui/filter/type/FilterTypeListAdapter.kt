package com.egsys.pokedex.ui.filter.type

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.egsys.pokedex.R
import com.egsys.pokedex.model.api.PokemonByTypeResult
import kotlinx.android.synthetic.main.card_pokemon.view.*

class FilterTypeListAdapter (val pokemon: (String) -> Unit): RecyclerView.Adapter<FilterTypeListAdapter.SearchViewHolder>() {

    class SearchViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    var filteredPokemonList: List<PokemonByTypeResult> = emptyList()

    fun setData(list: List<PokemonByTypeResult>){
        filteredPokemonList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_pokemon, parent, false))
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val pokemon = filteredPokemonList[position]

        holder.itemView.txtPokeId?.text = "#${position + 1}"
        holder.itemView.txtPokemonName.text = "${pokemon.pokemon.name.capitalize()}"
        holder.itemView.setOnClickListener {
            this.pokemon(pokemon.pokemon.name)
        }
    }

    override fun getItemCount(): Int {
        return filteredPokemonList.size
    }


}