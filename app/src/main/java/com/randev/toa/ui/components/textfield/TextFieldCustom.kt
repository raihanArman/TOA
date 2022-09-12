package com.randev.toa.ui.components.textfield

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.randev.toa.R
import com.randev.toa.ui.theme.TOATheme
import com.randev.toa.ui.theme.TextFieldShape

/**
 * @author Raihan Arman
 * @date 03/09/22
 */

@Composable
@Suppress("LongParameterList")
fun TextFieldCustom(
    text: String,
    onTextChanged: (String) -> Unit,
    labelText: String,
    modifier: Modifier = Modifier,
    errorMessage: String? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    Column {
        OutlinedTextField(
            value = text,
            onValueChange = onTextChanged,
            label = {
                Text(
                    text = labelText
                )
            },
            modifier = modifier
                .heightIn(dimensionResource(id = R.dimen.textfield_height))
                .fillMaxWidth(),
            shape = TextFieldShape,
            isError = (errorMessage != null),
            visualTransformation = visualTransformation
        )
        if (errorMessage != null) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colors.error,
                modifier = Modifier
                    .padding(top = 4.dp, start = 16.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewTextFieldCustom() {
    TOATheme {
        Surface() {
            TextFieldCustom(text = "Value", onTextChanged = {}, labelText = "Label", errorMessage = "")
        }
    }
}
