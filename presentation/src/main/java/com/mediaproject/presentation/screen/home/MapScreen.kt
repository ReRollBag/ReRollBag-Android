package com.mediaproject.presentation.screen.home

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.mediaproject.presentation.common.component.icons.IconPack
import com.mediaproject.presentation.common.component.icons.iconpack.IconLocation
import com.mediaproject.presentation.common.component.icons.iconpack.IconQrScan
import com.mediaproject.presentation.common.component.icons.iconpack.IconRefresh
import com.mediaproject.presentation.common.theme.green1
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MapScreen(
    modifier: Modifier = Modifier,
    qrScanState: String = "",
    clearQrScanState: () -> Unit = {},
    currentLatLng: LatLng = LatLng(0.0, 0.0),
    cameraPositionState: CameraPositionState = CameraPositionState(),
    uiSettings: MapUiSettings = MapUiSettings(),
    properties: MapProperties = MapProperties(),
    onClickQrScan: () -> Unit = {},
) {
    val coroutineScope = rememberCoroutineScope()
    val modalSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = {
            when (it) {
                ModalBottomSheetValue.Hidden -> {
                    clearQrScanState()
                    true
                }
                else -> {
                    it != ModalBottomSheetValue.HalfExpanded
                }
            }
        },
        skipHalfExpanded = true
    )

    var isSheetFullScreen by remember { mutableStateOf(false) }
    val roundedCornerRadius = if (isSheetFullScreen) 0.dp else 12.dp
    val modalModifier = if (isSheetFullScreen)
        Modifier.fillMaxSize()
    else
        Modifier.fillMaxWidth()

    BackHandler(modalSheetState.isVisible) {
        coroutineScope.launch { modalSheetState.hide() }
    }

    LaunchedEffect(qrScanState.isNotEmpty()) {
        if (qrScanState.isNotEmpty()) {
            coroutineScope.launch { modalSheetState.show() }
        }
    }

    ModalBottomSheetLayout(
        sheetState = modalSheetState,
        sheetShape = RoundedCornerShape(topStart = roundedCornerRadius, topEnd = roundedCornerRadius),
        sheetContent = {
            Column(
                modifier = modalModifier,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Button(
                    onClick = {
                        isSheetFullScreen = !isSheetFullScreen
                    }
                ) {
                    Text(text = "Toggle Sheet Fullscreen")
                }

                Button(
                    onClick = { coroutineScope.launch { modalSheetState.hide() } }
                ) {
                    Text(text = "Hide Sheet")
                }
            }
        }
    ) {
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
                    Icon(
                        IconPack.IconLocation,
                        contentDescription = "Location",
                        tint = Color(0xFFFFA338),
                        modifier = Modifier.scale(1.2f)
                    )
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
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            IconPack.IconQrScan,
                            contentDescription = "qr_scan",
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.widthIn(7.dp))
                        Text(
                            text = "QR코드 촬영",
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
}

@Preview(showBackground = true)
@Composable
fun MapScreenPreview() {
    MapScreen()
}