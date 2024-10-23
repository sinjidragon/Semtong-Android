package com.sinjidragon.semtong.group.ui.view

import android.util.Log
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
import androidx.compose.runtime.rememberCoroutineScope
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
import com.sinjidragon.semtong.auth.ui.component.AuthBaseButton
import com.sinjidragon.semtong.auth.ui.component.BackButton
import com.sinjidragon.semtong.auth.ui.component.CodeTextField
import com.sinjidragon.semtong.auth.ui.component.PrivacyPolicyText
import com.sinjidragon.semtong.group.network.api.create
import com.sinjidragon.semtong.group.network.api.join
import com.sinjidragon.semtong.group.network.data.CreateResponseBody
import com.sinjidragon.semtong.nav.NavGroup
import com.sinjidragon.semtong.ui.theme.errorTextColor
import com.sinjidragon.semtong.ui.theme.gray2
import com.sinjidragon.semtong.ui.theme.pretendard
import com.sinjidragon.semtong.ui.theme.subColor2
import kotlinx.coroutines.launch

@Composable
fun GroupView (navController : NavController){
    var code by remember { mutableStateOf(List(6) { "" }) }
    var resultText by remember { mutableStateOf("") }
    var resultTextColor by remember { mutableStateOf(errorTextColor) }
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
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
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                modifier = Modifier
                    .padding(start = 40.dp),
                text = resultText,
                fontFamily = pretendard,//●
                fontWeight = FontWeight.Medium,
                color = errorTextColor,
                fontSize = 10.sp
            )
            AuthBaseButton(
                color = Color.White,
                text = "그룹 참여하기",
                isEnterButton = true,
                modifier = Modifier,
                onClick = {
                    coroutineScope.launch {
                        val response = join(context, code.joinToString(""))
                        if (response == "succes"){
                            Log.d("Group", "success")
                        }
                        else {
                            resultText = "• $response"
                            resultTextColor = errorTextColor
                        }
                    }
                }
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
                modifier = Modifier,
                onClick = {
                    coroutineScope.launch {
                        val response = create(context)
                        if (response is CreateResponseBody){
                            TODO()
                        }
                        else{
                            resultText = "• $response"
                            resultTextColor = errorTextColor
                        }
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
fun GroupViewPreview() {
    GroupView(navController = NavController(context = LocalContext.current))
}