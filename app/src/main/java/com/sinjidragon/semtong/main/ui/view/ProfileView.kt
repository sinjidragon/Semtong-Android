package com.sinjidragon.semtong.main.ui.view

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sinjidragon.semtong.R
import com.sinjidragon.semtong.auth.network.user.getUserId
import com.sinjidragon.semtong.auth.network.user.saveAccToken
import com.sinjidragon.semtong.auth.network.user.saveRefToken
import com.sinjidragon.semtong.auth.network.user.saveRole
import com.sinjidragon.semtong.auth.network.user.saveUserId
import com.sinjidragon.semtong.main.ui.component.AppBar
import com.sinjidragon.semtong.main.ui.component.BottomNav
import com.sinjidragon.semtong.main.ui.component.EnterBar
import com.sinjidragon.semtong.nav.NavGroup
import com.sinjidragon.semtong.ui.theme.gray2
import com.sinjidragon.semtong.ui.theme.pretendard
import com.sinjidragon.semtong.ui.theme.subColor
import com.sinjidragon.semtong.ui.theme.subColor2

@Composable
fun ProfileView (navController : NavController){
    val context = LocalContext.current
    val userId = getUserId(context)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .systemBarsPadding()
    ){
        Box(
            modifier = Modifier
                .offset(y = 60.dp)
                .fillMaxWidth()
                .height(122.dp)
                .clip(RoundedCornerShape(bottomStart = 8.dp, topStart = 8.dp))
                .background(subColor2),
        )
        Image(
            modifier = Modifier
                .size(140.dp)
                .align(Alignment.TopCenter)
                .offset(y = 112.dp),
            painter = painterResource(id = R.drawable.logo_face_circle),
            contentDescription = ""
        )
        if (userId != null) {
            Text(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .offset(y = 267.dp),
                text = userId,
                fontFamily = pretendard,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
            )
        }
        Column (
            modifier = Modifier
                .offset(y = 327.dp)
        ){
            EnterBar(
                text = "개인정보 이용 약관",
                isFullClickable = true,
                isEnterButton = true,
                enterButtonColor = gray2,
                onClick = {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://semtong1.notion.site/1265ad66b02780cc9f9dc41dd8d4f974?pvs=4"))
                    context.startActivity(intent)
                }
            )
            EnterBar(
                text = "그룹 설정",
                isFullClickable = true,
                isEnterButton = true,
                enterButtonColor = gray2,
                onClick = {TODO("그룹설정창 이동")}
            )
            EnterBar(
                text = "로그아웃",
                isFullClickable = true,
                isEnterButton = true,
                enterButtonColor = gray2,
                onClick = {
                    saveAccToken(context = context, token = null)
                    saveRefToken(context = context, token = null)
                    saveRole(context = context, role = null)
                    saveUserId(context = context, id = null)
                    navController.navigate(NavGroup.FIRST)
                }
            )
            EnterBar(
                text = "회원탈퇴",
                isFullClickable = true,
                isEnterButton = true,
                enterButtonColor = subColor,
                textColor = subColor,
                onClick = {
                    TODO("api 안나옴")
                }
            )
        }

        AppBar()
        BottomNav(navController = navController)
    }
}
@Preview
@Composable
fun ProfileViewPreview(){
    ProfileView(navController = NavController(context = LocalContext.current))
}