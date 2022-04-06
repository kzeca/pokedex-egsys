package com.egsys.pokedex.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.egsys.pokedex.model.api.PokemonApiResponse
import com.egsys.pokedex.model.api.PokemonResult
import com.egsys.pokedex.service.PokemonApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeViewModel(): ViewModel() {
    private val retrofit = Retrofit.Builder().baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service: PokemonApiService = retrofit.create(PokemonApiService::class.java)

    val pokemonList = MutableLiveData<List<PokemonResult>>()

    fun getPokemonList() {
        val serviceCall = service.getPokemonsList(1000, 0)
        serviceCall.enqueue(object: Callback<PokemonApiResponse>{
            override fun onResponse(
                call: Call<PokemonApiResponse>,
                response: Response<PokemonApiResponse>
            ) {
                response.body()?.results?.let{
                    list ->  pokemonList.postValue(list)
                }
            }

            override fun onFailure(call: Call<PokemonApiResponse>, t: Throwable) {
                call.cancel()
            }

        })
    }

}