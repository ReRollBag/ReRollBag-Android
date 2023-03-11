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
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState,
            uiSettings = uiSettings,
            properties = properties,
        ) {
//            Marker(
//                state = MarkerState(position = currentLatLng),
//                title = "현재 위치",
//                snippet = "current set up"
//            )
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(horizontal = 20.dp)
                .padding(bottom = 24.dp),
            verticalArrangement = Arrangement.Bottom,
        ) {
            Button(
                modifier = Modifier.size(50.dp),
                onClick = {
                    cameraPositionState.position = CameraPosition.fromLatLngZoom(currentLatLng, 15f)
                },
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
            ) {
                Icon(IconPack.IconLocation, contentDescription = "Location")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    modifier = Modifier.size(50.dp),
                    onClick = {

                    },
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                ) {
//                    Icon(IconPack.IconLocation, contentDescription = "Location")
                }
                Button(
                    modifier = Modifier.size(50.dp),
                    onClick = {

                    },
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                ) {
                    Icon(IconPack.IconRefresh, contentDescription = "refresh")
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 46.dp),
                onClick = {
                    onClickQrScan()
//                    cameraPositionState.position = CameraPosition.fromLatLngZoom(latLng, 15f)
                },
                shape = RoundedCornerShape(30),
                colors = ButtonDefaults.buttonColors(backgroundColor = green1)
            ) {
                Row(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        IconPack.IconQrScan,
                        contentDescription = "qr_scan",
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.widthIn(7.dp))
                    Text(
                        text = "가방 대여하기",
                        style = TextStyle(
//                    fontFamily = notoSansFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = Color.White,
                        ),
                    )
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenBodyPreview() {
    HomeScreenBody()
}