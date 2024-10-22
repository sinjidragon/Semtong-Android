package com.sinjidragon.semtong.auth.ui.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sinjidragon.semtong.ui.theme.gray
import com.sinjidragon.semtong.ui.theme.gray2

@Composable
fun CodeTextFieldItem(
    text: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    focusRequester: FocusRequester,
    nextFocusRequester: FocusRequester? = null,
    previousFocusRequester: FocusRequester? = null,
    keyboardType: KeyboardType = KeyboardType.Number
) {
    Box(
        modifier = modifier
            .width(45.dp)
            .height(55.dp)
            .border(
                width = 1.dp,
                color = Color(0xFFEDEDED),
                shape = RoundedCornerShape(8.dp)
            )
            .clip(RoundedCornerShape(8.dp))
            .background(gray)
    ) {
        BasicTextField(
            value = text,
            onValueChange = { input ->
                if (input.length <= 1) {
                    onTextChange(input)
                    when {
                        input.isNotEmpty() -> nextFocusRequester?.requestFocus()
                        input.isEmpty() -> previousFocusRequester?.requestFocus()
                    }
                } else {
                    if (input.length == 6) {
                        onTextChange(input)
                        nextFocusRequester?.requestFocus()
                    }
                }
            },
            modifier = Modifier
                .align(Alignment.Center)
                .focusRequester(focusRequester),
            textStyle = TextStyle(
                fontSize = 25.sp,
                fontWeight = FontWeight.Medium,
                color = gray2,
                textAlign = TextAlign.Center
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            singleLine = true
        )
    }
}

@Composable
fun CodeTextField(
    code: List<String>,
    onCodeChange: (List<String>) -> Unit,
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Number
) {
    val focusRequesters = remember { List(6) { FocusRequester() } }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        for (i in code.indices) {
            CodeTextFieldItem(
                text = code[i],
                onTextChange = { input ->
                    val newCode = code.toMutableList()

                    if (input.length <= 1) {
                        newCode[i] = input
                    } else {
                        newCode.clear()
                        newCode.addAll(input.toList().map { it.toString() } + List(6 - input.length) { "" })
                    }

                    onCodeChange(newCode)
                    if (input.isNotEmpty()) {
                        focusRequesters.getOrNull(i + 1)?.requestFocus()
                    } else {
                        focusRequesters.getOrNull(i - 1)?.requestFocus()
                    }
                },
                modifier = Modifier
                    .weight(1f),
                focusRequester = focusRequesters[i],
                nextFocusRequester = if (i < code.size - 1) focusRequesters[i + 1] else null,
                previousFocusRequester = if (i > 0) focusRequesters[i - 1] else null,
                keyboardType = keyboardType
            )
        }
    }

    LaunchedEffect(Unit) {
        focusRequesters[0].requestFocus()
    }
}




@Preview(showBackground = true)
@Composable
fun CodeTextFieldPreview() {
    var code by remember { mutableStateOf(List(6) { "" }) }
    CodeTextField(
        code = code,
        onCodeChange = { newCode -> code = newCode },
        modifier = Modifier
    )
}


