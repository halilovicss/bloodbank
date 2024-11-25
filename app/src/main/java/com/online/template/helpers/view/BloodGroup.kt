package com.online.template.helpers.view

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.online.template.R
import com.online.template.helpers.constant.EMPTY_STRING

class BloodGroup @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val imageView: ImageView
    private val textView: TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_blood_group, this, true)

        imageView = findViewById(R.id.imageViewBloodDrop)
        textView = findViewById(R.id.textViewBloodGroup)

        // Preuzimanje atributa iz XML-a ako ih ima
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.BloodGroup, 0, 0)
            val imageDrawable = typedArray.getDrawable(R.styleable.BloodGroup_imageDrawable)
            val text = typedArray.getString(R.styleable.BloodGroup_bloodGroupText)
            typedArray.recycle()

            setImageDrawable(imageDrawable)
            setText(text)
            setText(text)
        }
    }

    fun setImageDrawable(drawable: Drawable?) {
        imageView.setImageDrawable(
            drawable ?: ContextCompat.getDrawable(
                context,
                R.drawable.ic_blood_drop
            )
        )
    }

    fun setText(text: String?) {
        textView.text = text ?: EMPTY_STRING
    }
}
