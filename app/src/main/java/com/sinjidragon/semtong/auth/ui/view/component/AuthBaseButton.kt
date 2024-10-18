package com.sinjidragon.semtong.auth.ui.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sinjidragon.semtong.ui.theme.dropShadow
import com.sinjidragon.semtong.ui.theme.mainColor
import com.sinjidragon.semtong.ui.theme.pretendard

@Composable
fun AuthBaseButton(
    color: Color,
    text: String,
    onClick: () -> Unit = {},
    modifier: Modifier
)
{
    Box(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(0.06f)
            .padding(horizontal = 40.dp)
            .dropShadow(shape = RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(8.dp))
            .background(color)
            .clickable(
                onClick = onClick
            )


    ){
        Text(
            text = text,
            fontFamily = pretendard,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun AuthBaseButtonPreview(){
    Box {
        AuthBaseButton(color = mainColor, text = "로그인", modifier = Modifier.align(Alignment.Center))
    }
}