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

public val IconPack.IconArrowBack: ImageVector
    get() {
        if (_iconArrowBack != null) {
            return _iconArrowBack!!
        }
        _iconArrowBack = Builder(name = "IconArrowBack", defaultWidth = 9.0.dp, defaultHeight =
                16.0.dp, viewportWidth = 9.0f, viewportHeight = 16.0f).apply {
            path(fill = SolidColor(Color(0xFF75A66F)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(7.3439f, 14.825f)
                lineTo(1.0251f, 8.5251f)
                curveTo(0.9501f, 8.4501f, 0.8971f, 8.3688f, 0.8661f, 8.2813f)
                curveTo(0.8346f, 8.1938f, 0.8188f, 8.1f, 0.8188f, 8.0f)
                curveTo(0.8188f, 7.9001f, 0.8346f, 7.8063f, 0.8661f, 7.7188f)
                curveTo(0.8971f, 7.6313f, 0.9501f, 7.55f, 1.0251f, 7.475f)
                lineTo(7.3439f, 1.1563f)
                curveTo(7.5188f, 0.9813f, 7.7376f, 0.8938f, 8.0001f, 0.8938f)
                curveTo(8.2626f, 0.8938f, 8.4876f, 0.9875f, 8.6751f, 1.1751f)
                curveTo(8.8626f, 1.3626f, 8.9564f, 1.5813f, 8.9564f, 1.8313f)
                curveTo(8.9564f, 2.0813f, 8.8626f, 2.3001f, 8.6751f, 2.4876f)
                lineTo(3.1626f, 8.0f)
                lineTo(8.6751f, 13.5125f)
                curveTo(8.8501f, 13.6875f, 8.9376f, 13.903f, 8.9376f, 14.159f)
                curveTo(8.9376f, 14.4155f, 8.8439f, 14.6375f, 8.6564f, 14.825f)
                curveTo(8.4689f, 15.0125f, 8.2501f, 15.1063f, 8.0001f, 15.1063f)
                curveTo(7.7501f, 15.1063f, 7.5314f, 15.0125f, 7.3439f, 14.825f)
                close()
            }
        }
        .build()
        return _iconArrowBack!!
    }

private var _iconArrowBack: ImageVector? = null
