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

public val IconPack.IconRefreshList: ImageVector
    get() {
        if (_iconRefreshList != null) {
            return _iconRefreshList!!
        }
        _iconRefreshList = Builder(name = "IconRefreshList", defaultWidth = 10.0.dp, defaultHeight =
                14.0.dp, viewportWidth = 10.0f, viewportHeight = 14.0f).apply {
            path(fill = SolidColor(Color(0xFF777986)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(4.9999f, 3.4998f)
                verticalLineTo(4.544f)
                curveTo(4.9999f, 4.8065f, 5.3149f, 4.9348f, 5.4957f, 4.7481f)
                lineTo(7.1233f, 3.1207f)
                curveTo(7.2399f, 3.004f, 7.2399f, 2.8231f, 7.1233f, 2.7065f)
                lineTo(5.4957f, 1.079f)
                curveTo(5.4546f, 1.0387f, 5.4025f, 1.0114f, 5.3459f, 1.0007f)
                curveTo(5.2893f, 0.99f, 5.2309f, 0.9962f, 5.1778f, 1.0187f)
                curveTo(5.1248f, 1.0412f, 5.0796f, 1.0788f, 5.048f, 1.1269f)
                curveTo(5.0163f, 1.175f, 4.9996f, 1.2314f, 4.9999f, 1.289f)
                verticalLineTo(2.3331f)
                curveTo(2.4216f, 2.3331f, 0.3333f, 4.4215f, 0.3333f, 6.9998f)
                curveTo(0.3333f, 7.6065f, 0.4499f, 8.1898f, 0.6658f, 8.7206f)
                curveTo(0.8233f, 9.1115f, 1.3249f, 9.2165f, 1.6224f, 8.919f)
                curveTo(1.7799f, 8.7615f, 1.8441f, 8.5223f, 1.7566f, 8.3123f)
                curveTo(1.5874f, 7.9098f, 1.4999f, 7.4606f, 1.4999f, 6.9998f)
                curveTo(1.4999f, 5.069f, 3.0691f, 3.4998f, 4.9999f, 3.4998f)
                close()
                moveTo(8.3774f, 5.0806f)
                curveTo(8.2199f, 5.2382f, 8.1558f, 5.4832f, 8.2432f, 5.6873f)
                curveTo(8.4066f, 6.0957f, 8.4999f, 6.539f, 8.4999f, 6.9998f)
                curveTo(8.4999f, 8.9306f, 6.9307f, 10.4998f, 4.9999f, 10.4998f)
                verticalLineTo(9.4557f)
                curveTo(4.9999f, 9.1931f, 4.6849f, 9.0648f, 4.5041f, 9.2515f)
                lineTo(2.8766f, 10.879f)
                curveTo(2.7599f, 10.9957f, 2.7599f, 11.1765f, 2.8766f, 11.2932f)
                lineTo(4.5041f, 12.9207f)
                curveTo(4.5448f, 12.9606f, 4.5964f, 12.9878f, 4.6525f, 12.9987f)
                curveTo(4.7085f, 13.0096f, 4.7665f, 13.0038f, 4.8193f, 12.9821f)
                curveTo(4.8721f, 12.9603f, 4.9174f, 12.9236f, 4.9495f, 12.8764f)
                curveTo(4.9816f, 12.8292f, 4.9991f, 12.7736f, 4.9999f, 12.7165f)
                verticalLineTo(11.6665f)
                curveTo(7.5782f, 11.6665f, 9.6666f, 9.5781f, 9.6666f, 6.9998f)
                curveTo(9.6666f, 6.3931f, 9.5499f, 5.8098f, 9.3341f, 5.279f)
                curveTo(9.1766f, 4.8882f, 8.6749f, 4.7832f, 8.3774f, 5.0806f)
                close()
            }
        }
        .build()
        return _iconRefreshList!!
    }

private var _iconRefreshList: ImageVector? = null
