package com.sinjidragon.semtong.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sinjidragon.semtong.R
import com.sinjidragon.semtong.ui.theme.mainColor

@Composable
fun SplashView (){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(mainColor)
    ){
        Image(
            modifier = Modifier
                .size(257.dp)
                .align(Alignment.Center)
                .offset(y = (-50).dp),
            painter = painterResource(id = R.drawable.semtong_logo_white),
            contentDescription = "logo"
        )
    }
}
@Preview
@Composable
fun SplashViewPreview(){
    SplashView()
}
