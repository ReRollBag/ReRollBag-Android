package com.mediaproject.admin.screen.finish

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mediaproject.admin.common.theme.ReRollBagTheme
import com.mediaproject.admin.screen.home.HomeActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FinishReturnActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ReRollBagTheme {
                FinishReturnScreen {
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