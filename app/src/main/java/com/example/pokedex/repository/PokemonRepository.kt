package com.example.pokedex.repository

import com.example.pokedex.data.remote.PokeApi
import com.example.pokedex.data.remote.responses.detail.Pokemon
import com.example.pokedex.data.remote.responses.list.PokemonList
import com.example.pokedex.util.Resource
import java.lang.Exception
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {
    suspend fun getPokemonList(limit: Int, offset:Int): Resource<PokemonList>{
        val response = try{
            api.getPokemonList(limit, offset)
        } catch (e: Exception){
            return Resource.Error("An unknown error occured")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon>{
        val response = try{
            api.getPokemonInfo(pokemonName)
        } catch (e: Exception){
            return Resource.Error("An unknown error occured")
        }
        return Resource.Success(response)
    }
}