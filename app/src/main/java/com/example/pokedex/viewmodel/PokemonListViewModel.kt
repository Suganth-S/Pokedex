package com.example.pokedex.viewmodel

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.palette.graphics.Palette
import com.example.pokedex.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel()
{

    /**
     * we need to tranform drawable to bitmap, becoz palette api takes bitmap,
     * the image fm api are kind of in a format that doesn't work with palette api
     * so we actually need to first make this bitmap mutable and convert it to kind of bitmap config
     * that works with palette library
     * The below function gives result for that colo rto be actually recompse our composable and change the color once loaded
     */
    fun calcDominantColor(drawable: Drawable, onFinish: (Color) -> Unit){
        val bmp = (drawable as BitmapDrawable).bitmap.copy(Bitmap.Config.ARGB_8888, true)

        Palette.from(bmp).generate{
            palette -> palette?.dominantSwatch?.rgb?.let {colorValue ->
                onFinish(Color(colorValue))
        }
        }
    }
}