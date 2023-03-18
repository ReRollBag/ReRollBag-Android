package com.mediaproject.presentation.common.component.icons.iconpack

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeCap.Companion.Round
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.mediaproject.presentation.common.component.icons.IconPack

public val IconPack.IconReturn: ImageVector
    get() {
        if (_iconReturn != null) {
            return _iconReturn!!
        }
        _iconReturn = Builder(name = "IconReturn", defaultWidth = 22.0.dp, defaultHeight = 22.0.dp,
                viewportWidth = 22.0f, viewportHeight = 22.0f).apply {
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF777986)),
                    strokeLineWidth = 2.0f, strokeLineCap = Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(1.8333f, 11.0f)
                curveTo(1.8333f, 12.2038f, 2.0704f, 13.3958f, 2.5311f, 14.5079f)
                curveTo(2.9918f, 15.6201f, 3.667f, 16.6306f, 4.5182f, 17.4818f)
                curveTo(5.3694f, 18.333f, 6.3799f, 19.0082f, 7.4921f, 19.4689f)
                curveTo(8.6042f, 19.9296f, 9.7962f, 20.1667f, 11.0f, 20.1667f)
                curveTo(12.2038f, 20.1667f, 13.3958f, 19.9296f, 14.5079f, 19.4689f)
                curveTo(15.6201f, 19.0082f, 16.6306f, 18.333f, 17.4818f, 17.4818f)
                curveTo(18.333f, 16.6306f, 19.0082f, 15.6201f, 19.4689f, 14.5079f)
                curveTo(19.9295f, 13.3958f, 20.1666f, 12.2038f, 20.1666f, 11.0f)
                curveTo(20.1666f, 9.7962f, 19.9295f, 8.6042f, 19.4689f, 7.4921f)
                curveTo(19.0082f, 6.3799f, 18.333f, 5.3694f, 17.4818f, 4.5182f)
                curveTo(16.6306f, 3.667f, 15.6201f, 2.9918f, 14.5079f, 2.5311f)
                curveTo(13.3958f, 2.0704f, 12.2038f, 1.8333f, 11.0f, 1.8333f)
                curveTo(9.7962f, 1.8333f, 8.6042f, 2.0704f, 7.4921f, 2.5311f)
                curveTo(6.3799f, 2.9918f, 5.3694f, 3.667f, 4.5182f, 4.5182f)
                curveTo(3.667f, 5.3694f, 2.9918f, 6.3799f, 2.5311f, 7.4921f)
                curveTo(2.0704f, 8.6042f, 1.8333f, 9.7962f, 1.8333f, 11.0f)
                close()
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF777986)),
                    strokeLineWidth = 2.0f, strokeLineCap = Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(8.9629f, 11.0f)
                horizontalLineTo(11.0f)
                curveTo(11.5402f, 11.0f, 12.0584f, 10.7854f, 12.4404f, 10.4034f)
                curveTo(12.8224f, 10.0213f, 13.037f, 9.5032f, 13.037f, 8.963f)
                curveTo(13.037f, 8.4227f, 12.8224f, 7.9046f, 12.4404f, 7.5226f)
                curveTo(12.0584f, 7.1405f, 11.5402f, 6.9259f, 11.0f, 6.9259f)
                horizontalLineTo(8.9629f)
                verticalLineTo(15.0741f)
                moveTo(13.037f, 15.0741f)
                lineTo(9.9815f, 11.0f)
            }
        }
        .build()
        return _iconReturn!!
    }

private var _iconReturn: ImageVector? = null
