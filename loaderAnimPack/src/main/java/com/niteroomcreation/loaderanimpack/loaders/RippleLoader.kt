package com.niteroomcreation.loaderanimpack.loaders

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.ViewTreeObserver
import com.niteroomcreation.loaderanimpack.views.CircleView
import com.niteroomcreation.loaderanimpack.views.RippleView

/**
 * Created by Septian Adi Wijaya on 12/11/20
 */

open class RippleLoader : RippleView {

    constructor(context: Context) : super(context) {
        initView()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initAttributes(attrs)
        initView()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initAttributes(attrs)
        initView()
    }

    private lateinit var circleView: CircleView


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        setMeasuredDimension(4 * circleRadius, 4 * circleRadius)
    }

    override fun initView() {

        //resetting layout
        removeAllViews()
        removeAllViewsInLayout()

        this.gravity = Gravity.CENTER

        //init circle view
        circleView = CircleView(context, circleRadius, circleColor)

        //add
        addView(circleView)

        viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                startLoading()
                this@RippleLoader.viewTreeObserver.removeOnGlobalLayoutListener(this)
            }
        })
    }

    override fun initAttributes(attrs: AttributeSet) {

    }

    override fun startLoading() {
        var animationSet = animationSet()
        circleView.startAnimation(animationSet)
    }

}