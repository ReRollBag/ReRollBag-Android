package com.mediaproject.presentation.common.component.icons

import androidx.compose.ui.graphics.vector.ImageVector
import com.mediaproject.presentation.common.component.icons.iconpack.IconArrow
import com.mediaproject.presentation.common.component.icons.iconpack.IconArrowBack
import com.mediaproject.presentation.common.component.icons.iconpack.IconEyeHide
import com.mediaproject.presentation.common.component.icons.iconpack.IconEyeShow
import com.mediaproject.presentation.common.component.icons.iconpack.IconLocation
import com.mediaproject.presentation.common.component.icons.iconpack.IconMenuHamburger
import com.mediaproject.presentation.common.component.icons.iconpack.IconQrScan
import com.mediaproject.presentation.common.component.icons.iconpack.IconRefresh
import com.mediaproject.presentation.common.component.icons.iconpack.IconRefreshList
import com.mediaproject.presentation.common.component.icons.iconpack.IconRent
import com.mediaproject.presentation.common.component.icons.iconpack.IconReturn
import kotlin.collections.List as ____KtList

public object IconPack

private var __AllIcons: ____KtList<ImageVector>? = null

public val IconPack.AllIcons: ____KtList<ImageVector>
  get() {
    if (__AllIcons != null) {
      return __AllIcons!!
    }
    __AllIcons= listOf(IconReturn, IconEyeShow, IconRefresh, IconArrowBack, IconMenuHamburger,
        IconRefreshList, IconQrScan, IconEyeHide, IconLocation, IconRent, IconArrow)
    return __AllIcons!!
  }
