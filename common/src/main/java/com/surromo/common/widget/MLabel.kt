package com.surromo.common.widget

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.text.TextUtils
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import com.surromo.common.R

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2022/1/18
 * desc  : TODO
 */
class MLabel(context: Context, attrs: AttributeSet) : FrameLayout(context,attrs) {
    private var mContainer: LinearLayout
    private var mLabel: TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_label,this)
        mContainer = findViewById(R.id.ll_container)
        mLabel = findViewById(R.id.tv_label)
        val array: TypedArray = context.obtainStyledAttributes(attrs,R.styleable.MLabel)
        var text: String? = array.getString(R.styleable.MLabel_text)
        var textSize: Float = array.getDimension(R.styleable.MLabel_textSize, 14F)
        var textColor: ColorStateList? = array.getColorStateList(R.styleable.MLabel_textColor)
        var bgColor: ColorStateList? = array.getColorStateList(R.styleable.MLabel_bgColor)

        array.recycle()
        if (!TextUtils.isEmpty(text))
            mLabel.text = text
        if (textColor != null)
            mLabel.setTextColor(textColor)
        mLabel.textSize = textSize

        val strokeWidth = 5
        val radius = 20
        val strokeColor = bgColor
        val fillColor = bgColor

        val gd = GradientDrawable()
        gd.color = fillColor
        gd.cornerRadius = radius.toFloat()
        gd.setStroke(strokeWidth,strokeColor)

        mContainer.background = gd

    }

    public fun setText(text: String){
        mLabel.text = text
    }

    public fun setTextSize(textSize: Float){
        mLabel.textSize = textSize
    }

    public fun setTextColor(textColor: Int){
        mLabel.setTextColor(textColor)
    }

}