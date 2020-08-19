package edu.ourincheon.t_resizerect

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

class MyView : View {

    val mPaint = Paint()
    var mSquareColor:Int = 0
    var mSquareWidth:Float = 0f
    var mPadding:Int = 0

    //create a new View instance from Kotlin code
    constructor(context: Context) :super(context){
    initialize(null)
    }

    //create a new View instance from XML layout
    constructor(context: Context, attrs:AttributeSet) :super(context, attrs){
        initialize(attrs)
    }

    //create a new View instance from XML layout with a style attribute(theme attribute)
    constructor(context: Context, attrs:AttributeSet, deftStyleAttr:Int)
            :super(context, attrs, deftStyleAttr){
        initialize(attrs)

    }

    private fun initialize(attrs:AttributeSet?){
    if(attrs == null) return
        val ta = context.obtainStyledAttributes(attrs, R.styleable.MyCustomView)
        mSquareColor = ta.getColor(R.styleable.MyCustomView_square_color, Color.BLUE)
        mSquareWidth = ta.getDimension(R.styleable.MyCustomView_square_width, 10f)
        mPaint.color =mSquareColor
        mPaint.strokeWidth = mSquareWidth
        ta.recycle()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        var mRect = Rect()
        mRect.left = 0
        mRect.top = 0
        mRect.right = width + mPadding
        mRect.bottom = height + mPadding
        canvas?.drawRect(mRect, mPaint)
    }
    fun swapColor(){
        mPaint.color = if(mPaint.color == mSquareColor) Color.RED else mSquareColor
        postInvalidate()
    }

    fun paddingUp(padding:Int){
        mPadding += padding
        postInvalidate()
    }
    fun paddingDown(padding:Int) {
        mPadding -= padding
        postInvalidate()
    }

}