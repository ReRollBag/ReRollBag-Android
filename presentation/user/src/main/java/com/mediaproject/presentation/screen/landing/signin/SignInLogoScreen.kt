package com.mediaproject.presentation.screen.landing.signin

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mediaproject.presentation.R

@Composable
fun SignInLogoScreen() = Image(
    modifier = Modifier
        .heightIn(max = 42.dp)
        .fillMaxWidth(),
    painter = painterResource(id = R.drawable.logo_rerollbag),
    contentDescription = "ReRollBag"
)

@Preview(showBackground = true)
@Composable
fun SignInLogoScreenPreview() {
    SignInLogoScreen()
}