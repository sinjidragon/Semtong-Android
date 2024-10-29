package com.sinjidragon.semtong.main.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sinjidragon.semtong.R
import com.sinjidragon.semtong.ui.theme.dropShadow

@Composable
fun AppBar (){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(60.dp)
        .dropShadow()
        .background(Color.White),
        contentAlignment = Alignment.TopCenter
    ){
        Image(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .size(130.dp)
                .padding(start = 16.dp),
            painter = painterResource(id = R.drawable.semtong_logo),
            contentDescription = "logo"
        )
    }
}
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun AppBarPreview(){
    AppBar()
}