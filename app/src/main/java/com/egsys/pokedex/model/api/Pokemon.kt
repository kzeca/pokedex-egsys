package com.egsys.pokedex.model.api


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Pokemon(
    @Expose @SerializedName("id") val id: Int,
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("weight") val weight: Float,
    @Expose @SerializedName("height") val height: Float,
    @Expose @SerializedName("sprites") val sprites: Sprites,
    @Expose @SerializedName("types") val types: List<Types>
)

data class Sprites (
    @Expose @SerializedName("front_default") val frontDefault: String?,
    @Expose @SerializedName("front_shiny") val frontShiny:  String?
)

data class Types (
    @Expose @SerializedName("slot") val slot: Int,
    @Expose @SerializedName("type") val type: Type
)

data class Type (
    @Expose @SerializedName("name") val name: String?,
    @Expose @SerializedName("url") val url: String?
)