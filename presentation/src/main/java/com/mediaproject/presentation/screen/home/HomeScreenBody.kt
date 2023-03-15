package com.mediaproject.presentation.screen.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions.loadRawResourceStyle
import com.google.maps.android.compose.*
import com.mediaproject.presentation.R
import com.mediaproject.presentation.common.component.icons.IconPack
import com.mediaproject.presentation.common.component.icons.iconpack.IconLocation
import com.mediaproject.presentation.common.component.icons.iconpack.IconQrScan
import com.mediaproject.presentation.common.component.icons.iconpack.IconRefresh
import com.mediaproject.presentation.common.theme.green1
import com.mediaproject.presentation.widgets.states.LocationState

@Composable
fun HomeScreenBody(
    modifier: Modifier = Modifier,
    locationState: LocationState? = LocationState.Init,
    qrScanState: String? = "",
    clearQrScanState: () -> Unit = {},
    onClickQrScan: () -> Unit = {},
) = Box(
    modifier = modifier
        .fillMaxSize()
        .background(Color.White),
    contentAlignment = Alignment.Center
) {
    val context = LocalContext.current

    val currentLatLng = when (locationState is LocationState.Update) {
        true -> LatLng(locationState.location.latitude, locationState.location.longitude)
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
                mapStyleOptions = loadRawResourceStyle(context, R.raw.style_json)
            )
        )
    }

    MapScreen(
        qrScanState = if ((qrScanState ?: "").isEmpty()) "" else qrScanState!!,
        clearQrScanState = clearQrScanState,
        currentLatLng = currentLatLng,
        cameraPositionState = cameraPositionState,
        uiSettings = uiSettings,
        properties = properties,
    ) {
        onClickQrScan()
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenBodyPreview() {
    HomeScreenBody()
}