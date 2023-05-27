package com.mediaproject.presentation.screen.user.check

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.mediaproject.presentation.screen.vm.CheckAdminViewModel

@Composable
fun CheckAdminScreen(
    modifier: Modifier = Modifier,
    checkAdminViewModel: CheckAdminViewModel = hiltViewModel(),
    onBackPressed: () -> Unit = {}
) = Scaffold(
    topBar = {
        CheckAdminScreenAppBar {
            onBackPressed()
        }
    }
) { padding ->
    val uiState = checkAdminViewModel.state.observeAsState()
    CheckAdminScreenBody(
        modifier = modifier.padding(padding),
        state = uiState.value!!,
        onChangeRegion = { region -> checkAdminViewModel.onChangeRegion(region) },
        onChangeCertification = { certification -> checkAdminViewModel.onChangeCertification(certification) },
        onClickApply = { checkAdminViewModel.applyAdmin() },
    ) {
        checkAdminViewModel.setUpAdmin()
    }
}

