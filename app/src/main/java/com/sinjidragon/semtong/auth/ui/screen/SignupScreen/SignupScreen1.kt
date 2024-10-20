package com.sinjidragon.semtong.auth.ui.screen.SignupScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sinjidragon.semtong.R
import com.sinjidragon.semtong.auth.ui.view.component.AuthBaseButton
import com.sinjidragon.semtong.auth.ui.view.component.BackButton
import com.sinjidragon.semtong.auth.ui.view.component.PrivacyPolicyText
import com.sinjidragon.semtong.ui.component.BaseTextField
import com.sinjidragon.semtong.ui.theme.gray2
import com.sinjidragon.semtong.ui.theme.innerShadow
import com.sinjidragon.semtong.ui.theme.mainColor
import com.sinjidragon.semtong.ui.theme.pretendard

@Composable
fun SignupScreen1 (){
    var idText by remember { mutableStateOf("") }
    var passwordText by remember { mutableStateOf("") }
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(mainColor)
            .systemBarsPadding()
    ){
        BackButton(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 16.dp),
            onClick = { /*TODO*/ },
            color = Color.White
        )
        Column(
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            Text(
                text = "회원가입",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                fontSize = 16.sp,
                fontFamily = pretendard,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(60.dp))
            Text(
                text = "Sign Up",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                fontSize = 30.sp,
                fontFamily = pretendard,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize(0.8f)
                .clip(
                    RoundedCornerShape(
                        topStart = 70.dp
                    )
                )
                .background(Color.White)
                .align(Alignment.BottomCenter)
                .innerShadow(
                    RoundedCornerShape(
                        topStart = 70.dp
                    )
                )
        ){
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 40.dp)
                    .fillMaxHeight()
            ){
                Text(
                    modifier = Modifier
                        .offset(x = 40.dp),
                    text = "아이디",
                    fontSize = 14.sp,
                    fontFamily = pretendard,
                    fontWeight = FontWeight.Medium,
                    color = gray2
                )
                Spacer(modifier = Modifier.height(4.dp))
                BaseTextField(
                    onTextChange = { idText = it },
                    text = idText,
                    icon = R.drawable.id_icon,
                    placeholder = "아이디를 입해주세요",
                    isButton = true,
                    buttonText = "확인",
                    onClick = { TODO() }
                )
                Spacer(modifier = Modifier.height(22.dp))
                Text(
                    modifier = Modifier
                        .offset(x = 40.dp),
                    text = "비밀번호",
                    fontSize = 14.sp,
                    fontFamily = pretendard,
                    fontWeight = FontWeight.Medium,
                    color = gray2
                )
                Spacer(modifier = Modifier.height(4.dp))
                BaseTextField(
                    onTextChange = { passwordText = it },
                    text = passwordText,
                    placeholder = "비밀번호를 입해주세요",
                    icon = R.drawable.password_icon,
                    isPassword = true,
                    isButton = true
                )
            }
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
                color = mainColor,
                text = "다음",
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
fun SignupScreen1Preview(){
    SignupScreen1()
}