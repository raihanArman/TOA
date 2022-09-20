@file:Suppress("MagicNumber")

package com.randev.toa.feature.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.randev.toa.R
import com.randev.toa.feature.getString
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
fun LoginContent(
    viewState: LoginViewState,
    onUsernameChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onLoginClicked: () -> Unit,
    onSignUpClicked: () -> Unit
) {
    Surface(
        color = MaterialTheme.colors.background,

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            LogoInputColumn(
                viewState,
                onUsernameChanged,
                onPasswordChanged,
                onLoginClicked,
                onSignUpClicked
            )

            if (viewState is LoginViewState.Submitting) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .wrapContentSize()
                        .align(Alignment.Center)
                )
            }
        }
    }
}

@Composable
private fun LogoInputColumn(
    viewState: LoginViewState,
    onUsernameChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onLoginClicked: () -> Unit,
    onSignUpClicked: () -> Unit
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
            text = viewState.credentials.email.value,
            onTextChanged = onUsernameChanged,
            errorMessage = (viewState as? LoginViewState.Active)?.emailInputErrorMessage?.getString(),
        )
        Spacer(modifier = Modifier.height(12.dp))
        PasswordInput(
            text = viewState.credentials.password.value,
            onTextChanged = onPasswordChanged,
            errorMessage = (viewState as? LoginViewState.Active)?.passwordInputErrorMessage?.getString(),
        )

        if (viewState is LoginViewState.SubmissionError) {
            Text(
                text = viewState.errorMessage.getString(LocalContext.current),
                color = MaterialTheme.colors.error,
                modifier = Modifier
                    .padding(top = 12.dp)
            )
        }

        VerticalSpacer(12.dp)

        val buttonEnabled: Boolean = (viewState is LoginViewState.Submitting)
        LoginButton(
            onClick = onLoginClicked,
            enabled = viewState.buttonEnabled
        )
        VerticalSpacer(12.dp)
        SignUpButton(
            onClick = onSignUpClicked,
            enabled = viewState.buttonEnabled
        )
    }
}

@Composable
private fun SignUpButton(
    onClick: () -> Unit,
    enabled: Boolean,
) {
    SecondaryButton(
        text = stringResource(R.string.signup),
        onClick = onClick,
        contentColor = MaterialTheme.colors.primary,
        enabled = enabled
    )
}

@Composable
private fun PasswordInput(
    text: String,
    onTextChanged: (String) -> Unit,
    errorMessage: String?,
    enabled: Boolean = true
) {
    TextFieldCustom(
        text = text,
        onTextChanged = onTextChanged,
        labelText = stringResource(R.string.pasword),
        errorMessage = errorMessage,
        visualTransformation = PasswordVisualTransformation(),
        enabled = enabled,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        )
    )
}

@Composable
private fun LoginButton(
    onClick: () -> Unit,
    enabled: Boolean
) {
    PrimaryButton(
        text = stringResource(R.string.login),
        onClick = onClick,
        backgroundColor = MaterialTheme.colors.primary,
        enabled = enabled
    )
}

@Composable
private fun EmailInput(
    text: String,
    onTextChanged: (String) -> Unit,
    errorMessage: String?,
    enabled: Boolean = true
) {
    TextFieldCustom(
        text = text,
        onTextChanged = onTextChanged,
        labelText = stringResource(R.string.email),
        errorMessage = errorMessage,
        enabled = enabled
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
    val viewState = LoginViewState.Initial
    TOATheme {
        LoginContent(
            viewState = viewState,
            onLoginClicked = {},
            onPasswordChanged = {},
            onSignUpClicked = {},
            onUsernameChanged = {}
        )
    }
}
