package com.sinjidragon.semtong.main.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.sinjidragon.semtong.main.ui.component.AppBar
import com.sinjidragon.semtong.main.ui.component.BottomNav

@Composable
fun ProfileView (navController : NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .systemBarsPadding()
    ){
        AppBar()
        BottomNav(navController = navController)
    }
}