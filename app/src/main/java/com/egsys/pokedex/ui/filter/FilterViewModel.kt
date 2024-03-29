package com.egsys.pokedex.ui.filter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.egsys.pokedex.model.api.PokemonTypesResponse
import com.egsys.pokedex.model.api.PokemonTypesResult
import com.egsys.pokedex.model.service.PokemonApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * ViewModel da FilterPage
 */
class FilterViewModel(): ViewModel() {

    /**
     * Variavel referenciando a biblioteca Retrofit, necessária para fazer as
     * solicitações http para a API
     */
    private val retrofit = Retrofit.Builder().baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    /**
     * Variavel referenciando o service da aplicação na camada de Model
     */
    private val service: PokemonApiService = retrofit.create(PokemonApiService::class.java)

    /**
     * Implementação do LiveData
     */
    val typeList = MutableLiveData<List<PokemonTypesResult>>()

    /**
     * Função direcionada para pegar os tipos pokemons da API
     */
    fun getTypesList(){
        val serviceCall = service.getTypes(18, 0)
        serviceCall.enqueue(object: Callback<PokemonTypesResponse>{
            override fun onResponse(
                call: Call<PokemonTypesResponse>,
                response: Response<PokemonTypesResponse>
            ) {
                response.body()?.results.let {
                    list -> typeList.postValue(list)
                }
            }

            override fun onFailure(call: Call<PokemonTypesResponse>, t: Throwable) {
                call.cancel()
            }

        })
    }
}