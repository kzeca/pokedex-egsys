package com.egsys.pokedex.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Object PokemonApiResponse: count, next, previous e
 * results
 */
data class PokemonApiResponse(
    @Expose @SerializedName("count") val count: Int,
    @Expose @SerializedName("next") val next: String,
    @Expose @SerializedName("previous") val previous: String,
    @Expose @SerializedName("results") val results: List<PokemonResult>
)

/**
 * Object PokemonResult: name, url
 */
data class PokemonResult (
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("url") val url: String
)