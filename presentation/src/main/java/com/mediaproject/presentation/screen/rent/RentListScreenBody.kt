package com.mediaproject.presentation.screen.rent

import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedButton
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

@Composable
fun RentListScreenBody(
    modifier: Modifier = Modifier,
) = Column(
    modifier = modifier.fillMaxSize()
) {
    RentListMenuBar()
}

@Composable
fun RentListMenuBar(
    modifier: Modifier = Modifier
) = Row(
    modifier = modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically
) {
    val kinds = listOf("전체", "반납", "대기중")
    val (selected, setSelected) = remember { mutableStateOf("") }
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        kinds.forEach { item ->
            OutlinedButton(
                onClick = {

                }
            ) {

            }
        }

//        Column(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            kinds.forEach { item ->
//                Row(
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    RadioButton(
//                        selected = selected == item,
//                        onClick = {
//                            setSelected(item)
//                        },
//                        enabled = true,
//                        colors = RadioButtonDefaults.colors(
//                            selectedColor = Color.Magenta
//                        )
//                    )
//                    Text(text = item, modifier = Modifier.padding(start = 8.dp))
//                }
//            }
//        }
    }
}

@Preview(showBackground = true)
@Composable
fun RentListScreenBodyPreview() {
    RentListScreenBody()
}