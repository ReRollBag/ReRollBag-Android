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
import kotlin.collections.List as ____KtList

object IconPack

private var __AlIcons: ____KtList<ImageVector>? = null

public val IconPack.AlIcons: ____KtList<ImageVector>
  get() {
    if (__AlIcons != null) {
      return __AlIcons!!
    }
    __AlIcons= listOf(IconEyeShow, IconRefresh, IconArrowBack, IconMenuHamburger, IconQrScan,
        IconEyeHide, IconLocation, IconArrow)
    return __AlIcons!!
  }
