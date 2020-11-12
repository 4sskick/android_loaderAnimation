package com.niteroomcreation.loaderanimpack.loaders

import android.content.Context
import android.util.AttributeSet
import com.niteroomcreation.loaderanimpack.views.RippleView

/**
 * Created by Septian Adi Wijaya on 12/11/20
 */

open class RippleLoader : RippleView {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun initView() {
        TODO("Not yet implemented")
    }

    override fun initAttributes(attrs: AttributeSet) {
        TODO("Not yet implemented")
    }

    override fun startLoading() {
        TODO("Not yet implemented")
    }

}