package com.example.pruebaclasepdm

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.pruebaclasepdm.Model.Persona
import kotlinx.serialization.json.Json

@Composable
fun ShowInfoScreen(modifier: Modifier, PersonaInfo:String? , onBack:()->Unit){

    val personaNotNull:String = PersonaInfo ?: throw NullPointerException("No hay Persona.")

    val usuario = Json.decodeFromString<Persona>(personaNotNull)

    Box (
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
        ,
        contentAlignment = Alignment.Center
    ){
        Text("Bienvenido : ${usuario.nombre} ${usuario.apellido} .\nSe ha registrado correctamente\ncon su DNI : ${usuario.nif}" , color = Color.Black)
    }



}