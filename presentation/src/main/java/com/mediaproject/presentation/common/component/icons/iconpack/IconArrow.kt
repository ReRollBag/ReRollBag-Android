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

public val IconPack.IconArrow: ImageVector
    get() {
        if (_iconArrow != null) {
            return _iconArrow!!
        }
        _iconArrow = Builder(name = "IconArrow", defaultWidth = 7.0.dp, defaultHeight = 10.0.dp,
                viewportWidth = 7.0f, viewportHeight = 10.0f).apply {
            path(fill = SolidColor(Color(0xFF777986)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(1.4168f, 9.8021f)
                lineTo(5.8627f, 5.3694f)
                curveTo(5.9155f, 5.3166f, 5.9528f, 5.2594f, 5.9746f, 5.1979f)
                curveTo(5.9967f, 5.1363f, 6.0078f, 5.0704f, 6.0078f, 5.0f)
                curveTo(6.0078f, 4.9296f, 5.9967f, 4.8637f, 5.9746f, 4.8021f)
                curveTo(5.9528f, 4.7406f, 5.9155f, 4.6834f, 5.8627f, 4.6306f)
                lineTo(1.4168f, 0.1847f)
                curveTo(1.2937f, 0.0616f, 1.1397f, 0.0f, 0.955f, 0.0f)
                curveTo(0.7703f, 0.0f, 0.612f, 0.066f, 0.4801f, 0.1979f)
                curveTo(0.3482f, 0.3298f, 0.2822f, 0.4837f, 0.2822f, 0.6596f)
                curveTo(0.2822f, 0.8355f, 0.3482f, 0.9894f, 0.4801f, 1.1214f)
                lineTo(4.3587f, 5.0f)
                lineTo(0.4801f, 8.8786f)
                curveTo(0.357f, 9.0018f, 0.2954f, 9.1534f, 0.2954f, 9.3335f)
                curveTo(0.2954f, 9.514f, 0.3614f, 9.6702f, 0.4933f, 9.8021f)
                curveTo(0.6252f, 9.934f, 0.7791f, 10.0f, 0.955f, 10.0f)
                curveTo(1.1309f, 10.0f, 1.2849f, 9.934f, 1.4168f, 9.8021f)
                close()
            }
        }
        .build()
        return _iconArrow!!
    }

private var _iconArrow: ImageVector? = null
