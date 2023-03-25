package com.mediaproject.presentation.screen.home

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
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
import com.mediaproject.presentation.screen.vm.BagViewModel
import com.mediaproject.presentation.screen.vm.MapViewModel
import com.mediaproject.presentation.widgets.states.LocationState
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.google.maps.android.compose.*
import com.mediaproject.domain.model.NoticeInfo
import com.mediaproject.presentation.screen.finish.FinishRentActivity
import com.mediaproject.presentation.screen.finish.FinishReturnActivity
import com.mediaproject.presentation.screen.vm.NoticeViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    mapViewModel: MapViewModel = hiltViewModel(),
    bagViewModel: BagViewModel = hiltViewModel(),
    noticeViewModel: NoticeViewModel = hiltViewModel(),
    onClickQrScan: () -> Unit = {},
    onClickNotice: () -> Unit = {},
    onClickMenu: () -> Unit = {},
) = Scaffold(
    topBar = {
        HomeScreenAppBar {
            onClickMenu()
        }
    },
) { padding ->
    val context = LocalContext.current
    val uiState = mapViewModel.uiState.observeAsState()
    val qrState = bagViewModel.hasSuccess.observeAsState()
    val noticeState = noticeViewModel.noticeState.observeAsState()

    LaunchedEffect(true) {
        noticeViewModel.getNoticeByLastUpdated()
    }

    qrState.value?.let {
        when (it) {
            "rent" -> {
                context.startActivity(
                    Intent(context, FinishRentActivity::class.java).apply {
                        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    }
                )
            }
            "return" -> {
                context.startActivity(
                    Intent(context, FinishReturnActivity::class.java).apply {
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
            MapScreen(
                qrScanState = state.qrScanState,
                clearQrScanState = {
                    mapViewModel.clearQrScan()
                },
                onClickRentBag = { value ->
                    bagViewModel.rentBagWithBagId(bagId = value)
                    mapViewModel.clearQrScan()
                },
                onClickRequestReturning = { value ->
                    bagViewModel.requestReturningBagWithBagId(bagId = value)
                },
                currentLatLng = currentLatLng,
                markerList = state.markerList,
                isRent = state.isRentState,
                onChangeRent = { value ->
                    mapViewModel.updateIsRent(isRent = value)
                },
                cameraPositionState = cameraPositionState,
                uiSettings = uiSettings,
                properties = properties,
                onRefreshRentingMarker = {
                    mapViewModel.findAllRentingMarkers()
                },
                onRefreshReturningMarker = {
                    mapViewModel.findAllReturningMarkers()
                }
            ) {
                onClickQrScan()
            }

            noticeState.value?.lastUpdatedNotice?.let { notice ->
                HomeNoticeScreen(noticeInfo = notice) {
                    onClickNotice()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenBodyPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.TopCenter
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
                .background(Color.Black)
        ) {

        }
        HomeNoticeScreen(
            noticeInfo = NoticeInfo(
                title = "지구방위대가 된 걸 환영합니다! 함께 지구를 지켜가요.",
                content = "testContent",
                createdAt = "2023-03-25T09:02:31.516",
                updatedAt = "2023-03-25T09:02:31.516",
            )
        )
    }
}
