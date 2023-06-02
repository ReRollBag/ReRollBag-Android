package com.mediaproject.presentation.common.component.icons.iconpack

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.mediaproject.presentation.common.component.icons.IconPack

public val IconPack.IconQrScan: ImageVector
    get() {
        if (_iconQrScan != null) {
            return _iconQrScan!!
        }
        _iconQrScan = Builder(name = "IconQrScan", defaultWidth = 16.0.dp, defaultHeight = 16.0.dp,
                viewportWidth = 16.0f, viewportHeight = 16.0f).apply {
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(10.5f, 0.5f)
                horizontalLineTo(15.5f)
                verticalLineTo(4.6667f)
                horizontalLineTo(13.8333f)
                verticalLineTo(2.1667f)
                horizontalLineTo(10.5f)
                verticalLineTo(0.5f)
                close()
                moveTo(5.5f, 0.5f)
                verticalLineTo(2.1667f)
                horizontalLineTo(2.1667f)
                verticalLineTo(4.6667f)
                horizontalLineTo(0.5f)
                verticalLineTo(0.5f)
                horizontalLineTo(5.5f)
                close()
                moveTo(10.5f, 15.5f)
                verticalLineTo(13.8333f)
                horizontalLineTo(13.8333f)
                verticalLineTo(11.3333f)
                horizontalLineTo(15.5f)
                verticalLineTo(15.5f)
                horizontalLineTo(10.5f)
                close()
                moveTo(5.5f, 15.5f)
                horizontalLineTo(0.5f)
                verticalLineTo(11.3333f)
                horizontalLineTo(2.1667f)
                verticalLineTo(13.8333f)
                horizontalLineTo(5.5f)
                verticalLineTo(15.5f)
                close()
                moveTo(0.5f, 7.1667f)
                horizontalLineTo(15.5f)
                verticalLineTo(8.8333f)
                horizontalLineTo(0.5f)
                verticalLineTo(7.1667f)
                close()
            }
        }
        .build()
        return _iconQrScan!!
    }

private var _iconQrScan: ImageVector? = null
