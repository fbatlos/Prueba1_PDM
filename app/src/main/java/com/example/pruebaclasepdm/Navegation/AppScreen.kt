package com.example.pruebaclasepdm.Navegation

sealed class AppScreen (val router:String){

    object InputScreen:AppScreen("inputScreen")

    object ShowInfoScreen:AppScreen("showInfoScreen")

}