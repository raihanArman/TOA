@file:Suppress("MagicNumber")

package com.randev.toa.feature.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.randev.toa.R
import com.randev.toa.ui.components.PrimaryButton
import com.randev.toa.ui.components.SecondaryButton
import com.randev.toa.ui.components.textfield.TextFieldCustom
import com.randev.toa.ui.core.VerticalSpacer
import com.randev.toa.ui.theme.TOATheme

/**
 * @author Raihan Arman
 * @date 04/09/22
 */

private const val APP_LOGO_WIDTH_PERCENTAGE = 0.75f

@Composable
fun LoginScreen(
    viewState: LoginViewState,
    onUsernameChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onLoginClicked: () -> Unit,
    onSignUpClicked: () -> Unit
) {
    Surface(
        color = MaterialTheme.colors.primary,

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(id = R.dimen.screen_padding)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(
                modifier = Modifier
                    .weight(1f)
            )

            AppLogo()
            Spacer(
                modifier = Modifier
                    .weight(1f)
            )
            EmailInput(
                text = viewState.email,
                onTextChanged = onUsernameChanged
            )
            Spacer(modifier = Modifier.height(12.dp))
            PasswordInput(
                text = viewState.password,
                onTextChanged = onPasswordChanged
            )
            VerticalSpacer(12.dp)
            LoginButton(
                onClick = onLoginClicked
            )
            VerticalSpacer(12.dp)
            SignUpButton(
                onClick = onSignUpClicked
            )
        }
    }
}

@Composable
private fun SignUpButton(
    onClick: () -> Unit
) {
    SecondaryButton(
        text = stringResource(R.string.signup),
        onClick = onClick,
        contentColor = MaterialTheme.colors.primary
    )
}

@Composable
private fun PasswordInput(
    text: String,
    onTextChanged: (String) -> Unit
) {
    TextFieldCustom(
        text = text,
        onTextChanged = onTextChanged,
        labelText = stringResource(R.string.pasword)
    )
}

@Composable
private fun LoginButton(
    onClick: () -> Unit
) {
    PrimaryButton(
        text = stringResource(R.string.login),
        onClick = onClick,
        backgroundColor = MaterialTheme.colors.secondary
    )
}

@Composable
private fun EmailInput(
    text: String,
    onTextChanged: (String) -> Unit
) {
    TextFieldCustom(
        text = text,
        onTextChanged = onTextChanged,
        labelText = stringResource(R.string.email)
    )
}

@Composable
private fun AppLogo() {
    Image(
        painter = painterResource(id = R.drawable.ic_toa_checkmark),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth(APP_LOGO_WIDTH_PERCENTAGE)
    )
}

@Preview
@Composable
fun LoginPreview() {
    TOATheme {
        LoginScreen(
            viewState = LoginViewState("", password = ""),
            onLoginClicked = {},
            onPasswordChanged = {},
            onSignUpClicked = {},
            onUsernameChanged = {}
        )
    }
}
