package com.sinjidragon.semtong.auth.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sinjidragon.semtong.R
import com.sinjidragon.semtong.auth.ui.view.component.AuthBaseButton
import com.sinjidragon.semtong.ui.theme.mainColor
import com.sinjidragon.semtong.ui.theme.pretendard

@Composable
fun IntroScreen() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFFCD1DD))
    )
    {
        Image(painter = painterResource(id = R.drawable.hand_card_money_gift_atm), contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .fillMaxWidth(0.6f)
                .aspectRatio(ratio = 1f)
                .rotate(8f)
                .offset(y = 70.dp, x = 20.dp)
        )
        Image(painter = painterResource(id = R.drawable.hand_wallet_coin), contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .fillMaxWidth(0.65f)
                .aspectRatio(ratio = 1f)
                .rotate(-9f)
                .offset(x = -60.dp)
        )
        Image(painter = painterResource(id = R.drawable.wallet_card_coin), contentDescription = null,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .fillMaxWidth(0.65f)
                .aspectRatio(ratio = 1f)
                .rotate(9f)
                .offset(y = -80.dp, x = 40.dp)
        )
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(brush = Brush.verticalGradient(listOf(Color.Transparent, Color.White)))
    ){
        Column (
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 41.dp, y = 91.dp)
        ){
            Text(
                text = "우리 가족을 위한",
                fontFamily = pretendard,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                color = Color.White
            )
            Text(
                text = "셈통",
                fontFamily = pretendard,
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp,
                color = Color.White
            )
        }
        Column (
            Modifier
                .align(Alignment.BottomCenter)
                .offset(y = (-50).dp)
        ){
            AuthBaseButton(
                modifier = Modifier,
                color = mainColor,
                text = "로그인",
                onClick = {TODO()}
            )
            Spacer(modifier = Modifier.height(20.dp))
            AuthBaseButton(
                modifier = Modifier,
                color = Color.White,
                text = "로그인",
                onClick = {TODO()}
            )
        }
    }
}
@Preview
@Composable
fun IntroScreenPreview() {
    IntroScreen()
}