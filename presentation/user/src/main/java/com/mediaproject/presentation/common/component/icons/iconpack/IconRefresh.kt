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

public val IconPack.IconRefresh: ImageVector
    get() {
        if (_iconRefresh != null) {
            return _iconRefresh!!
        }
        _iconRefresh = Builder(name = "IconRefresh", defaultWidth = 16.0.dp, defaultHeight =
                16.0.dp, viewportWidth = 16.0f, viewportHeight = 16.0f).apply {
            path(fill = SolidColor(Color(0xFF777986)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(8.0f, 16.0f)
                curveTo(5.7667f, 16.0f, 3.875f, 15.225f, 2.325f, 13.675f)
                curveTo(0.775f, 12.125f, 0.0f, 10.2333f, 0.0f, 8.0f)
                curveTo(0.0f, 5.7667f, 0.775f, 3.875f, 2.325f, 2.325f)
                curveTo(3.875f, 0.775f, 5.7667f, 0.0f, 8.0f, 0.0f)
                curveTo(9.15f, 0.0f, 10.25f, 0.2377f, 11.3f, 0.713f)
                curveTo(12.35f, 1.1877f, 13.25f, 1.8667f, 14.0f, 2.75f)
                verticalLineTo(1.0f)
                curveTo(14.0f, 0.7167f, 14.096f, 0.479f, 14.288f, 0.287f)
                curveTo(14.4793f, 0.0957f, 14.7167f, 0.0f, 15.0f, 0.0f)
                curveTo(15.2833f, 0.0f, 15.5207f, 0.0957f, 15.712f, 0.287f)
                curveTo(15.904f, 0.479f, 16.0f, 0.7167f, 16.0f, 1.0f)
                verticalLineTo(6.0f)
                curveTo(16.0f, 6.2833f, 15.904f, 6.5207f, 15.712f, 6.712f)
                curveTo(15.5207f, 6.904f, 15.2833f, 7.0f, 15.0f, 7.0f)
                horizontalLineTo(10.0f)
                curveTo(9.7167f, 7.0f, 9.4793f, 6.904f, 9.288f, 6.712f)
                curveTo(9.096f, 6.5207f, 9.0f, 6.2833f, 9.0f, 6.0f)
                curveTo(9.0f, 5.7167f, 9.096f, 5.479f, 9.288f, 5.287f)
                curveTo(9.4793f, 5.0957f, 9.7167f, 5.0f, 10.0f, 5.0f)
                horizontalLineTo(13.2f)
                curveTo(12.6667f, 4.0667f, 11.9377f, 3.3333f, 11.013f, 2.8f)
                curveTo(10.0877f, 2.2667f, 9.0833f, 2.0f, 8.0f, 2.0f)
                curveTo(6.3333f, 2.0f, 4.9167f, 2.5833f, 3.75f, 3.75f)
                curveTo(2.5833f, 4.9167f, 2.0f, 6.3333f, 2.0f, 8.0f)
                curveTo(2.0f, 9.6667f, 2.5833f, 11.0833f, 3.75f, 12.25f)
                curveTo(4.9167f, 13.4167f, 6.3333f, 14.0f, 8.0f, 14.0f)
                curveTo(9.15f, 14.0f, 10.2127f, 13.6957f, 11.188f, 13.087f)
                curveTo(12.1627f, 12.479f, 12.8917f, 11.6667f, 13.375f, 10.65f)
                curveTo(13.4583f, 10.4667f, 13.596f, 10.3127f, 13.788f, 10.188f)
                curveTo(13.9793f, 10.0627f, 14.175f, 10.0f, 14.375f, 10.0f)
                curveTo(14.7583f, 10.0f, 15.046f, 10.1333f, 15.238f, 10.4f)
                curveTo(15.4293f, 10.6667f, 15.45f, 10.9667f, 15.3f, 11.3f)
                curveTo(14.6667f, 12.7167f, 13.6917f, 13.854f, 12.375f, 14.712f)
                curveTo(11.0583f, 15.5707f, 9.6f, 16.0f, 8.0f, 16.0f)
                close()
            }
        }
        .build()
        return _iconRefresh!!
    }

private var _iconRefresh: ImageVector? = null
