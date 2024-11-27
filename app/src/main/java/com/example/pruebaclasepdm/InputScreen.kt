package com.example.pruebaclasepdm

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.act2_din.componentes_app.componentes_login.Errors.ManagerErrors
import com.example.act2_din.componentes_app.componentes_login.Errors.ValidacionErrores
import com.example.pruebaclasepdm.Model.Persona
import com.example.pruebaclasepdm.Navegation.AppScreen
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


@Composable
fun InputScreen(modifier: Modifier , navController: NavController){

    Column (
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        //Usamos el rememberSaveable para guardar la variable si hay un cambo de orientacion o escena.
        var nombre by rememberSaveable  { mutableStateOf("") }

        var apellido by rememberSaveable  { mutableStateOf("") }

        var nif by rememberSaveable  { mutableStateOf("") }

        var Error by rememberSaveable  { mutableStateOf("") }

        //Aquí no comprobamos el apellido ya que no quiero que sea un campo obligatorio
        ManagerErrors(Error)

        InputNombre(
            nombre = nombre,
            onCambio = {nombre = it}
        )

        Spacer(Modifier.height(15.dp))

        InputApellido(
            apellido = apellido,
            onCambio = {apellido = it}
        )

        Spacer(Modifier.height(15.dp))

        InputNif(
            nif = nif,
            onCambio = {nif = it}
        )

        Spacer(Modifier.height(15.dp))

        Error = ValidacionErrores(nombre,nif)

        BotonMandaInfo(
            nombre,
            nif,
            apellido,
            navController,
            enable = if (Error == ""){true}else{false}
        )

    }
}



//EL OpIn Es debido a que el outlinesTextFieldColors esta en fase experimental y se usa para que el Android lo deje pasar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputNombre(nombre:String , onCambio:(String) -> Unit){
    /*
    Elevo el estado onCambio que cambiara la variable nif cada vez que está sea alterada.

    He usado el outlinedTextField porque a mi gusto visualmente es mejor que el TextField normal.
 */
    OutlinedTextField(
        value = nombre,
        onValueChange = onCambio,
        label = {
            Text(
                text = "Usuario"
            )},
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = Color.Gray,
            cursorColor = Color.Black,
            focusedLabelColor = Color.Black,
            unfocusedLabelColor = Color.Gray,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Gray
        ),
        modifier = Modifier
            .size(200.dp, 60.dp)
    )
}

//EL OpIn Es debido a que el outlinesTextFieldColors esta en fase experimental y se usa para que el Android lo deje pasar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputNif(nif:String , onCambio:(String) -> Unit){
/*
    Elevo el estado onCambio que cambiara la variable nif cada vez que está sea alterada.

    He usado el outlinedTextField porque a mi gusto visualmente es mejor que el TextField normal.
 */
    OutlinedTextField(
        value = nif,
        onValueChange = onCambio,
        label = {
            Text(
                text = "Nif"
            )},
        //Un simple cambio de color para cuando tiene el foco puesto o no
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = Color.Gray,
            cursorColor = Color.Black,
            focusedLabelColor = Color.Black,
            unfocusedLabelColor = Color.Gray,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Gray
        ),
        modifier = Modifier
            .size(200.dp, 60.dp)
    )
}

//EL OpIn Es debido a que el outlinesTextFieldColors esta en fase experimental y se usa para que el Android lo deje pasar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputApellido(apellido:String , onCambio:(String) -> Unit){
    /*
        Elevo el estado onCambio que cambiara la variable nif cada vez que está sea alterada.

        He usado el outlinedTextField porque a mi gusto visualmente es mejor que el TextField normal.
     */
    OutlinedTextField(
        value = apellido,
        onValueChange = onCambio,
        label = {
            Text(
                text = "Apellido"
            )},
        //Un simple cambio de color para cuando tiene el foco puesto o no
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = Color.Gray,
            cursorColor = Color.Black,
            focusedLabelColor = Color.Black,
            unfocusedLabelColor = Color.Gray,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Gray
        ),
        modifier = Modifier
            .size(200.dp, 60.dp)
    )
}

@Composable
fun BotonMandaInfo(nombre: String, nif: String, apellido: String,navController: NavController , enable :Boolean){

    /*
    Tipico boton con su onclick el cual realizará una acción tras ser pulsado.
     */

    Button(
        onClick = {
            val usuario = Persona(nombre,nif,apellido)
            /*
              He usado este recurso ya que lo manejo mejor y en mi opinion es mas simple por :
              1º Tras pasarlo en json viaja junto a la route
              2º En el propio navegateApp puede administrar esa llegada en formato string
              3º Una vez administrada se la pasamos a la propia funcioncomposable donde hemos ido con la route
              y lo vuelvo a descomprimir para obtener la clase del propio json antes enviado

             */
            navController.navigate(AppScreen.ShowInfoScreen.router + "/${Json.encodeToString(usuario)}")
        },
        //Un simple cambio de color para cuando tiene el foco puesto o no
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Black,
            contentColor = Color.Gray,
            disabledContainerColor = Color.Gray
        ),
        enabled = enable


    ) {
        Text("Mandar info")
    }

}