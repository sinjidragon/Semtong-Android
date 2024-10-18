package com.sinjidragon.semtong.auth.ui.view.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sinjidragon.semtong.R
import com.sinjidragon.semtong.ui.theme.gray
import com.sinjidragon.semtong.ui.theme.gray2
import com.sinjidragon.semtong.ui.theme.pretendard
import com.sinjidragon.semtong.ui.theme.subColor

@Composable
fun AuthTextField(
    modifier: Modifier = Modifier,
    onTextChange: (String) -> Unit,
    text: String,
    icon: Int,
    isPassword: Boolean = false,
    isButton: Boolean = false,
    placeholder: String = "",
    onClick: () -> Unit = {},
    buttonText : String = "인증"
) {
    var showPassword by remember { mutableStateOf(false) }
    var hidePasswordIcon by remember { mutableIntStateOf(value = R.drawable.show_password) }

    Row(
        modifier = modifier
            .padding(horizontal = 40.dp)
            .height(45.dp)
            .background(gray)
            .border(
                width = 1.dp,
                color = Color(0xFFEDEDED),
                shape = RoundedCornerShape(8.dp)
            )
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = "AuthImage",
            colorFilter = ColorFilter.tint(gray2),
            modifier = Modifier
                .size(20.dp)
                .align(Alignment.CenterVertically)
                .offset(x = 13.dp)
        )
        Spacer(modifier = Modifier.width(20.dp))

        BasicTextField(
            value = text,
            onValueChange = onTextChange,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .weight(1f),
            textStyle = TextStyle(
                fontSize = 14.sp,
                fontFamily = pretendard,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            ),
            decorationBox = { innerTextField ->
                Box(
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (text.isEmpty()) {
                        Text(
                            text = placeholder,
                            fontFamily = pretendard,
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                            color = gray2
                        )
                    }
                    innerTextField()
                }
            },
            visualTransformation =
            if (isPassword && !showPassword) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            }
        )

        if (isButton) {
            if (isPassword) {
                Spacer(modifier = Modifier.width(8.dp))
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.CenterVertically)
                        .offset(x = (-14).dp),
                    contentAlignment = Alignment.CenterEnd,
                ) {
                    Image(
                        painter = painterResource(id = if (showPassword) R.drawable.not_show_password else R.drawable.show_password),
                        contentDescription = "Toggle password visibility",
                        modifier = Modifier
                            .size(20.dp)
                            .clickable {
                                showPassword = !showPassword

                                hidePasswordIcon = R.drawable.not_show_password
                            }
                    )
                }
            }
            else {
                Spacer(modifier = Modifier.width(8.dp))
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .align(Alignment.CenterVertically)
                        .offset(x = (-14).dp),
                    contentAlignment = Alignment.CenterEnd,
                ) {
                    Text(
                        text = buttonText,
                        modifier = Modifier
                            .clickable { onClick() },
                        fontFamily = pretendard,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        color = subColor
                    )

                }
            }
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun AuthTextFieldPreview(){
    AuthTextField(
        modifier = Modifier,
        onTextChange = {},
        text = "",
        icon = R.drawable.id_icon,
        placeholder = "아이디를 입력하세요",
        isPassword = false,
        isButton = true,
        buttonText = "인증"
    )
}