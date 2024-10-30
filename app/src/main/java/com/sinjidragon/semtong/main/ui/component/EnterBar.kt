package com.sinjidragon.semtong.main.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sinjidragon.semtong.R
import com.sinjidragon.semtong.ui.theme.mainColor
import com.sinjidragon.semtong.ui.theme.pretendard
import com.sinjidragon.semtong.ui.theme.subColor

@Composable
fun EnterBar(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    text : String = "userId",
    textColor : Color = Color.Black,
    isEnterButton : Boolean = false,
    isFullClickable : Boolean = false,
    isButton : Boolean = true,
    buttonText : String = "",
    enterButtonColor : Color = mainColor
){
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .height(55.dp)
            .clickable {
                if (isFullClickable) {
                    onClick()
                }
            }
    ){
        Box (
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 50.dp)
                .fillMaxWidth(),
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.CenterStart),
                text = text,
                fontFamily = pretendard,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = textColor
            )
            if (isButton) {
                if (isEnterButton) {
                    Icon(
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .size(20.dp)
                            .clickable { onClick() },
                        painter = painterResource(id = R.drawable.enter_button),
                        contentDescription = "",
                        tint = enterButtonColor
                    )
                }
                else {
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .clickable { onClick() },
                        text = buttonText,
                        fontFamily = pretendard,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        color = subColor
                    )
                }
            }
        }
    }
}
@Preview
@Composable
fun EnterBarPreview(){
    EnterBar()
}