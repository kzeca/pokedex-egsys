package com.egsys.pokedex.ui.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.egsys.pokedex.model.api.Pokemon
import com.egsys.pokedex.service.PokemonApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailsViewModel(): ViewModel() {

    private val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val service: PokemonApiService = retrofit.create(PokemonApiService::class.java)

    val pokemonDetails = MutableLiveData<Pokemon>()

    fun getPokemonDetails(id: Any){
        val serviceCall = service.getPokemonDetails(id)
        serviceCall.enqueue(object: Callback<Pokemon>{
            override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
                response.body()?.let { pokemon -> pokemonDetails.postValue(pokemon) }
            }

            override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                serviceCall.cancel()
            }

        })
    }

}