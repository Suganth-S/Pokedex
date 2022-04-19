package com.example.pokedex.data.remote.responses.detail

data class Ability(
    val ability: AbilityX,
    val is_hidden: Boolean,
    val slot: Int
)