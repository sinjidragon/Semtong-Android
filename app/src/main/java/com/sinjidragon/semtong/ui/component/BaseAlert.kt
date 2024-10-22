package com.sinjidragon.semtong.ui.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sinjidragon.semtong.ui.theme.mainColor
import com.sinjidragon.semtong.ui.theme.pretendard

@Composable
fun BaseAlert(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    isDismiss: Boolean = false,
    titleText: String = "알림",
    contentText: String = "이것은 텍스트이다",
    confirmText: String = "확인",
    dismissText: String = "취소"
) {
    if (showDialog) {
        AlertDialog(
            shape = RoundedCornerShape(8.dp),
            containerColor = Color.White,
            onDismissRequest = {
                onDismiss()
            },
            title = {
                Text(text = titleText)
            },
            text = {
                Text(text = contentText)
            },
            confirmButton = {
                Button(
                    colors = ButtonColors(
                        containerColor = mainColor,
                        contentColor = Color.Black,
                        disabledContainerColor = mainColor,
                        disabledContentColor = Color.Black),
                    onClick = {
                        onConfirm()
                    }
                ) {
                    Text(
                        fontFamily = pretendard,
                        fontWeight = FontWeight.Light,
                        text = confirmText
                    )
                }
            },
            dismissButton = {
                if (isDismiss) {
                    Button(
                        colors = ButtonColors(
                            containerColor = mainColor,
                            contentColor = Color.Black,
                            disabledContainerColor = mainColor,
                            disabledContentColor = Color.Black
                        ),
                        onClick = {
                            onDismiss()
                        }
                    ) {
                        Text(
                            fontFamily = pretendard,
                            fontWeight = FontWeight.Light,
                            text = dismissText
                        )
                    }
                }
            },
        )
    }
}
@Preview
@Composable
fun SimpleAlertDialogPreview() {
    BaseAlert(showDialog = true, onDismiss = {}, onConfirm = {})
}

