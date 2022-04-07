package com.egsys.pokedex.model.service

import com.egsys.pokedex.model.api.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApiService {
    /**
     * Coleta uma lista de pokemons, com limit e offset
     */
    @GET("pokemon")
    fun getPokemonsList(@Query("limit") limit: Int, @Query("offset") offset: Int): Call<PokemonApiResponse>
    /**
     * Coleta os detalhes de um pokemon levando um id
     */
    @GET("pokemon/{id}")
    fun getPokemonDetails(@Path("id") id: Any): Call<Pokemon>
    /**
     * Coleta os tipos existentes de pokemons
     */
    @GET("type")
    fun getTypes(@Query("limit") limit: Int, @Query("offset") offset: Int): Call<PokemonTypesResponse>
    /**
     * Coleta os pokemons por tipo
     */
    @GET("type/{type}")
    fun getByType(@Path("type") type: Any): Call<PokemonByTypeResponse>
}