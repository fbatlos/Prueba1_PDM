package com.example.pruebaclasepdm.Model

import kotlinx.serialization.Serializable
import java.time.LocalDateTime


@Serializable
data class Persona(var nombre:String ,var nif:String, var apellido:String)
