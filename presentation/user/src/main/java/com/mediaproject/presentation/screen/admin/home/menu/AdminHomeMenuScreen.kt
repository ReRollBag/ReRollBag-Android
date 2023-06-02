package com.mediaproject.presentation.screen.admin.home.menu

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.mediaproject.presentation.screen.vm.AdminHomeMenuViewModel
import com.mediaproject.presentation.widgets.states.AdminHomeMenuState

@Composable
fun AdminHomeMenuScreen(
    modifier: Modifier = Modifier,
    menuViewModel: AdminHomeMenuViewModel = hiltViewModel(),
    onClickNotice: () -> Unit = {},
    onClickBag: () -> Unit = {},
    onClickRentMarker: () -> Unit = {},
    onClickReturnedMarker: () -> Unit = {},
    onSignOut: () -> Unit = {},
    onBackPressed: () -> Unit = {},
) = Scaffold(
    topBar = {
        AdminHomeMenuAppBar {
            onBackPressed()
        }
    }
) { padding ->
    val userState = menuViewModel.homeMenuState.observeAsState()

    when (userState.value) {
        is AdminHomeMenuState.SignOut -> onSignOut()
        else -> {
            LaunchedEffect(true) {
                menuViewModel.getUserInfo().invokeOnCompletion {
//                    when (it) {
//                        null -> menuViewModel.getUserBagsList()
//                    }
                }
            }

            AdminHomeMenuScreenBody(
                modifier = modifier.padding(padding),
                userState = userState.value!!,
                onClickNotice = onClickNotice,
                onClickBag = onClickBag,
                onClickRentMarker = onClickRentMarker,
                onClickReturnedMarker = onClickReturnedMarker,
                onClickSignOut = { menuViewModel.signOut() },
            )
        }
    }
}