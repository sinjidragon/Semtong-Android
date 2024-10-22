package com.sinjidragon.semtong.auth.ui.screen.GroupScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sinjidragon.semtong.auth.ui.view.component.AuthBaseButton
import com.sinjidragon.semtong.auth.ui.view.component.BackButton
import com.sinjidragon.semtong.auth.ui.view.component.CodeTextField
import com.sinjidragon.semtong.auth.ui.view.component.PrivacyPolicyText
import com.sinjidragon.semtong.nav.NavGroup
import com.sinjidragon.semtong.ui.theme.gray2
import com.sinjidragon.semtong.ui.theme.mainColor
import com.sinjidragon.semtong.ui.theme.pretendard
import com.sinjidragon.semtong.ui.theme.subColor2

@Composable
fun GroupView (navController : NavController){
    var code by remember { mutableStateOf(List(6) { "" }) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
    ){
        BackButton(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 16.dp),
            onClick = {navController.navigate(NavGroup.FIRST)},
            color = Color.Black
        )
        Text(
            text = "회원가입",
            modifier = Modifier
                .align(Alignment.TopCenter),
            fontSize = 16.sp,
            fontFamily = pretendard,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )
        Column (
            modifier = Modifier
                .padding(top = 57.dp),
        ){
            Text(
                modifier = Modifier
                    .padding(start = 40.dp),
                text = "그룹코드",
                fontFamily = pretendard,
                fontWeight = FontWeight.Medium,
                color = gray2,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            CodeTextField(
                code = code,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                onCodeChange = {
                    code = it
                }
            )
            Spacer(modifier = Modifier.height(28.dp))
            AuthBaseButton(
                color = Color.White,
                text = "그룹 참여하기",
                isEnterButton = true,
                modifier = Modifier
            )
        }
        Column (
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(y = (-65).dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            PrivacyPolicyText(
                modifier = Modifier
            )
            Spacer(modifier = Modifier.height(9.dp))
            AuthBaseButton(
                color = subColor2,
                text = "그룹 생성하기",
                isEnterButton = true,
                modifier = Modifier
            )
        }
    }
}
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GroupViewPreview() {
    GroupView(navController = NavController(context = LocalContext.current))
}