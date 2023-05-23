package com.mediaproject.presentation.screen.user.home.menu

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.mediaproject.presentation.screen.vm.HomeMenuViewModel
import com.mediaproject.presentation.widgets.states.HomeMenuState

@Composable
fun UserHomeMenuScreen(
    modifier: Modifier = Modifier,
    menuViewModel: HomeMenuViewModel = hiltViewModel(),
    onSignOut: () -> Unit = {},
    onClickRentList: () -> Unit = {},
    onClickNotice: () -> Unit = {},
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
            LaunchedEffect(true) {
                menuViewModel.getUserInfo().invokeOnCompletion {
                    when (it) {
                        null -> menuViewModel.getUserRentingBagsList()
                    }
                }
            }

            UserHomeMenuScreenBody(
                modifier = modifier.padding(padding),
                userState = userState.value!!,
                onClickSignOut = { menuViewModel.signOut() },
                onClickRefreshList = { menuViewModel.getUserRentingBagsList() },
                onClickRentList = onClickRentList,
                onClickNotice = onClickNotice,
            )
        }
    }
}