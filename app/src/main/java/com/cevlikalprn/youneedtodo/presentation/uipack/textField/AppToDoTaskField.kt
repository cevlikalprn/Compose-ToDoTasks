package com.cevlikalprn.youneedtodo.presentation.uipack.textField

import androidx.compose.material.LocalTextStyle
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import com.cevlikalprn.youneedtodo.common.Constants.EMPTY_STRING
import com.cevlikalprn.youneedtodo.common.TextFieldValueChange

@Composable
fun AppToDoTaskField(
    modifier: Modifier = Modifier,
    value: String = EMPTY_STRING,
    onValueChange: TextFieldValueChange,
    labelValue: String = EMPTY_STRING,
    textStyle: TextStyle = LocalTextStyle.current,
    singleLine: Boolean = false
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(text = labelValue)
        },
        textStyle = textStyle,
        singleLine = singleLine
    )
}