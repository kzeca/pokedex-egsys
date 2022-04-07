package com.egsys.pokedex.ui.filter.type

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.egsys.pokedex.model.api.PokemonByTypeResponse
import com.egsys.pokedex.model.api.PokemonByTypeResult
import com.egsys.pokedex.model.service.PokemonApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FilterTypeViewModel(): ViewModel() {
    private val retrofit = Retrofit.Builder().baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val service: PokemonApiService = retrofit.create(PokemonApiService::class.java)

    val filteredPokemonList = MutableLiveData<List<PokemonByTypeResult>>()

    fun getFilteredPokemonList(type: Any) {

        val serviceCall = service.getByType(type)
        serviceCall.enqueue(object: Callback<PokemonByTypeResponse>{
            override fun onResponse(
                call: Call<PokemonByTypeResponse>,
                response: Response<PokemonByTypeResponse>
            ) {
                response.body()?.pokemon?.let {
                    list -> filteredPokemonList.postValue(list)
                }
            }

            override fun onFailure(call: Call<PokemonByTypeResponse>, t: Throwable) {
                call.cancel()
            }

        })
    }

}
