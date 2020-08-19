package edu.ourincheon.lab2_201801634

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class MyView(context:Context) : View(context)    {

    val paint = Paint()
    var x:Int = 0
    var y:Int = 0
    var maxWidth : Int = 0
    var maxHeight : Int = 0
    var widthView : Int = 0
    var heightView : Int = 0

    init{
        setBackgroundColor(Color.YELLOW)
        val dm = resources.displayMetrics

        widthView = dm.widthPixels
        heightView = dm.heightPixels
        maxWidth = dm.widthPixels  //w = width
        maxHeight = dm.heightPixels //h = height

        x = maxWidth/2
        y = maxHeight/2

        paint.style = Paint.Style.FILL_AND_STROKE
        paint.color = Color.BLUE
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        //100x100 square
        canvas?.drawRect(x-50f, y-50f, x+50f, y+50f, paint)
    }
}