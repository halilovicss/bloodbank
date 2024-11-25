package com.online.template.helpers.view

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.RectF

fun Bitmap.scaleCenterCropBitmap(width: Int, height: Int): Bitmap {
    val sourceWidth = this.width
    val sourceHeight = this.height
    val xScale = width.toFloat() / sourceWidth
    val yScale = height.toFloat() / sourceHeight
    val scale = Math.max(xScale, yScale)

    // Now get the size of the source bitmap when scaled

    // Now get the size of the source bitmap when scaled
    val scaledWidth = scale * sourceWidth
    val scaledHeight = scale * sourceHeight

    val left: Float = (width - scaledWidth) / 2
    val top: Float = (height - scaledHeight) / 2

    val targetRect = RectF(
        left,
        top,
        left + scaledWidth,
        top + scaledHeight
    ) // from ww w  .j a va 2s. co m

    val dest = Bitmap.createBitmap(
        width, height,
        this.config
    )
    val canvas = Canvas(dest)
    canvas.drawBitmap(this, null, targetRect, null)

    return dest
}
