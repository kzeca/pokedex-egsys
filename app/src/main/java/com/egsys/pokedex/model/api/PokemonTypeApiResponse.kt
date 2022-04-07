package com.egsys.pokedex.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Object PokemonTypesResponse: count, next, previous,
 * results
 */
data class PokemonTypesResponse(
    @Expose @SerializedName("count") val count: Int,
    @Expose @SerializedName("next") val next: String,
    @Expose @SerializedName("previous") val previous: String,
    @Expose @SerializedName("results") val results: List<PokemonTypesResult>
)

/**
 * Object PokemonTypesResult: name, url
 */
data class PokemonTypesResult (
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("url") val url: String
)

/**
 * Object PokemonByTypeResponse: id, name, pokemon
 */
data class PokemonByTypeResponse (
    @Expose @SerializedName("id") val id: Int,
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("pokemon") val pokemon: List<PokemonByTypeResult>
)

/**
 * Object PokemonByTypeResult: slot, pokemon
 */
data class PokemonByTypeResult (
    @Expose @SerializedName("slot") val slot: Int,
    @Expose @SerializedName("pokemon") val pokemon: PokemonTypesResult
        )

