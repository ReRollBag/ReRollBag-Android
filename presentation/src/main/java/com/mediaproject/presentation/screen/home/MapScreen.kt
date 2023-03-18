package com.mediaproject.presentation.screen.home

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
import com.mediaproject.presentation.R
import com.mediaproject.presentation.common.component.icons.IconPack
import com.mediaproject.presentation.common.component.icons.iconpack.*
import com.mediaproject.presentation.common.theme.green1
import kotlinx.coroutines.launch

@SuppressLint(
    "UnusedMaterialScaffoldPaddingParameter",
    "CoroutineCreationDuringComposition"
)
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MapScreen(
    modifier: Modifier = Modifier,
    qrScanState: String = "",
    clearQrScanState: () -> Unit = {},
    onClickRentBag: (bagId: String) -> Unit = {},
    onClickRequestRenting: (bagId: String) -> Unit = {},
    currentLatLng: LatLng = LatLng(0.0, 0.0),
    isRent: Boolean = true,
    onChangeRent: (value: Boolean) -> Unit = {},
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

    BackHandler(modalSheetState.isVisible) {
        coroutineScope.launch { modalSheetState.hide() }
    }

    if (qrScanState.isNotEmpty()) {
        when (isRent) {
            true -> {
                RentItemView(
                    bagId = qrScanState,
                    clearQrScanState = clearQrScanState,
                    onClickRentBag = onClickRentBag
                )
            }
            false -> coroutineScope.launch { modalSheetState.show() }
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
                ReturningItemView(
                    bagId = qrScanState,
                    onClickRequestRenting = onClickRequestRenting
                )
            }
        }
    ) {
        InnerMapView(
            onChangeRent = onChangeRent,
            isRent = isRent,
            currentLatLng = currentLatLng,
            cameraPositionState = cameraPositionState,
            uiSettings = uiSettings,
            properties = properties,
            onClickQrScan = onClickQrScan,
        )
    }
}

@Composable
fun InnerMapView(
    modifier: Modifier = Modifier,
    currentLatLng: LatLng = LatLng(0.0, 0.0),
    isRent: Boolean = true,
    onChangeRent: (value: Boolean) -> Unit = {},
    cameraPositionState: CameraPositionState = CameraPositionState(),
    uiSettings: MapUiSettings = MapUiSettings(),
    properties: MapProperties = MapProperties(),
    onClickQrScan: () -> Unit = {},
) = Box(
    modifier = modifier.fillMaxSize()
) {
    val context = LocalContext.current
    val icon = when (isRent) {
        true -> bitmapDescriptorFromVector(
            context = context,
            vectorResId = R.drawable.icon_marker_bag
        )
        false -> bitmapDescriptorFromVector(
            context = context,
            vectorResId = R.drawable.icon_marker_return
        )
    }
    GoogleMap(
        modifier = modifier,
        cameraPositionState = cameraPositionState,
        uiSettings = uiSettings,
        properties = properties,
    ) {
        Marker(
            state = MarkerState(position = currentLatLng),
            icon = icon
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
                    onChangeRent(!isRent)
                },
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = when (isRent) {
                        true -> Color(0xFF3CA5FF)
                        false -> Color.White
                    }
                )
            ) {
                when (isRent) {
                    true -> Icon(
                        IconPack.IconReturn,
                        contentDescription = "rent",
                        modifier = Modifier.scale(1.4f),
                        tint = Color.White
                    )
                    false -> Icon(
                        IconPack.IconRent,
                        contentDescription = "rent"
                    )
                }
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
fun MapScreenPreview() {
    Column {
        InnerMapView(isRent = false)
    }
}