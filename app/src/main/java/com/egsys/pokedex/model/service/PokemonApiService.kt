package com.egsys.pokedex.model.service

import com.egsys.pokedex.model.api.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApiService {
    @GET("pokemon")
    fun getPokemonsList(@Query("limit") limit: Int, @Query("offset") offset: Int): Call<PokemonApiResponse>
    @GET("pokemon/{id}")
    fun getPokemonDetails(@Path("id") id: Any): Call<Pokemon>
    @GET("type")
    fun getTypes(@Query("limit") limit: Int, @Query("offset") offset: Int): Call<PokemonTypesResponse>
    @GET("type/{type}")
    fun getByType(@Path("type") type: Any): Call<PokemonByTypeResponse>
}