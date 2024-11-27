package com.example.pruebaclasepdm.Utils

object Utils {
    fun checkNIF(nif:String): Boolean {
        if (nif.length != 9) return false
        val letras = "TRWAGMYFPDXBNJZSQVHLCKE"
        val numero = nif.substring(0, 8).toInt()
        val letra = nif.last()
        val letraCalculada = letras[numero % 23]
        if(letra == letraCalculada){return true}else{return false}
    }
}