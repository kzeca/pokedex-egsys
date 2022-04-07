package com.egsys.pokedex.ui.home.search

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.egsys.pokedex.R
import com.egsys.pokedex.ui.details.DetailsActivity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_bottom_sheet_search.view.*

class BottomSearchFragment(): BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_bottom_sheet_search, container, false)
        var name = view.etSearch
        var btnSearch = view.btnSearchPokemon

        btnSearch.setOnClickListener {
            if(name.text.isNotEmpty()){
                if(name.text.toString().all { it.isLetter() }){
                    startActivity(Intent(requireContext(), DetailsActivity::class.java).putExtra("pokemon", name.text.toString().trim().lowercase()))
                    dismiss()
                }
                else{
                    Toast.makeText(context, "Only accepts letters", Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(requireContext(), "Empty input for search Pokemon name", Toast.LENGTH_LONG).show()
            }
        }

        return view

    }

}