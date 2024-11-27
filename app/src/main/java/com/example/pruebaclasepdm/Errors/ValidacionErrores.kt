package com.example.act2_din.componentes_app.componentes_login.Errors

import com.example.pruebaclasepdm.Utils.Utils


fun ValidacionErrores(nombre:String,nif:String):String{
    var Error = ""
    if (nombre.isEmpty() || nif.isEmpty()) {
        if (nombre.isEmpty() && nif.isEmpty()) {
            Error = "todo"
        } else if (nombre.isEmpty()) {
            Error = "nombre"
        } else {
            Error = "nif"
        }
    } else {
        if (Utils.checkNIF(nif)) {
            // Pop up y el cambio de pantalla
            Error = ""
        }else{
            Error = "nif"
        }
    }
    return Error
}