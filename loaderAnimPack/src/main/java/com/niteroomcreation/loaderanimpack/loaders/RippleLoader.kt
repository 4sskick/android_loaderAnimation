package com.niteroomcreation.loaderanimpack.loaders

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import com.niteroomcreation.loaderanimpack.views.RippleView

/**
 * Created by Septian Adi Wijaya on 12/11/20
 */

open class RippleLoader : RippleView {

    constructor(context: Context) : super(context){
        initView()
    }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs){
        initAttributes(attrs)
        initView()
    }
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ){
        initAttributes(attrs)
        initView()
    }

    override fun initView() {

        //resetting layout
        removeAllViews()
        removeAllViewsInLayout()

        this.gravity = Gravity.CENTER
    }

    override fun initAttributes(attrs: AttributeSet) {
    }

    override fun startLoading() {
    }

}