package com.mediaproject.presentation.screen.user.home

import android.Manifest
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.maps.MapsInitializer
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanOptions
import com.mediaproject.presentation.common.nav.UserHomeNavGraph
import com.mediaproject.presentation.common.theme.ReRollBagTheme
import com.mediaproject.presentation.screen.vm.MapViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserHomeActivity : ComponentActivity() {

    private val mapViewModel: MapViewModel by viewModels()

    private lateinit var locationManager: LocationManager
    private lateinit var myLocationListener: MyLocationListener

    private val locationPermissions = arrayOf(
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION
    )

    private val permissionLauncher = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
        val responsePermissions = permissions.entries.filter {
            it.key in locationPermissions
        }

        if (responsePermissions.filter { it.value }.size == locationPermissions.size) {
            setLocationListener()
        } else {
            Toast.makeText(this, "권한 거부", Toast.LENGTH_SHORT).show()
        }
    }

    private val barcodeLauncher: ActivityResultLauncher<ScanOptions> = registerForActivityResult(
        ScanContract()
    ) { result ->
        when (result.contents) {
            null -> {
                Log.d("TAG", "contents is null")
                mapViewModel.updateCanceledQr()
            }
            else -> {
                Log.d("TAG", result.contents)
                mapViewModel.updateQrScanUrl(result.contents)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapsInitializer.initialize(applicationContext)
        getMyLocation()
        setContent {
            ReRollBagTheme {
                val navController = rememberNavController()
                UserHomeNavGraph(
                    navController = navController,
                    context = applicationContext,
                ) {
                    val option = ScanOptions().apply {
                        setBeepEnabled(false)
                        setOrientationLocked(false)
                        setPrompt("QR 코드를 찍어주세요.")
                    }
                    barcodeLauncher.launch(option)
                }
            }
        }

    }

    private fun getMyLocation() {
        if (::locationManager.isInitialized.not()) {
            locationManager = this.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        }
        val isGpsEnable = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        if (isGpsEnable) {
            permissionLauncher.launch(locationPermissions)
        }
    }

    @Suppress("MissingPermission")
    private fun setLocationListener() {
        val minTime: Long = 1500
        val minDistance = 100f

        if (::myLocationListener.isInitialized.not()) {
            myLocationListener = MyLocationListener()
        }

        with(locationManager) {
            requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                minTime, minDistance, myLocationListener
            )

            requestLocationUpdates(
                LocationManager.NETWORK_PROVIDER,
                minTime, minDistance, myLocationListener
            )
        }
    }

    inner class MyLocationListener : LocationListener {
        override fun onLocationChanged(location: Location) {
//            removeLocationListener()
            Log.d("TAG", "location change la = ${location.latitude}, lo = ${location.longitude}")
            mapViewModel.updateLocation(location = location)
        }

        private fun removeLocationListener() {
            if (::locationManager.isInitialized && ::myLocationListener.isInitialized) {
                locationManager.removeUpdates(myLocationListener)
            }
        }
    }

}