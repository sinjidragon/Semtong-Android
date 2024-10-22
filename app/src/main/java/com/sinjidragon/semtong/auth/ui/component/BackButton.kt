package com.sinjidragon.semtong.auth.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sinjidragon.semtong.R
import com.sinjidragon.semtong.ui.theme.pretendard

@Composable
fun BackButton(
    modifier: Modifier,
    onClick: () -> Unit,
    color: Color
)
{
    Row(
        modifier
            .clickable(onClick = onClick)
            .background(Color.Transparent)
            .padding(0.dp)
            .wrapContentSize()
            .width(76.dp)
            .height(23.dp)
    )
    {
        Image(
            modifier = Modifier.align(Alignment.CenterVertically),
            painter = painterResource(id = R.drawable.back_button),
            contentDescription = "Back Button",
            colorFilter = ColorFilter.tint(color)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "뒤로가기",
            color = color,
            fontSize = 16.sp,
            fontFamily = pretendard,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}
@Composable
@Preview(
    showBackground = true,
    showSystemUi = true
)
fun BackScreenButtonPreview() {
    BackButton(modifier = Modifier,color = Color.Black,onClick = {})
}
