package com.mediaproject.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.google.android.gms.maps.GoogleMapOptions
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

var num = 0

@Composable
fun HomeScreenBody(
    modifier: Modifier = Modifier,
) = Box(
    modifier = modifier
        .fillMaxSize()
        .background(Color.White),
    contentAlignment = Alignment.Center
) {
    if (num == 0) {
        val latLng = LatLng(37.7387295, 127.0458908)
        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(latLng, 15f)
        }
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState,
            googleMapOptionsFactory = {
                val options = GoogleMapOptions()
                options.zoomControlsEnabled(false)
                return@GoogleMap options
            }
        ) {
            Marker(
                state = MarkerState(position = latLng),
                title = "의정부역",
                snippet = "Uijeongbu subway"
            )
        }

        num++
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenBodyPreview() {
    HomeScreenBody()
}