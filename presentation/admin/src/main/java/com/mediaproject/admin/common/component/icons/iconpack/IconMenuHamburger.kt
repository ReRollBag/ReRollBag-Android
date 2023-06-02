package com.mediaproject.admin.common.component.icons.iconpack

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Round
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.mediaproject.admin.common.component.icons.IconPack

public val IconPack.IconMenuHamburger: ImageVector
    get() {
        if (_iconMenuHamburger != null) {
            return _iconMenuHamburger!!
        }
        _iconMenuHamburger = Builder(name = "IconMenuHamburger", defaultWidth = 18.0.dp,
                defaultHeight = 15.0.dp, viewportWidth = 18.0f, viewportHeight = 15.0f).apply {
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF75A66F)),
                    strokeLineWidth = 2.0f, strokeLineCap = Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(1.125f, 13.375f)
                horizontalLineTo(16.875f)
                moveTo(1.125f, 7.375f)
                horizontalLineTo(16.875f)
                moveTo(1.125f, 1.375f)
                horizontalLineTo(16.875f)
            }
        }
        .build()
        return _iconMenuHamburger!!
    }

private var _iconMenuHamburger: ImageVector? = null
