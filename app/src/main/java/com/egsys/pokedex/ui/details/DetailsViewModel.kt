package com.egsys.pokedex.ui.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.egsys.pokedex.model.api.Pokemon
import com.egsys.pokedex.model.service.PokemonApiService
import kotlinx.coroutines.flow.flowOf
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.IllegalArgumentException

/**
 * ViewModel da DetailsPage
 */
class DetailsViewModel() : ViewModel() {

    /**
     * Variavel referenciando a biblioteca Retrofit, necessária para fazer as
     * solicitações http para a API
     */
    private val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    /**
     * Variavel referenciando o service da aplicação na camada de Model
     */
    private val service: PokemonApiService = retrofit.create(PokemonApiService::class.java)

    /**
     * Implementação do LiveData
     */
    val pokemonDetails = MutableLiveData<Pokemon>()

    /**
     * Função direcionada para pegar os detalhes de um pokemon especifíco da API
     */
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
