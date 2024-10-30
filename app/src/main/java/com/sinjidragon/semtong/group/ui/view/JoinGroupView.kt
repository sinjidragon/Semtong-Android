package com.sinjidragon.semtong.group.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sinjidragon.semtong.R
import com.sinjidragon.semtong.auth.ui.component.AuthBaseButton
import com.sinjidragon.semtong.auth.ui.component.BackButton
import com.sinjidragon.semtong.auth.ui.component.PrivacyPolicyText
import com.sinjidragon.semtong.group.network.api.create
import com.sinjidragon.semtong.group.network.data.CreateResponseBody
import com.sinjidragon.semtong.group.ui.component.GroupInfoBox
import com.sinjidragon.semtong.nav.NavGroup
import com.sinjidragon.semtong.ui.theme.errorTextColor
import com.sinjidragon.semtong.ui.theme.mainColor
import com.sinjidragon.semtong.ui.theme.pretendard
import com.sinjidragon.semtong.ui.theme.subColor2
import kotlinx.coroutines.launch

@Composable
fun JoinGroupView(navController : NavController, groupName : String, groupCode : String) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(subColor2)
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
        Image(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .size(209.dp)
                .offset(y = 121.dp),
            painter = painterResource(id = R.drawable.wallet_card_coin),
            contentDescription = "image"
        )
        GroupInfoBox(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = 340.dp),
            groupName = groupName,
            groupCode = groupCode,
        )
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
                text = "완료",
                modifier = Modifier,
                onClick = {
                    navController.navigate(NavGroup.HOME)
                }
            )
        }
    }
}
@Preview
@Composable
fun JoinGroupViewPreview() {
    JoinGroupView(navController = NavController(context = LocalContext.current), groupName = "hello", groupCode = "worlWd")
}