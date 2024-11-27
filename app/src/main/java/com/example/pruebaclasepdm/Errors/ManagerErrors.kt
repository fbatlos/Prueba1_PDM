package com.example.act2_din.componentes_app.componentes_login.Errors

import androidx.compose.runtime.Composable


@Composable
fun ManagerErrors(Error:String){
    when(Error){
        "todo" -> Mensaje_Error("El nombre y \n el nif son campos\nrequeridos.")

        "nombre" -> Mensaje_Error("El Nombre no \n puede estar vacío")

        "nif" -> Mensaje_Error("El nif no es\n correcto o está vacia")
        else -> true
    }
}