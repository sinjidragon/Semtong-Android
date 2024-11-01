package com.sinjidragon.semtong.auth.ui.view.signupView

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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sinjidragon.semtong.R
import com.sinjidragon.semtong.auth.network.api.sendMail
import com.sinjidragon.semtong.auth.network.api.signup
import com.sinjidragon.semtong.auth.network.api.verify
import com.sinjidragon.semtong.auth.ui.component.AuthBaseButton
import com.sinjidragon.semtong.auth.ui.component.BackButton
import com.sinjidragon.semtong.auth.ui.component.CodeTextField
import com.sinjidragon.semtong.auth.ui.component.PrivacyPolicyText
import com.sinjidragon.semtong.nav.NavGroup
import com.sinjidragon.semtong.ui.component.BaseTextField
import com.sinjidragon.semtong.ui.theme.errorTextColor
import com.sinjidragon.semtong.ui.theme.gray2
import com.sinjidragon.semtong.ui.theme.innerShadow
import com.sinjidragon.semtong.ui.theme.mainColor
import com.sinjidragon.semtong.ui.theme.pretendard
import kotlinx.coroutines.launch

@Composable
fun GetEmailView(navController : NavController, idText : String, passwordText : String){
    var emailText by remember { mutableStateOf("") }
    var code by remember { mutableStateOf(List(6) { "" }) }
    val coroutineScope = rememberCoroutineScope()
    var resultText by remember { mutableStateOf("") }
    var resultTextColor by remember { mutableStateOf(gray2) }
    var isVerifySend by remember { mutableStateOf(false) }

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
            onClick = {navController.navigate(NavGroup.SIGNUP_ID_PASSWORD)},
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
                    text = "이메일",
                    fontSize = 14.sp,
                    fontFamily = pretendard,
                    fontWeight = FontWeight.Medium,
                    color = resultTextColor
                )
                Spacer(modifier = Modifier.height(4.dp))
                BaseTextField(
                    onTextChange = {
                        emailText = it
                        resultText = ""
                                   },
                    text = emailText,
                    icon = R.drawable.email_icon,
                    placeholder = "이메일을 입력해주세요",
                    isButton = true,
                    buttonText = "인증",
                    onClick = {
                        coroutineScope.launch {
                            val response = sendMail(emailText)
                            if (response == "success"){
                                resultText = "• 인증번호가 전송되었습니다."
                                resultTextColor = gray2
                                isVerifySend = true
                            }
                            else {
                                resultText = "• $response"
                                resultTextColor = errorTextColor
                            }
                        }
                    }
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    modifier = Modifier
                        .padding(start = 40.dp),
                    text = resultText,
                    fontFamily = pretendard,//●
                    fontWeight = FontWeight.Medium,
                    color = resultTextColor,
                    fontSize = 10.sp
                )
                Spacer(modifier = Modifier.height(22.dp))
                Text(
                    modifier = Modifier
                        .offset(x = 40.dp),
                    text = "인증번호",
                    fontSize = 14.sp,
                    fontFamily = pretendard,
                    fontWeight = FontWeight.Medium,
                    color = gray2
                )
                Spacer(modifier = Modifier.height(4.dp))
                CodeTextField(
                    code = code,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    onCodeChange = {
                        code = it
                        resultText = ""
                    }
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
                modifier = Modifier,
                onClick = {
                    if (isVerifySend){
                    val codeString = code.joinToString("")
                    coroutineScope.launch {
                        val verifyResponse = verify(email = emailText, code = codeString)
                        if (verifyResponse == "success") {
                            val signupResponse = signup(username = idText, password = passwordText, email = emailText)
                            if (signupResponse == "success") {
                                val showAlert = false
                                navController.navigate("${NavGroup.LOGIN}/$showAlert")
                            }
                            else {
                                resultText = " $signupResponse"
                                resultTextColor = errorTextColor
                            }
                        } else {
                            resultText = "• $verifyResponse"
                            resultTextColor = errorTextColor
                            }
                        }
                    }
                    else {
                        resultText = "• 인증번호를 발송해주세요."
                        resultTextColor = errorTextColor
                    }
                }
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GetEmailViewPreview(){
    GetEmailView(navController = NavController(context = LocalContext.current), idText = "hello", passwordText = "world")
}