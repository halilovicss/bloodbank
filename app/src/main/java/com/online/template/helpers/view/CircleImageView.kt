package com.online.template.helpers.view

import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.online.template.R

class CircleImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(context, attrs, defStyleAttr, defStyleRes) {

    private val circlePaint = Paint()

    private val textPaint = Paint().apply {
        textAlign = Paint.Align.CENTER
        color = ContextCompat.getColor(context, R.color.background_color)
        textSize = 80f
    }

    private var circleBackgroundColor: Int = 0
        set(value) {
            field = value
            invalidate()
        }

    private var circleRadius: Float = 60f
        set(value) {
            field = value
            invalidate()
        }

    private var initialsTextColor: Int = 0
        set(value) {
            field = value
            invalidate()
        }

    private var initialsTextSize: Float = 50f
        set(value) {
            field = value
            invalidate()
        }

    var firstName: String? = null
        set(value) {
            field = value
            invalidate()
        }

    var lastName: String? = null
        set(value) {
            field = value
            invalidate()
        }

    var url: String? = null
        set(value) {
            field = value
            if (value != null) {
                loadImage(value)
            }
        }

    private var bitmap: Bitmap? = null

    init {
        if (attrs != null) {
            val typedArray = context.obtainStyledAttributes(attrs, R.styleable.InitialsView)
            circleBackgroundColor = typedArray.getColor(
                R.styleable.InitialsView_backgroundColor,
                ContextCompat.getColor(context, R.color.background_color)
            )
            circleRadius = typedArray.getDimension(R.styleable.InitialsView_circleRadius, 60f)
            initialsTextColor =
                typedArray.getColor(
                    R.styleable.InitialsView_textColor,
                    ContextCompat.getColor(context, R.color.black)
                )
            initialsTextSize = typedArray.getDimension(R.styleable.InitialsView_textSize, 50f)
            firstName = typedArray.getString(R.styleable.InitialsView_firstName)
            lastName = typedArray.getString(R.styleable.InitialsView_lastName)
            url = typedArray.getString(R.styleable.InitialsView_url)

            circlePaint.color = circleBackgroundColor
            textPaint.color = initialsTextColor
            textPaint.textSize = initialsTextSize
            typedArray.recycle()
        }
    }

    private fun loadImage(url: String) {
        Glide.with(this.context)
            .asBitmap()
            .load(url)
            .circleCrop()
            .into(ProfileImageTarget())
    }

    inner class ProfileImageTarget : CustomTarget<Bitmap>() {
        override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
            bitmap = resource
            invalidate()
            requestLayout()
        }

        override fun onLoadCleared(placeholder: Drawable?) {
            // do nothing
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawCircle(
            width.toFloat() / 2,
            height.toFloat() / 2,
            width.toFloat() / 2,
            circlePaint
        )

        if (url?.isNotBlank() == true) {
            val resource = bitmap?.scaleCenterCropBitmap(width, height) ?: return
            canvas.drawBitmap(resource, 0f, 0f, null)
        } else if (!firstName.isNullOrBlank() && !lastName.isNullOrBlank()) {
            val xPos = width / 2
            val yPos = (height / 2 - (textPaint.descent() + textPaint.ascent()) / 2).toInt()
            canvas.drawText(
                firstName!!.take(1) + lastName!!.take(1),
                xPos.toFloat(),
                yPos.toFloat(),
                textPaint
            )
        } else if (!firstName.isNullOrBlank() && lastName.isNullOrBlank()) {
            val xPos = width / 2
            val yPos = (height / 2 - (textPaint.descent() + textPaint.ascent()) / 2).toInt()
            canvas.drawText(firstName!!.take(2), xPos.toFloat(), yPos.toFloat(), textPaint)
        } else if (firstName.isNullOrBlank() && !lastName.isNullOrBlank()) {
            val xPos = width / 2
            val yPos = (height / 2 - (textPaint.descent() + textPaint.ascent()) / 2).toInt()
            canvas.drawText(lastName!!.take(2), xPos.toFloat(), yPos.toFloat(), textPaint)
        }
    }
}
