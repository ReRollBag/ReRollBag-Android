package com.mediaproject.presentation.screen.admin.home

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.rememberCameraPositionState
import com.mediaproject.presentation.R
import com.mediaproject.presentation.screen.admin.finish.FinishReturnedActivity
import com.mediaproject.presentation.screen.vm.AdminMapViewModel
import com.mediaproject.presentation.screen.vm.BagViewModel
import com.mediaproject.presentation.widgets.states.LocationState

@Composable
fun AdminHomeScreen(
    modifier: Modifier = Modifier,
    mapViewModel: AdminMapViewModel = hiltViewModel(),
    bagViewModel: BagViewModel = hiltViewModel(),
    onClickQrScan: () -> Unit = {},
    onClickMenu: () -> Unit = {},
) = Scaffold(
    topBar = {
        AdminHomeScreenAppBar {
            onClickMenu()
        }
    },
) { padding ->
    val context = LocalContext.current
    val uiState = mapViewModel.uiState.observeAsState()
    val qrState = bagViewModel.hasSuccess.observeAsState()

    qrState.value?.let {
        when (it) {
            "return" -> {
                context.startActivity(
                    Intent(context, FinishReturnedActivity::class.java).apply {
                        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    }
                )
            }
            else -> {}
        }
    }

    uiState.value?.let { state ->
        val currentLatLng = when (state.locationState is LocationState.Update) {
            true -> LatLng(state.locationState.location.latitude, state.locationState.location.longitude)
            false -> LatLng(37.2830557, 127.0448373)
        }
        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(currentLatLng, 15f)
        }
        val uiSettings by remember {
            mutableStateOf(
                MapUiSettings(
                    compassEnabled = false,
                    indoorLevelPickerEnabled = false,
                    mapToolbarEnabled = false,
                    myLocationButtonEnabled = false,
                    rotationGesturesEnabled = true,
                    scrollGesturesEnabled = true,
                    scrollGesturesEnabledDuringRotateOrZoom = false,
                    tiltGesturesEnabled = false,
                    zoomControlsEnabled = false,
                    zoomGesturesEnabled = true,
                )
            )
        }
        val properties by remember {
            mutableStateOf(
                MapProperties(
                    mapStyleOptions = MapStyleOptions.loadRawResourceStyle(context, R.raw.style_json)
                )
            )
        }

        Box(
            modifier = modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(padding),
            contentAlignment = Alignment.TopCenter
        ) {
            AdminMapScreen(
                qrScanState = state.qrScanState,
                clearQrScanState = {
                    mapViewModel.clearQrScan()
                },
                onClickRequestReturned = { value ->
                    bagViewModel.requestReturnedBagWithBagId(bagId = value)
                },
                currentLatLng = currentLatLng,
                markerList = state.markerList,
                cameraPositionState = cameraPositionState,
                uiSettings = uiSettings,
                properties = properties,
                onRefreshReturningMarker = {
                    mapViewModel.findAllReturningMarkers()
                }
            ) {
                onClickQrScan()
            }
        }
    }
}
