package com.mediaproject.presentation.common.component.icons.iconpack

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.mediaproject.presentation.common.component.icons.IconPack

public val IconPack.IconEyeHide: ImageVector
    get() {
        if (_iconEyeHide != null) {
            return _iconEyeHide!!
        }
        _iconEyeHide = Builder(name = "IconEyeHide", defaultWidth = 18.0.dp, defaultHeight =
                18.0.dp, viewportWidth = 18.0f, viewportHeight = 18.0f).apply {
            group {
                path(fill = SolidColor(Color(0xFF777986)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(9.185f, 5.585f)
                    curveTo(8.7803f, 5.5855f, 8.379f, 5.6583f, 8.0f, 5.8f)
                    lineTo(12.4f, 10.2f)
                    curveTo(12.5436f, 9.8163f, 12.6164f, 9.4097f, 12.615f, 9.0f)
                    curveTo(12.611f, 8.0929f, 12.2479f, 7.2243f, 11.6051f, 6.5843f)
                    curveTo(10.9623f, 5.9443f, 10.0921f, 5.585f, 9.185f, 5.585f)
                    close()
                }
                path(fill = SolidColor(Color(0xFF777986)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(17.145f, 8.765f)
                    curveTo(15.46f, 5.65f, 12.505f, 3.765f, 9.235f, 3.765f)
                    curveTo(8.3447f, 3.7671f, 7.4603f, 3.9106f, 6.615f, 4.19f)
                    lineTo(7.42f, 5.0f)
                    curveTo(8.0129f, 4.8468f, 8.6226f, 4.7678f, 9.235f, 4.765f)
                    curveTo(12.05f, 4.765f, 14.61f, 6.335f, 16.135f, 8.98f)
                    curveTo(15.5756f, 9.9613f, 14.834f, 10.8268f, 13.95f, 11.53f)
                    lineTo(14.66f, 12.24f)
                    curveTo(15.683f, 11.4147f, 16.5327f, 10.3951f, 17.16f, 9.24f)
                    lineTo(17.29f, 9.0f)
                    lineTo(17.145f, 8.765f)
                    close()
                }
                path(fill = SolidColor(Color(0xFF777986)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(2.4349f, 2.89f)
                    lineTo(4.6649f, 5.12f)
                    curveTo(3.2554f, 6.0276f, 2.1034f, 7.2829f, 1.3199f, 8.765f)
                    lineTo(1.1899f, 9.0f)
                    lineTo(1.3199f, 9.24f)
                    curveTo(3.0049f, 12.355f, 5.9599f, 14.24f, 9.2299f, 14.24f)
                    curveTo(10.5063f, 14.2398f, 11.766f, 13.9509f, 12.9149f, 13.395f)
                    lineTo(15.4149f, 15.895f)
                    lineTo(16.2899f, 15.145f)
                    lineTo(3.2899f, 2.145f)
                    lineTo(2.4349f, 2.89f)
                    close()
                    moveTo(6.5849f, 7.04f)
                    curveTo(6.1172f, 7.6997f, 5.8979f, 8.5037f, 5.966f, 9.3095f)
                    curveTo(6.0341f, 10.1154f, 6.3851f, 10.8711f, 6.957f, 11.443f)
                    curveTo(7.5288f, 12.0148f, 8.2846f, 12.3659f, 9.0905f, 12.434f)
                    curveTo(9.8963f, 12.5021f, 10.7002f, 12.2828f, 11.3599f, 11.815f)
                    lineTo(12.1599f, 12.615f)
                    curveTo(11.2338f, 13.0109f, 10.2371f, 13.215f, 9.2299f, 13.215f)
                    curveTo(6.4149f, 13.215f, 3.8549f, 11.645f, 2.3299f, 9.0f)
                    curveTo(3.0618f, 7.7041f, 4.1158f, 6.6191f, 5.3899f, 5.85f)
                    lineTo(6.5849f, 7.04f)
                    close()
                }
            }
        }
        .build()
        return _iconEyeHide!!
    }

private var _iconEyeHide: ImageVector? = null
