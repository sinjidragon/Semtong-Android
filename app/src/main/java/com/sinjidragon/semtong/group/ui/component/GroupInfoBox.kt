package com.sinjidragon.semtong.group.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sinjidragon.semtong.R
import com.sinjidragon.semtong.ui.theme.gray2
import com.sinjidragon.semtong.ui.theme.pretendard

@Composable
fun GroupInfoBox(
    modifier: Modifier = Modifier,
    groupName: String = "hello",
    groupCode: String = "AFDSFD",
) {
    val clipboardManager = LocalClipboardManager.current
    val codeAnnotated = buildAnnotatedString { append(groupCode)}
    Box (modifier=modifier.fillMaxWidth()){
        Image(
            modifier = Modifier
                .align(Alignment.Center),
            painter = painterResource(id = R.drawable.group_info),
            contentDescription = "그룹 정보"
        )
        Text(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = 37.dp),
            text = groupName,
            fontFamily = pretendard,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
            color = gray2
        )
        Row(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = 75.dp)
        ) {
            Text(
                modifier = Modifier,
                text = groupCode,
                fontFamily = pretendard,
                fontWeight = FontWeight.Medium,
                fontSize = 40.sp,
                letterSpacing = 6.sp,
                color = gray2
            )
            Spacer(modifier = Modifier.width(10.dp))
            Image(
                modifier = Modifier
                    .align(Alignment.Bottom)
                    .offset(y = (-10).dp)
                    .size(20.dp)
                    .clickable { clipboardManager.setText(codeAnnotated) },
                painter = painterResource(id = R.drawable.copy_button),
                contentDescription = "copy button"
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GroupInfoBoxPreview(){
    GroupInfoBox()
}