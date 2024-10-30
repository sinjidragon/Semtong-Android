package com.sinjidragon.semtong.main.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.sinjidragon.semtong.main.ui.component.AppBar
import com.sinjidragon.semtong.main.ui.component.BottomNav

@Composable
fun HomeView (navController : NavController ){
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
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun HomeViewPreview(){
    HomeView(navController = NavController(context = LocalContext.current))
}