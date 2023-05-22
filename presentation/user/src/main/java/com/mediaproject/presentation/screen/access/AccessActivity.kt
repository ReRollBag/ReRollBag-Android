package com.mediaproject.presentation.screen.access

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mediaproject.presentation.common.theme.ReRollBagTheme
import com.mediaproject.presentation.screen.home.HomeActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AccessActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ReRollBagTheme {
                AccessScreen {
                    applicationContext.startActivity(
                        Intent(applicationContext, HomeActivity::class.java).apply {
                            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        }
                    )
                }
            }
        }
    }
}