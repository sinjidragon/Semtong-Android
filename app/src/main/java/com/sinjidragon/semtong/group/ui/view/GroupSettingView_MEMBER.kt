package com.sinjidragon.semtong.group.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.sinjidragon.semtong.auth.ui.component.BackButton
import com.sinjidragon.semtong.group.network.api.getGroupInfo
import com.sinjidragon.semtong.group.network.api.leaveGroup
import com.sinjidragon.semtong.group.network.data.GroupInfo
import com.sinjidragon.semtong.group.network.data.Member
import com.sinjidragon.semtong.group.ui.component.GroupInfoBox
import com.sinjidragon.semtong.main.ui.component.EnterBar
import com.sinjidragon.semtong.nav.NavGroup
import com.sinjidragon.semtong.ui.component.BaseAlert
import com.sinjidragon.semtong.ui.theme.pretendard
import com.sinjidragon.semtong.ui.theme.subColor
import com.sinjidragon.semtong.ui.theme.subColor2
import kotlinx.coroutines.launch

@Composable
fun GroupSettingView_MEMBER(navController: NavController) {
    val context = LocalContext.current
    var groupName by remember { mutableStateOf("") }
    var groupCode by remember { mutableStateOf("") }
    var members by remember { mutableStateOf(listOf<Member>()) }
    var agent by remember { mutableStateOf<Member?>(null) }
    var showDialog by remember { mutableStateOf(false) }
    var alertContent by remember { mutableStateOf("") }
    var alertFunction by remember { mutableStateOf({}) }
    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(Unit) {
        val response = getGroupInfo(context)
        if (response is GroupInfo) {
            groupName = response.groupName
            groupCode = response.groupCode
            agent = response.members.find { it.role == "AGENT" }
            members = response.members.filter { it.role != "AGENT" }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .systemBarsPadding()
    )
    Box(
        modifier = Modifier
            .background(subColor2)
            .fillMaxWidth()
            .height(218.dp)
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
    ) {
        BaseAlert(
            contentText = alertContent,
            showDialog = showDialog,
            isDismiss = true,
            onDismiss = {showDialog = false},
            onConfirm = {
                alertFunction()
                showDialog = false
            }
        )
        BackButton(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 16.dp),
            onClick = { navController.navigate(NavGroup.PROFILE) },
            color = Color.Black
        )
        Text(
            text = "그룹 설정",
            modifier = Modifier.align(Alignment.TopCenter),
            fontSize = 16.sp,
            fontFamily = pretendard,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )
        GroupInfoBox(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = 112.dp),
            groupName = groupName,
            groupCode = groupCode
        )
        Column(
            modifier = Modifier
                .offset(y = 320.dp)
        ) {
            agent?.let {
                EnterBar(
                    text = it.username,
                    isButton = false,
                    textColor = Color.Black,
                    isEnterButton = false
                )
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                items(members) { member ->
                    EnterBar(
                        text = member.username,
                        textColor = Color.Black,
                        isButton = false
                    )
                }
            }
            EnterBar(
                isFullClickable = true,
                textColor = subColor,
                text = "그룹 탈퇴",
                isEnterButton = true,
                enterButtonColor = subColor,
                onClick = {
                    alertContent = "정말로 탈퇴하시겠습니까?"
                    alertFunction = {
                       coroutineScope.launch {
                           val result = leaveGroup(context)
                           if (result == "success"){
                               navController.navigate(NavGroup.GROUP)
                           }
                       }
                    }
                    showDialog = true
                }
            )
        }
    }
}

@Preview
@Composable
fun GroupSettingView_MEMBERPreview(){
    GroupSettingView_MEMBER(navController = NavController(LocalContext.current))
}