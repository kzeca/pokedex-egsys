package com.egsys.pokedex.ui.filter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.egsys.pokedex.R
import com.egsys.pokedex.model.api.PokemonTypesResult
import kotlinx.android.synthetic.main.card_type.view.*

class TypesListAdapter (val type: (Int) -> Unit): RecyclerView.Adapter<TypesListAdapter.SearchViewHolder>(){

    class SearchViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    var typeList: List<PokemonTypesResult> = emptyList()

    fun setData(list: List<PokemonTypesResult>){
        typeList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_type, parent, false))
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val type = typeList[position]
        holder.itemView.txtTypeName.text = "${type.name.trim().capitalize()}"
        holder.itemView.setOnClickListener{
            this.type(position+1)
        }
    }

    override fun getItemCount(): Int {
        return typeList.size
    }

}