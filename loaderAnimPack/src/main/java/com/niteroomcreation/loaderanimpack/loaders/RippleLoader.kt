package com.niteroomcreation.loaderanimpack.loaders

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.ViewTreeObserver
import android.view.animation.AnimationUtils
import com.niteroomcreation.loaderanimpack.R
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

        setMeasuredDimension(4 * rippleRadius, 4 * rippleRadius)
    }

    override fun initView() {

        //resetting layout
        removeAllViews()
        removeAllViewsInLayout()

        this.gravity = Gravity.CENTER

        //init circle view
        circleView = CircleView(context, rippleRadius, rippleColor)

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
        var typedArray = context.obtainStyledAttributes(attrs, R.styleable.RippleLoader, 0, 0)

        rippleRadius = typedArray.getDimensionPixelSize(R.styleable.RippleLoader_ripple_circleRadius, 40)
        rippleColor = typedArray.getColor(R.styleable.RippleLoader_ripple_circleColor, resources.getColor(android.R.color.holo_purple))
        rippleFromAlpha = typedArray.getFloat(R.styleable.RippleLoader_ripple_fromAlpha, 0.9f)
        rippleToAlpha = typedArray.getFloat(R.styleable.RippleLoader_ripple_toAlpha, 0.01f)
        rippleDurationAnimation = typedArray.getInt(R.styleable.RippleLoader_ripple_durationAnimation, 2000)
        rippleInterpolator = AnimationUtils.loadInterpolator(
            context, typedArray.getResourceId(
                R.styleable.RippleLoader_ripple_interpolator, android.R.anim.decelerate_interpolator
            )
        )

        //recycling view
        typedArray.recycle()
    }

    override fun startLoading() {
        var animationSet = animationSet()
        circleView.startAnimation(animationSet)
    }

}