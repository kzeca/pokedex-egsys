package com.egsys.pokedex.ui.filter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.egsys.pokedex.R
import com.egsys.pokedex.ui.filter.type.FilterTypeActivity
import kotlinx.android.synthetic.main.activity_filter.*

/**
 * View da FilterPage
 */
class FilterActivity : AppCompatActivity() {

    /**
     * Correlaciona a View Model da FilterPage
     */
    private lateinit var viewModel: FilterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)
        viewModel = ViewModelProvider(this).get(FilterViewModel::class.java)
        initUI()
    }

    /**
     * Iniciar UI
     */
    private fun initUI() {
        rvTypeList.layoutManager = LinearLayoutManager(this)
        rvTypeList.adapter = TypesListAdapter{
            val i = Intent(this, FilterTypeActivity::class.java)
            i.putExtra("type", it)
            startActivity(i)
        }
        setViewModel()

        btnBack.setOnClickListener {
            finish()
        }

    }

    /**
     * Função que configura o ViewModel com o observer
     */
    private fun setViewModel() {
        viewModel.getTypesList()
        viewModel.typeList.observe(this, Observer {
                list -> (rvTypeList.adapter as TypesListAdapter).setData(list)
        })
    }
}