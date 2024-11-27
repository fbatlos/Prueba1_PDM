package com.example.pruebaclasepdm

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
    /*
    Uso nullPonterException por si por algun casual no se llegasé a encontrar nada en el envio
     */
    val personaNotNull:String = PersonaInfo ?: throw NullPointerException("No hay Persona.")

    val usuario = Json.decodeFromString<Persona>(personaNotNull)


    Column (
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text("Bienvenido : ${usuario.nombre} ${usuario.apellido}." , color = Color.Black)

        Text("Se ha registrado correctamente\n con su DNI : ${usuario.nif}" , color = Color.Black)
    }
}