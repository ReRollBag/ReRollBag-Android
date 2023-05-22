package com.mediaproject.admin.screen.landing

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.GoogleAuthProvider
import com.mediaproject.admin.common.nav.LandingNavGraph
import com.mediaproject.admin.screen.vm.SignInViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LandingActivity : ComponentActivity() {

    @Inject lateinit var googleSignInClient: GoogleSignInClient

    private val viewModel: SignInViewModel by viewModels()

    lateinit var getResult: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.isAlreadyLogin()
        getResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            when(it.resultCode) {
                AppCompatActivity.RESULT_OK -> {
                    val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
                    handleSignInResult(task)
                }
                else -> {
                    viewModel.throwError(error = Exception())
                }
            }
        }

        setContent {
            val navController = rememberNavController()
            LandingNavGraph(
                navController = navController,
                context = applicationContext,
                viewModel = viewModel,
                googleSignIn = { getResult.launch(googleSignInClient.signInIntent) }
            )
        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account  = completedTask.getResult(ApiException::class.java)
            val credential = GoogleAuthProvider.getCredential(account.idToken, null)
            viewModel.signIn(credential)
            googleSignInClient.signOut()
        } catch (e: Exception){
            viewModel.throwError(error = e)
        }
    }

}