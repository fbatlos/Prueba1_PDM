package com.example.act2_din.componentes_app.componentes_login.Errors

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.pruebaclasepdm.ui.theme.ErrorColor
import com.example.pruebaclasepdm.ui.theme.ErrorLetra


@Composable
fun Mensaje_Error(
    texto:String
){
    Spacer(Modifier.height(15.dp))
    Box(
        modifier = Modifier
            .size(200.dp, 150.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(ErrorColor)
        ,
        contentAlignment = Alignment.Center

    ){
        Text(
            text = texto,
            color = ErrorLetra
        )
    }
    Spacer(Modifier.height(15.dp))
}