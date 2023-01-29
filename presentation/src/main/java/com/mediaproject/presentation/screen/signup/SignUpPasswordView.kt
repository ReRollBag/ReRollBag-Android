package com.mediaproject.presentation.screen.signup

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mediaproject.presentation.common.component.ReRollBagTextField
import com.mediaproject.presentation.common.theme.gray2
import com.mediaproject.presentation.common.theme.notoSansFamily
import com.mediaproject.presentation.widgets.states.SignUpState

@Composable
fun SignUpPasswordView(
    modifier: Modifier = Modifier,
    uiState: SignUpState?,
) {
    var password by rememberSaveable { mutableStateOf("") }
    var passwordCheckStr by rememberSaveable { mutableStateOf("") }

    Column {
        // region Password
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                "비밀번호",
                style = TextStyle(
                    fontFamily = notoSansFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 10.sp,
                    textAlign = TextAlign.Center,
                    lineHeight = 18.sp
                )
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ReRollBagTextField(
                        value = password,
                        onValueChange = {
                            password = it
                        },
                        isPassword = true
                    )
                    Divider(color = gray2, thickness = 1.dp)
                }
            }
        }
        // endregion

        Spacer(modifier = Modifier.height(30.dp))

        // region Password Check
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                "비밀번호 확인",
                style = TextStyle(
                    fontFamily = notoSansFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 10.sp,
                    textAlign = TextAlign.Center,
                    lineHeight = 18.sp
                )
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ReRollBagTextField(
                        value = passwordCheckStr,
                        onValueChange = {
                            passwordCheckStr = it
                        },
                        isPassword = true
                    )
                    Divider(color = gray2, thickness = 1.dp)
                }
            }
        }
        // endregion
    }
}

@Preview(
    showBackground = true,
)
@Composable
fun SignUpPasswordViewPreview() {
    SignUpPasswordView(uiState = SignUpState.SignUpInit)
}