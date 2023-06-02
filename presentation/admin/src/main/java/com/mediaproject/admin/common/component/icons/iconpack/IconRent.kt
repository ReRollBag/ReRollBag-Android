package com.mediaproject.admin.common.component.icons.iconpack

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.mediaproject.admin.common.component.icons.IconPack

public val IconPack.IconRent: ImageVector
    get() {
        if (_iconRent != null) {
            return _iconRent!!
        }
        _iconRent = Builder(name = "IconRent", defaultWidth = 20.0.dp, defaultHeight = 18.0.dp,
                viewportWidth = 20.0f, viewportHeight = 18.0f).apply {
            path(fill = SolidColor(Color(0xFF777986)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(17.5625f, 4.1563f)
                horizontalLineTo(14.4541f)
                curveTo(14.3634f, 3.0372f, 13.8548f, 1.9934f, 13.0295f, 1.2322f)
                curveTo(12.2042f, 0.4711f, 11.1227f, 0.0486f, 10.0f, 0.0486f)
                curveTo(8.8773f, 0.0486f, 7.7958f, 0.4711f, 6.9705f, 1.2322f)
                curveTo(6.1452f, 1.9934f, 5.6366f, 3.0372f, 5.5459f, 4.1563f)
                horizontalLineTo(2.4375f)
                curveTo(1.9817f, 4.1563f, 1.5445f, 4.3373f, 1.2222f, 4.6597f)
                curveTo(0.8998f, 4.982f, 0.7188f, 5.4192f, 0.7188f, 5.875f)
                verticalLineTo(16.1875f)
                curveTo(0.7188f, 16.6433f, 0.8998f, 17.0805f, 1.2222f, 17.4028f)
                curveTo(1.5445f, 17.7252f, 1.9817f, 17.9062f, 2.4375f, 17.9062f)
                horizontalLineTo(17.5625f)
                curveTo(18.0183f, 17.9062f, 18.4555f, 17.7252f, 18.7778f, 17.4028f)
                curveTo(19.1002f, 17.0805f, 19.2812f, 16.6433f, 19.2812f, 16.1875f)
                verticalLineTo(5.875f)
                curveTo(19.2812f, 5.4192f, 19.1002f, 4.982f, 18.7778f, 4.6597f)
                curveTo(18.4555f, 4.3373f, 18.0183f, 4.1563f, 17.5625f, 4.1563f)
                close()
                moveTo(10.0f, 2.0938f)
                curveTo(10.5786f, 2.0938f, 11.1378f, 2.3023f, 11.5751f, 2.6811f)
                curveTo(12.0125f, 3.0599f, 12.2987f, 3.5836f, 12.3813f, 4.1563f)
                horizontalLineTo(7.6187f)
                curveTo(7.7013f, 3.5836f, 7.9875f, 3.0599f, 8.4249f, 2.6811f)
                curveTo(8.8622f, 2.3023f, 9.4214f, 2.0938f, 10.0f, 2.0938f)
                close()
                moveTo(17.2188f, 15.8438f)
                horizontalLineTo(2.7813f)
                verticalLineTo(6.2188f)
                horizontalLineTo(5.5313f)
                verticalLineTo(7.25f)
                curveTo(5.5313f, 7.5235f, 5.6399f, 7.7858f, 5.8333f, 7.9792f)
                curveTo(6.0267f, 8.1726f, 6.289f, 8.2813f, 6.5625f, 8.2813f)
                curveTo(6.836f, 8.2813f, 7.0983f, 8.1726f, 7.2917f, 7.9792f)
                curveTo(7.4851f, 7.7858f, 7.5938f, 7.5235f, 7.5938f, 7.25f)
                verticalLineTo(6.2188f)
                horizontalLineTo(12.4062f)
                verticalLineTo(7.25f)
                curveTo(12.4062f, 7.5235f, 12.5149f, 7.7858f, 12.7083f, 7.9792f)
                curveTo(12.9017f, 8.1726f, 13.164f, 8.2813f, 13.4375f, 8.2813f)
                curveTo(13.711f, 8.2813f, 13.9733f, 8.1726f, 14.1667f, 7.9792f)
                curveTo(14.3601f, 7.7858f, 14.4688f, 7.5235f, 14.4688f, 7.25f)
                verticalLineTo(6.2188f)
                horizontalLineTo(17.2188f)
                verticalLineTo(15.8438f)
                close()
            }
        }
        .build()
        return _iconRent!!
    }

private var _iconRent: ImageVector? = null
