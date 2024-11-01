package com.sinjidragon.semtong.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sinjidragon.semtong.R
import com.sinjidragon.semtong.auth.network.api.refresh
import com.sinjidragon.semtong.auth.network.user.getRefToken
import com.sinjidragon.semtong.auth.network.user.getRole
import com.sinjidragon.semtong.nav.NavGroup
import com.sinjidragon.semtong.ui.theme.mainColor
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashView (navController: NavController){
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(Unit)  {
        delay(1500L)
        val refToken = getRefToken(context)
        if (refToken != null ){
            coroutineScope.launch {
                val response = refresh(context = context)
                if (response == "success"){
                    val role = getRole(context)
                    if (role == null){
                        navController.navigate(NavGroup.GROUP)
                    }
                    else{
                        navController.navigate(NavGroup.HOME)
                    }
                }
                else {
                    val showAlert = true
                    navController.navigate("${NavGroup.LOGIN}/$showAlert")
                }
            }
        }
        else{
            navController.navigate(NavGroup.FIRST)
        }
    }

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
    SplashView(navController = NavController(context = LocalContext.current))
}
