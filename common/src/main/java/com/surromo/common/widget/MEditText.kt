package com.surromo.common.widget

import android.content.Context
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.text.InputType
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.EditText
import androidx.core.content.ContextCompat
import com.surromo.common.R

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2022/1/7
 * desc  : TODO
 */

open class MEditText(context: Context, attributeSet: AttributeSet,defStyle: Int) : androidx.appcompat.widget.AppCompatEditText(context,attributeSet,defStyle) {

    // 当前密码可见时的图片
    private val showIcon = R.drawable.ic_pwd_show
    // 当前密码不可见时的图片
    private val hideIcon = R.drawable.ic_pwd_hide

    //注意设置密码的明暗文，需要组合使用InputType
    private val hide = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
    private val show = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD

    private lateinit var hideDrawable: Drawable
    private lateinit var showDrawable: Drawable
    private var mContext: Context = context

    //是否显示密码
    private var isShowPassword = false

    init {
        initDrawable()
        inputType = hide
        setRightIcon(false)
    }

    constructor(context: Context, attributeSet: AttributeSet) : this(context, attributeSet, android.R.attr.editTextStyle)

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event!!.action == MotionEvent.ACTION_UP) {
            val touchable = event.x > width - totalPaddingRight && event.x < width - paddingRight
            if (touchable) {
                inputType = if (isShowPassword) show else hide
                setRightIcon(isShowPassword)
                /**
                 * 每次设置一下本文类型，否则EditText属性为密码时，英文下，文本字体会和其它的不一样  add by liubo
                 */
                typeface = getTypeFace()
                text?.let { setSelection(it.length) }
            }
        }
        return super.onTouchEvent(event)
    }

    private fun getTypeFace() : Typeface{
        val editText = EditText(mContext)
        return editText.typeface
    }

    fun setRightIcon(isShowPassword: Boolean) {
        val right: Drawable = if (isShowPassword) showDrawable else hideDrawable
        setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], right, compoundDrawables[3])
        this.isShowPassword = !isShowPassword
    }

    private fun initDrawable() {
        hideDrawable = ContextCompat.getDrawable(mContext,hideIcon)!!
        showDrawable = ContextCompat.getDrawable(mContext,showIcon)!!
        hideDrawable.setBounds(0, 0, hideDrawable.intrinsicWidth, hideDrawable.intrinsicHeight)
        showDrawable.setBounds(0, 0, showDrawable.intrinsicWidth, showDrawable.intrinsicHeight)
    }

}