package com.example.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.pokedex.ui.theme.PokedexTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                /**
                 * All we want to do here in Mainactivity is ,setting up navigation, we want to have navhost
                 * In xml , we defina a navGraph, navHost , navfragment and all, but all we need here is
                 * just define navHost once, and every single screen of our app will be composable
                 *
                 * rememberNavcontroller => will give instance of navController and with that we can later then perform actual
                 *                          navigation
                 * startDestination => In xml, we give ids,but here we give string of a screen name
                 * composable() => a normal function, with that we define our single screen in our app
                 *
                 * Note: We cannot pass those args as function instead what we ned to do is, we need to treat these route similar to a url,
                 *       so also give thisute just path parameters, just as a url,using a slash
                  */
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "pokemon_list_screen"
                ){
                    composable("pokemon_list_screen"){

                    }
                    composable(
                        "pokemon_detail_screen/{dominantColor}/{pokemonName}",
                        arguments = listOf(
                            navArgument("dominantColor"){
                                //define the type of dominantColor
                                type = NavType.IntType
                            },
                            navArgument("pokemonName"){
                                type = NavType.StringType
                            }
                        )
                    ){
                        val dominantColor = remember {
                            val color = it.arguments?.getInt("dominantColor")
                            color?.let { Color(it) } ?: Color.White
                        }

                        val pokemonName = remember {
                            it.arguments?.getString("pokemonName") }
                        }

                    }
                }
            }
        }
    }

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PokedexTheme {
        Greeting("Android")
    }
}