package com.sinjidragon.semtong.auth.ui.view.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sinjidragon.semtong.R
import com.sinjidragon.semtong.ui.theme.dropShadow
import com.sinjidragon.semtong.ui.theme.mainColor
import com.sinjidragon.semtong.ui.theme.pretendard

@Composable
fun AuthBaseButton(
    color: Color,
    text: String,
    onClick: () -> Unit = {},
    modifier: Modifier,
    isEnterButton : Boolean = false
)
{
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(horizontal = 40.dp)
            .dropShadow(shape = RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(8.dp))
            .background(color)
            .clickable(
                onClick = onClick
            )


    ){
        Row (
            Modifier.align(Alignment.Center)
        ){
            Text(
                text = text,
                fontFamily = pretendard,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
                modifier = Modifier
            )
            if(isEnterButton) {
                Image(
                    painter = painterResource(id = R.drawable.enter_button),
                    contentDescription = "AuthImage",
                    colorFilter = ColorFilter.tint(Color.Black),
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.CenterVertically)
                        .offset(x = 6.dp)
                )
            }
        }
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