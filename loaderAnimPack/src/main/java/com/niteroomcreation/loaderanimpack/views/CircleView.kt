package com.niteroomcreation.loaderanimpack.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.niteroomcreation.loaderanimpack.R

/**
 * Created by Septian Adi Wijaya on 16/11/20
 */
class CircleView : View {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initAttributes(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initAttributes(attrs)
    }

    //custom constructor
    constructor(context: Context, circleRadius: Int, circleColor: Int) : super(context) {
        this.circleRadius = circleRadius
        this.circleColor = circleColor
    }

    constructor(context: Context, circleRadius: Int, circleColor: Int, drawOnlyStroke: Boolean, strokeWidth: Int) : super(context) {
        this.circleRadius = circleRadius
        this.circleColor = circleColor

        this.circleDrawOnlyStroke = drawOnlyStroke
        this.circleStrokeWidth = strokeWidth
    }

    //attrs declared on XML
    var circleRadius: Int = 30
    var circleStrokeWidth: Int = 0
    var circleColor: Int = resources.getColor(android.R.color.holo_blue_bright, null)
    var circleDrawOnlyStroke: Boolean = false

    private var paint: Paint = Paint()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)


    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val widthHeight = (2 * (circleRadius)) + circleStrokeWidth
        setMeasuredDimension(widthHeight, widthHeight)
    }

    fun initAttributes(attrs: AttributeSet) {

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CircleView, 0, 0)

        this.circleRadius = typedArray.getDimensionPixelSize(R.styleable.CircleView_circleRadius, 30)
        this.circleColor = typedArray.getColor(R.styleable.CircleView_circleColor, resources.getColor(android.R.color.holo_blue_bright, null))
        this.circleDrawOnlyStroke = typedArray.getBoolean(R.styleable.CircleView_circleDrawOnlystroke, false)

        if (this.circleDrawOnlyStroke)
            this.circleStrokeWidth = typedArray.getDimensionPixelSize(R.styleable.CircleView_circleStrokeWidth, 0)

        typedArray.recycle()
    }

}