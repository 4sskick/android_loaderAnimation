package com.niteroomcreation.loaderanimpack.views

import android.content.Context
import android.util.AttributeSet
import android.view.animation.*
import android.widget.LinearLayout
import com.niteroomcreation.loaderanimpack.contracts.LoaderContracts

/**
 * Created by Septian Adi Wijaya on 12/11/20
 */

abstract class RippleView : LinearLayout, LoaderContracts {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    var circleRadius: Int = 40
    var circleColor: Int = resources.getColor(android.R.color.holo_purple)
    var fromAlpha: Float = 0.9f
    var toAlpha: Float = 0.01f
    var animationDuration = 2000
    var interpolator: Interpolator = DecelerateInterpolator()

    abstract fun initView()

    abstract fun startLoading()

    protected fun animationSet(): Animation {

        val set = AnimationSet(true)

        //scale
        val animationScale = ScaleAnimation(
            1.0f,
            2.0f,
            1.0f,
            2.0f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        animationScale.duration = animationDuration.toLong()
        animationScale.repeatCount = Animation.INFINITE

        //alpha
        val animationAlpha = AlphaAnimation(fromAlpha, toAlpha)
        animationAlpha.duration = animationDuration.toLong()
        animationAlpha.repeatCount = Animation.INFINITE

        //add animation to set
        set.addAnimation(animationScale)
        set.addAnimation(animationAlpha)

        //setup configuration
        set.duration = animationDuration.toLong()
        set.repeatCount = Animation.INFINITE
        set.repeatMode = Animation.RESTART

        return set
    }

}