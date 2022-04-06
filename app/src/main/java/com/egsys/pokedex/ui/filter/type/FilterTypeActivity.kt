package com.egsys.pokedex.ui.filter.type

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.egsys.pokedex.R
import com.egsys.pokedex.ui.details.DetailsActivity
import kotlinx.android.synthetic.main.activity_filter_type.*

class FilterTypeActivity : AppCompatActivity() {

    private lateinit var viewModel: FilterTypeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter_type)
        viewModel = ViewModelProvider(this).get(FilterTypeViewModel::class.java)

        initUi()
    }

    private fun initUi() {
        rvPokemonTypeList.layoutManager = LinearLayoutManager(this)
        rvPokemonTypeList.adapter = FilterTypeListAdapter {
            val i = Intent(this, DetailsActivity::class.java)
            i.putExtra("pokemon", it)
            startActivity(i)
        }
        setViewModel()

        btnBack.setOnClickListener {
            finish()
        }
    }

    private fun setViewModel() {
        val type = intent.extras?.get("type")

        if (type != null) {
            viewModel.getFilteredPokemonList(type)
        }

        viewModel.filteredPokemonList.observe(this, Observer { list ->
            (rvPokemonTypeList.adapter as FilterTypeListAdapter).setData(list)
        })
    }
}