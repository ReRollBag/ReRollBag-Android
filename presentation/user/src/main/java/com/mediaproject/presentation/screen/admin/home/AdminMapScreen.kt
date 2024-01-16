package com.mediaproject.presentation.screen.admin.home

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
import com.mediaproject.core.model.ReRollBagMarker
import com.mediaproject.core.model.ReturningMarker
import com.mediaproject.presentation.R
import com.mediaproject.presentation.common.component.icons.IconPack
import com.mediaproject.presentation.common.component.icons.iconpack.*
import com.mediaproject.presentation.common.theme.green1
import com.mediaproject.presentation.widgets.states.QrScanState
import kotlinx.coroutines.launch

@SuppressLint(
    "UnusedMaterialScaffoldPaddingParameter",
    "CoroutineCreationDuringComposition"
)
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AdminMapScreen(
    modifier: Modifier = Modifier,
    qrScanState: QrScanState = QrScanState.Init,
    clearQrScanState: () -> Unit = {},
    onClickRequestReturned: (bagId: String) -> Unit = {},
    currentLatLng: LatLng = LatLng(0.0, 0.0),
    markerList: List<ReRollBagMarker> = listOf(),
    cameraPositionState: CameraPositionState = CameraPositionState(),
    uiSettings: MapUiSettings = MapUiSettings(),
    properties: MapProperties = MapProperties(),
    onRefreshReturningMarker: () -> Unit = {},
    onClickQrScan: () -> Unit = {},
) {
    val coroutineScope = rememberCoroutineScope()
    val selectedMarker: MutableState<ReRollBagMarker?> = remember{ mutableStateOf(null) }
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

    BackHandler(modalSheetState.isVisible) {
        coroutineScope.launch { modalSheetState.hide() }
    }

    qrScanState.bagInfo?.let { bagInfo ->
        when (bagInfo.bagsId) {
            "-1" -> {
                AdminCancelDialog(clearQrScanState = clearQrScanState)
            }
            else -> {
                AdminReturningBagItemDialog(
                    bagInfo = bagInfo,
                    clearQrScanState = clearQrScanState,
                    onClickReturnedBag = onClickRequestReturned
                )
            }
        }
    }

    ModalBottomSheetLayout(
        sheetState = modalSheetState,
        sheetShape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
        sheetContent = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                if (selectedMarker.value == null) {
                    Spacer(modifier = modifier.height(10.dp))
                }
                selectedMarker.value?.let {
                    when (it) {
                        is com.mediaproject.core.model.ReturningMarker -> {
                            AdminReturningModalItemView(
                                marker = it,
                                onClickQrScan = onClickQrScan,
                            )
                            Spacer(modifier = modifier.height(10.dp))
                        }
                    }
                }
            }
        }
    ) {
        InnerAdminMapView(
            currentLatLng = currentLatLng,
            cameraPositionState = cameraPositionState,
            uiSettings = uiSettings,
            properties = properties,
            markerList = markerList,
            onClickMarker = { marker ->
                selectedMarker.value = marker
                coroutineScope.launch { modalSheetState.show() }
            },
            onRefreshReturningMarker = onRefreshReturningMarker,
            onClickQrScan = onClickQrScan,
        )
    }
}

@Composable
fun InnerAdminMapView(
    modifier: Modifier = Modifier,
    currentLatLng: LatLng = LatLng(0.0, 0.0),
    cameraPositionState: CameraPositionState = CameraPositionState(),
    uiSettings: MapUiSettings = MapUiSettings(),
    properties: MapProperties = MapProperties(),
    markerList: List<ReRollBagMarker> = listOf(),
    onClickMarker: (marker: ReRollBagMarker) -> Unit = {},
    onRefreshReturningMarker: () -> Unit = {},
    onClickQrScan: () -> Unit = {},
) = Box(
    modifier = modifier.fillMaxSize()
) {
    val context = LocalContext.current
    val icon = bitmapDescriptorFromVector(
        context = context,
        vectorResId = R.drawable.icon_marker_return
    )

    LaunchedEffect(true) {
        onRefreshReturningMarker()
    }

    GoogleMap(
        modifier = modifier,
        cameraPositionState = cameraPositionState,
        uiSettings = uiSettings,
        properties = properties,
    ) {
        markerList.forEach { info ->
            Marker(
                state = MarkerState(position = LatLng(info.latitude, info.longitude)),
                icon = icon,
                onClick = {
                    onClickMarker(info)
                    false
                }
            )
        }
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
                onClick = {},
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFF3CA5FF)
                )
            ) {
                Icon(
                    IconPack.IconReturn,
                    contentDescription = "return",
                    modifier = Modifier.scale(1.4f),
                    tint = Color.White
                )
            }
            Button(
                modifier = Modifier.size(50.dp),
                onClick = {
                    onRefreshReturningMarker()
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
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Color.White,
                    ),
                )
            }
        }
    }
}

private fun bitmapDescriptorFromVector(
    context: Context,
    vectorResId: Int
): BitmapDescriptor? {
    val drawable = ContextCompat.getDrawable(context, vectorResId) ?: return null
    drawable.setBounds(0, 0, drawable.intrinsicWidth, drawable.intrinsicHeight)

    val bm = Bitmap.createBitmap(
        drawable.intrinsicWidth,
        drawable.intrinsicHeight,
        Bitmap.Config.ARGB_8888
    )

    val canvas = android.graphics.Canvas(bm)
    drawable.draw(canvas)
    return BitmapDescriptorFactory.fromBitmap(bm)
}

@Preview(showBackground = true)
@Composable
fun AdminMapScreenPreview() {
    Column {
        InnerAdminMapView()
    }
}