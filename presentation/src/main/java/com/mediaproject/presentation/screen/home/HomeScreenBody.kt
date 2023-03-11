package com.mediaproject.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
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

@Composable
fun HomeScreenBody(
    modifier: Modifier = Modifier,
    onClickQrScan: () -> Unit = {},
) = Box(
    modifier = modifier
        .fillMaxSize()
        .background(Color.White),
    contentAlignment = Alignment.Center
) {
    val context = LocalContext.current
    var latLng = LatLng(37.7387295, 127.0458908)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(latLng, 15f)
    }
    var uiSettings by remember {
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
    var properties by remember {
        mutableStateOf(
            MapProperties(
                isMyLocationEnabled = true,
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
            Marker(
                state = MarkerState(position = latLng),
                title = "의정부역",
                snippet = "Uijeongbu subway"
            )
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