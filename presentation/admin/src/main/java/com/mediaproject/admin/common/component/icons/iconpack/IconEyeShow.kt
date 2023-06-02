package com.mediaproject.admin.common.component.icons.iconpack

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.mediaproject.admin.common.component.icons.IconPack

public val IconPack.IconEyeShow: ImageVector
    get() {
        if (_iconEyeShow != null) {
            return _iconEyeShow!!
        }
        _iconEyeShow = Builder(name = "IconEyeShow", defaultWidth = 18.0.dp, defaultHeight =
                18.0.dp, viewportWidth = 18.0f, viewportHeight = 18.0f).apply {
            group {
                path(fill = SolidColor(Color(0xFF777986)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(16.8101f, 8.765f)
                    curveTo(15.1251f, 5.65f, 12.1701f, 3.765f, 8.9001f, 3.765f)
                    curveTo(5.6301f, 3.765f, 2.6701f, 5.65f, 1.0001f, 8.765f)
                    lineTo(0.8601f, 9.0f)
                    lineTo(0.9901f, 9.24f)
                    curveTo(2.6751f, 12.355f, 5.6301f, 14.24f, 8.9001f, 14.24f)
                    curveTo(12.1701f, 14.24f, 15.1301f, 12.38f, 16.8101f, 9.24f)
                    lineTo(16.9401f, 9.0f)
                    lineTo(16.8101f, 8.765f)
                    close()
                    moveTo(8.9001f, 13.215f)
                    curveTo(6.0851f, 13.215f, 3.5001f, 11.645f, 2.0001f, 9.0f)
                    curveTo(3.5001f, 6.355f, 6.0851f, 4.785f, 8.9001f, 4.785f)
                    curveTo(11.7151f, 4.785f, 14.2701f, 6.36f, 15.7951f, 9.0f)
                    curveTo(14.2701f, 11.645f, 11.7101f, 13.215f, 8.9001f, 13.215f)
                    close()
                }
                path(fill = SolidColor(Color(0xFF777986)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(9.045f, 12.445f)
                    curveTo(10.9393f, 12.445f, 12.475f, 10.9094f, 12.475f, 9.015f)
                    curveTo(12.475f, 7.1207f, 10.9393f, 5.585f, 9.045f, 5.585f)
                    curveTo(7.1507f, 5.585f, 5.615f, 7.1207f, 5.615f, 9.015f)
                    curveTo(5.615f, 10.9094f, 7.1507f, 12.445f, 9.045f, 12.445f)
                    close()
                }
            }
        }
        .build()
        return _iconEyeShow!!
    }

private var _iconEyeShow: ImageVector? = null
