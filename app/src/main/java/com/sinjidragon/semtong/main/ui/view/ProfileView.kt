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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sinjidragon.semtong.R
import com.sinjidragon.semtong.auth.network.api.deleteUser
import com.sinjidragon.semtong.auth.network.user.getRole
import com.sinjidragon.semtong.auth.network.user.getUserId
import com.sinjidragon.semtong.auth.network.user.saveAccToken
import com.sinjidragon.semtong.auth.network.user.saveRefToken
import com.sinjidragon.semtong.auth.network.user.saveRole
import com.sinjidragon.semtong.auth.network.user.saveUserId
import com.sinjidragon.semtong.main.ui.component.AppBar
import com.sinjidragon.semtong.main.ui.component.BottomNav
import com.sinjidragon.semtong.main.ui.component.EnterBar
import com.sinjidragon.semtong.nav.NavGroup
import com.sinjidragon.semtong.ui.component.BaseAlert
import com.sinjidragon.semtong.ui.theme.gray2
import com.sinjidragon.semtong.ui.theme.pretendard
import com.sinjidragon.semtong.ui.theme.subColor
import com.sinjidragon.semtong.ui.theme.subColor2
import kotlinx.coroutines.launch

@Composable
fun ProfileView (navController : NavController){
    val context = LocalContext.current
    val userId = getUserId(context)
    val coroutineScope = rememberCoroutineScope()
    var showAlert by remember { mutableStateOf(false) }
    var onConfirm by remember { mutableStateOf({})}
    var alertContent by remember { mutableStateOf("") }
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
        BaseAlert(
            contentText = alertContent,
            showDialog = showAlert,
            isDismiss = true,
            onDismiss = {showAlert = false},
            onConfirm = {
                onConfirm()
                showAlert = false
            }
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
                text = "이용 약관",
                isFullClickable = true,
                isEnterButton = true,
                enterButtonColor = gray2,
                onClick = {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://semtong1.notion.site/1265ad66b02780c3bebee12c3c82ce60?pvs=74"))
                    context.startActivity(intent)
                }
            )
            EnterBar(
                text = "그룹 설정",
                isFullClickable = true,
                isEnterButton = true,
                enterButtonColor = gray2,
                onClick = {
                    val role = getRole(context)
                    if (role == "AGENT") {
                        navController.navigate(NavGroup.GROUP_SETTING_AGENT)
                    }
                    else if (role == "MEMBER") {
                        navController.navigate(NavGroup.GROUP_SETTING_MEMBER)
                    }
                }
            )
            EnterBar(
                text = "로그아웃",
                isFullClickable = true,
                isEnterButton = true,
                enterButtonColor = gray2,
                onClick = {
                    alertContent = "정말로 로그아웃 하시겠습니까?"
                    onConfirm = {
                        saveAccToken(context = context, token = null)
                        saveRefToken(context = context, token = null)
                        saveRole(context = context, role = null)
                        saveUserId(context = context, id = null)
                        navController.navigate(NavGroup.FIRST)
                    }
                    showAlert = true
                }
            )
            EnterBar(
                text = "회원탈퇴",
                isFullClickable = true,
                isEnterButton = true,
                enterButtonColor = subColor,
                textColor = subColor,
                onClick = {
                    alertContent = "정말로 탈퇴 하시겠습니까?"
                    onConfirm = {
                        coroutineScope.launch {
                            val result = deleteUser(context)
                            if (result == "success") {
                                navController.navigate(NavGroup.FIRST)
                            }
                        }
                    }
                    showAlert = true
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