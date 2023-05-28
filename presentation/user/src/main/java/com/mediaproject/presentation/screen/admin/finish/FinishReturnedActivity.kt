package com.mediaproject.presentation.screen.admin.finish

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mediaproject.presentation.common.theme.ReRollBagTheme
import com.mediaproject.presentation.screen.admin.home.AdminHomeActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FinishReturnedActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ReRollBagTheme {
                FinishReturnedScreen {
                    applicationContext.startActivity(
                        Intent(applicationContext, AdminHomeActivity::class.java).apply {
                            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        }
                    )
                }
            }
        }
    }

}