package com.mediaproject.presentation.screen.home.menu

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.mediaproject.presentation.screen.vm.HomeMenuViewModel
import com.mediaproject.presentation.widgets.states.HomeMenuState

@Composable
fun HomeMenuScreen(
    modifier: Modifier = Modifier,
    menuViewModel: HomeMenuViewModel = hiltViewModel(),
    onSignOut: () -> Unit = {},
    onClickRentList: () -> Unit = {},
    onBackPressed: () -> Unit = {},
) = Scaffold(
    topBar = {
        HomeMenuAppBar {
            onBackPressed()
        }
    }
) { padding ->
    val userState = menuViewModel.homeMenuState.observeAsState()

    when (userState.value) {
        is HomeMenuState.SignOut -> onSignOut()
        else -> {
            menuViewModel.getUserInfo().invokeOnCompletion {
                when (it) {
                    null -> menuViewModel.getUserRentingBagsList()
                }
            }

            HomeMenuScreenBody(
                modifier = modifier.padding(padding),
                userState = userState.value!!,
                onClickSignOut = { menuViewModel.signOut() },
                onClickRentList = onClickRentList
            )
        }
    }
}