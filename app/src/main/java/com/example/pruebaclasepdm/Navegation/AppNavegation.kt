package com.example.pruebaclasepdm.Navegation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pruebaclasepdm.InputScreen
import com.example.pruebaclasepdm.ShowInfoScreen

@SuppressLint("RestrictedApi")
@Composable
fun AppNavegation(modifier: Modifier ){
    val navContralador = rememberNavController()
//Es el encargado de iniciar cada composable segun la route
    NavHost(
        navController = navContralador,
        startDestination = AppScreen.InputScreen.router
    ){
        composable(AppScreen.InputScreen.router){
            InputScreen(modifier,navContralador)
        }

       composable(AppScreen.ShowInfoScreen.router+ "/{text}" , arguments = listOf(navArgument(name = "text"){
            type = NavType.StringType
        }))
        {
            ShowInfoScreen(PersonaInfo = it?.arguments?.getString("text") , onBack = {navContralador.popBackStack()} , modifier = modifier)
        }
    }
}

