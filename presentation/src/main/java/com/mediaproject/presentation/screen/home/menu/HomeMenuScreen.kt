package com.mediaproject.presentation.screen.home.menu

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.mediaproject.presentation.screen.vm.HomeMenuViewModel

@Composable
fun HomeMenuScreen(
    modifier: Modifier = Modifier,
    menuViewModel: HomeMenuViewModel = hiltViewModel(),
    onBackPressed: () -> Unit = {},
) = Scaffold(
    topBar = {
        HomeMenuAppBar {
            onBackPressed()
        }
    }
) { padding ->
    val userState = menuViewModel.homeMenuState.observeAsState()
    menuViewModel.getUserInfo()
    menuViewModel.getUserRentingBagsList()
    HomeMenuScreenBody(
        modifier = modifier.padding(padding),
        userState = userState.value!!
    )
}