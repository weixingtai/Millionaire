package com.surromo.common.widget

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.text.TextUtils
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.surromo.common.R

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2022/1/18
 * desc  : TODO
 */
class MTextView(context: Context, attrs: AttributeSet) : FrameLayout(context,attrs) {
    private var mLeftImage: ImageView
    private var mRightImage: ImageView
    private var mLeftTip: View
    private var mLeftText: TextView
    private var mRightText: TextView
    private var mBottomLine: View
    private var mTopLine: View

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_text_view,this)
        mLeftImage = findViewById(R.id.iv_left_img)
        mLeftTip = findViewById(R.id.v_left_tip)
        mRightImage = findViewById(R.id.iv_right_img)
        mLeftText = findViewById(R.id.tv_left_text)
        mRightText = findViewById(R.id.tv_right_text)
        mBottomLine = findViewById(R.id.v_line_bottom)
        mTopLine = findViewById(R.id.v_line_top)
        val array: TypedArray = context.obtainStyledAttributes(attrs,R.styleable.MTextView)
        var leftImage: Drawable? = array.getDrawable(R.styleable.MTextView_leftImage)
        var rightImage: Drawable? = array.getDrawable(R.styleable.MTextView_rightImage)
        var leftText: String? = array.getString(R.styleable.MTextView_leftText)
        var rightText: String? = array.getString(R.styleable.MTextView_rightText)
        var rightHint: String? = array.getString(R.styleable.MTextView_rightHintText)
        var leftTextColor: ColorStateList? = array.getColorStateList(R.styleable.MTextView_leftTextColor)
        var rightTextColor: ColorStateList? = array.getColorStateList(R.styleable.MTextView_rightTextColor)
        var leftTextSize: Float = array.getDimension(R.styleable.MTextView_leftTextSize, 14F)
        var rightTextSize: Float = array.getDimension(R.styleable.MTextView_rightTextSize, 13F)
        var rightHintColor: ColorStateList? = array.getColorStateList(R.styleable.MTextView_rightHintColor)

        var showBottomLine: Boolean = array.getBoolean(R.styleable.MTextView_showBottomLine,true)
        var showTopLine: Boolean = array.getBoolean(R.styleable.MTextView_showTopLine,false)
        var lineColor: Int = array.getColor(R.styleable.MTextView_lineColor,-1)
        var lineBg: Drawable? = array.getDrawable(R.styleable.MTextView_lineBg)

        var lineLeftMargin: Int = array.getDimensionPixelSize(R.styleable.MTextView_lineLeftMargin,0)
        var lineRightMargin: Int = array.getDimensionPixelSize(R.styleable.MTextView_lineRightMargin,0)
        var leftTextLeftPadding: Int = array.getDimensionPixelOffset(R.styleable.MTextView_leftTextLeftPadding,10)
        array.recycle()
        if (!TextUtils.isEmpty(leftText))
            mLeftText.text = leftText
        if (leftTextColor != null)
            mLeftText.setTextColor(leftTextColor)
        if (rightTextColor != null)
            mRightText.setTextColor(rightTextColor)
        if (rightHintColor != null)
            mRightText.setHintTextColor(rightHintColor)
        if (!TextUtils.isEmpty(rightText))
            mRightText.text = rightText
        if (!TextUtils.isEmpty(rightHint))
            mRightText.hint = rightHint
        mLeftText.setPadding(leftTextLeftPadding,0,0,0)
        if (leftImage == null) {
            mLeftImage.visibility = GONE
        }else {
            mLeftImage.visibility = VISIBLE
            mLeftImage.setImageDrawable(leftImage)
        }
        mRightImage.setImageDrawable(rightImage)
        mLeftText.textSize = leftTextSize
        mRightText.textSize = rightTextSize

        if (showBottomLine){
            mBottomLine.visibility = VISIBLE
            val params: RelativeLayout.LayoutParams = mBottomLine.layoutParams as RelativeLayout.LayoutParams
            params.setMargins(lineLeftMargin,0,lineRightMargin,0)
            if (lineColor != -1){
                mBottomLine.background = null
                mBottomLine.setBackgroundColor(lineColor)
            }
            if (lineBg != null)
                mBottomLine.background = lineBg
        }else{
            mBottomLine.visibility = INVISIBLE
        }
        if (showTopLine){
            mTopLine.visibility = VISIBLE
            val params: RelativeLayout.LayoutParams = mTopLine.layoutParams as RelativeLayout.LayoutParams
            params.setMargins(lineLeftMargin,0,lineRightMargin,0)
            if (lineColor != -1){
                mTopLine.background = null
                mTopLine.setBackgroundColor(lineColor)
            }
            if (lineBg != null)
                mTopLine.background = lineBg
        }else{
            mTopLine.visibility = INVISIBLE
        }
    }

    public fun setTopLineVisible(visible: Int){
        mTopLine.visibility = visible
    }

    public fun setLeftTipVisible(visible: Boolean){
        if (visible)
            mLeftTip.visibility = GONE
        else
            mLeftTip.visibility = INVISIBLE
    }

    public fun setLeftText(leftText: String){
        mLeftText.text = leftText
    }

    public fun setLeftText(leftText: CharSequence){
        mLeftText.text = leftText
    }

    public fun setLeftTextSize(leftTextSize: Float){
        mLeftText.textSize = leftTextSize
    }

    public fun setLeftTextColor(leftTextColor: Int){
        mLeftText.setTextColor(leftTextColor)
    }

    public fun setRightText(rightText: String){
        mRightText.text = rightText
    }

    public fun setRightText(rightText: CharSequence){
        mRightText.text = rightText
    }

    public fun setRightTextSize(rightTextSize: Float){
        mRightText.textSize = rightTextSize
    }

    public fun setRightTextColor(rightTextColor: Int){
        mRightText.setTextColor(rightTextColor)
    }

    public fun getLeftTextView(): TextView {
        return mLeftText
    }

    public fun getRightText():String {
        return mRightText.text.toString()
    }

    public fun setRightImageClickListener(listener: OnClickListener){
        mRightImage.setOnClickListener(listener)
    }

    public fun getRightImage(): ImageView{
        return mRightImage
    }

    public fun  setRightImage(res: Int){
        if (res == 0){
            mRightImage.visibility = INVISIBLE
        }else {
            mRightImage.visibility = VISIBLE
        }
        mRightImage.setImageResource(res)
    }

}