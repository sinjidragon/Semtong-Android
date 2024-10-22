package com.sinjidragon.semtong.auth.ui.component

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.sinjidragon.semtong.ui.theme.gray2
import com.sinjidragon.semtong.ui.theme.pretendard
import com.sinjidragon.semtong.ui.theme.subColor

@Composable
fun PrivacyPolicyText(modifier: Modifier) {
    val context = LocalContext.current

    Column(
        modifier = modifier
    ) {
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "계정을 생성함으로써,",
            fontFamily = pretendard,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            color = gray2
        )
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally),
        ) {
            Text(
                modifier = Modifier.clickable {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://semtong1.notion.site/1265ad66b02780c3bebee12c3c82ce60?pvs=4"))
                    context.startActivity(intent)
                },
                text = "이용약관",
                fontFamily = pretendard,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp,
                color = subColor
            )
            Text(
                text = "과 ",
                fontFamily = pretendard,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp,
                color = gray2
            )
            Text(
                modifier = Modifier.clickable {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://semtong1.notion.site/1265ad66b02780cc9f9dc41dd8d4f974?pvs=4"))
                    context.startActivity(intent)
                },
                text = "개인정보처리방침",
                fontFamily = pretendard,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp,
                color = subColor
            )
            Text(
                text = "에 동의하셨음을 확인합니다.",
                fontFamily = pretendard,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp,
                color = gray2
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PrivacyPolicyTextPreview() {
    PrivacyPolicyText(modifier = Modifier)
}
