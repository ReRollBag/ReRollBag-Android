package com.mediaproject.presentation.screen.landing.signup

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mediaproject.presentation.R
import com.mediaproject.presentation.common.component.ReRollBagTextField
import com.mediaproject.presentation.common.theme.*
import com.mediaproject.presentation.common.theme.notoSansFamily
import com.mediaproject.presentation.widgets.states.SignUpData
import com.mediaproject.presentation.widgets.states.SignUpState

@Composable
fun SignUpScreenBody(
    modifier: Modifier = Modifier,
    uiState: SignUpState?,
    onDuplicateCheckUserId: (data: SignUpData) -> Unit = {},
    onChangePassword: (newValue: String) -> Unit = {},
    onChangePasswordChecker: (newValue: String) -> Unit = {},
    onChangeName: (newValue: String) -> Unit = {},
) {

    var userId by rememberSaveable { mutableStateOf("") }
    var isExistUserId by rememberSaveable { mutableStateOf(false) }

    var password by rememberSaveable { mutableStateOf("") }
    var passwordCheckStr by rememberSaveable { mutableStateOf("") }
    val colorEnglish = if (checkEnglish(password)) green2 else gray2
    val colorNumber = if (checkNumber(password)) green2 else gray2
    val colorLength = if (password.length in 8..20) green2 else gray2
    val colorPassword = if (password == passwordCheckStr) green2 else gray2

    var name by rememberSaveable { mutableStateOf("") }
    var phoneNumber by rememberSaveable { mutableStateOf("") }


    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 30.dp,
                    vertical = 8.dp
                )
                .verticalScroll(rememberScrollState()),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    "이메일",
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
                        modifier = Modifier.widthIn(max = 200.dp)
                    ) {
                        ReRollBagTextField(
                            value = userId,
                            onValueChange = { newValue ->
                                userId = newValue
                            },
                            enable = !(uiState!!.data.isExistUserId),
                        )
                        Divider(color = isEmailSuccessColor(uiState), thickness = 1.dp)
                    }
                    Spacer(modifier = Modifier.width(40.dp))
                    Button(
                        modifier = Modifier
                            .width(100.dp),
                        border = BorderStroke(
                            1.dp,
                            isEmailSuccessColor(uiState)
                        ),
                        shape = RoundedCornerShape(25.dp),
                        enabled = !(uiState!!.data.isExistUserId),
                        onClick = {
                            onDuplicateCheckUserId(
                                SignUpData(
                                    userId = userId,
                                    isExistUserId = isExistUserId,
                                    password = password,
                                    passwordCheckStr = passwordCheckStr,
                                    name = name,
                                )
                            )
                        },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.White,
                            contentColor = isEmailSuccessColor(uiState)
                        ),
                    ) {
                        Text(
                            text = "중복확인",
                            style = TextStyle(
                                fontWeight = FontWeight.Normal,
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center,
                                lineHeight = 0.sp,
                            ),
                            modifier = Modifier.height(20.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

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
                                    onChangePassword(password)
                                },
                                isPassword = true
                            )
                            Divider(
                                color = if (checkEnglish(password) && checkNumber(password) && password.length in 8..20)
                                    green2
                                else
                                    gray2,
                                thickness = 1.dp
                            )
                        }
                    }
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "영문 포함",
                        style = ReRollBagTypography.title3,
                        color = colorEnglish
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Image(
                        painter = painterResource(id = R.drawable.ic_checker),
                        contentDescription = "checkEnglish",
                        contentScale = ContentScale.Inside,
                        colorFilter = ColorFilter.tint(colorEnglish)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "숫자 포함",
                        style = ReRollBagTypography.title3,
                        color = colorNumber
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Image(
                        painter = painterResource(id = R.drawable.ic_checker),
                        contentDescription = "checkNumber",
                        contentScale = ContentScale.Inside,
                        colorFilter = ColorFilter.tint(colorNumber)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "8 ~ 20자 이내",
                        style = ReRollBagTypography.title3,
                        color = colorLength
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Image(
                        painter = painterResource(id = R.drawable.ic_checker),
                        contentDescription = "checkLength",
                        contentScale = ContentScale.Inside,
                        colorFilter = ColorFilter.tint(colorLength)
                    )
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
                                    onChangePasswordChecker(passwordCheckStr)
                                },
                                isPassword = true
                            )
                            Divider(
                                color = if (password == passwordCheckStr && passwordCheckStr.isNotEmpty()) green2 else gray2,
                                thickness = 1.dp
                            )
                        }
                    }
                    Row(
                        modifier = Modifier.alpha(
                            if (password == passwordCheckStr && passwordCheckStr.isNotEmpty()) 1f else 0f
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "비밀번호가 일치합니다.",
                            style = ReRollBagTypography.title3,
                            color = colorPassword
                        )
                    }
                }
                // endregion
            }

            Spacer(modifier = Modifier.height(30.dp))

            // region name
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    "이름",
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
                            value = name,
                            onValueChange = {
                                name = it
                                onChangeName(name)
                            },
                        )
                        Divider(color = gray2, thickness = 1.dp)
                    }
                }
            }
            // endregion

            Spacer(modifier = Modifier.height(30.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    "전화 번호",
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
                        modifier = Modifier.widthIn(max = 200.dp)
                    ) {
                        ReRollBagTextField(
                            value = phoneNumber,
                            onValueChange = { newValue ->
                                phoneNumber = newValue
                            },
                            enable = !(uiState!!.data.isExistUserId),
                            keyboardType = KeyboardType.Number
                        )
                        Divider(color = isEmailSuccessColor(uiState), thickness = 1.dp)
                    }
                    Spacer(modifier = Modifier.width(40.dp))
                    Button(
                        modifier = Modifier
                            .width(100.dp),
                        border = BorderStroke(
                            1.dp,
                            isEmailSuccessColor(uiState)
                        ),
                        shape = RoundedCornerShape(25.dp),
                        enabled = !(uiState!!.data.isExistUserId),
                        onClick = {

                        },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.White,
                            contentColor = isEmailSuccessColor(uiState)
                        ),
                    ) {
                        Text(
                            text = "인증 요청",
                            style = TextStyle(
                                fontWeight = FontWeight.Normal,
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center,
                                lineHeight = 0.sp,
                            ),
                            modifier = Modifier.height(20.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}

private fun isEmailSuccessColor(uiState: SignUpState?) = when (uiState!!) {
    is SignUpState.SignUpError -> Color.Red
    else -> if (uiState.data.isExistUserId) green1 else gray2
}

private fun checkEnglish(
    text: String,
): Boolean = "[a-zA-Z]+".toRegex().containsMatchIn(text)

private fun checkNumber(
    text: String,
): Boolean = "\\d+".toRegex().containsMatchIn(text)

fun checkAll(
    text: String
): Boolean = checkEnglish(text) && checkNumber(text) && text.length >= 8 && text.length <= 20

@Preview(
    showBackground = true,
)
@Composable
fun SignUpScreenBodyPreview() {
    val screenCase = 1
    when (screenCase) {
        1 -> SignUpScreenBody(
            uiState = SignUpState.SignUpError(
                state = SignUpData(),
                errorMessage = "error"
            )
        )
        else -> SignUpScreenBody(
            uiState = SignUpState.SignUpInit
        )
    }

}