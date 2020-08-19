package edu.ourincheon.t_freecurve

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.view.MotionEvent
import android.view.View

class MyView : View {

   private val paint = Paint()
    private val path = Path()
    constructor(context: Context): super(context) {
        initialize()
    }
    private fun initialize() {
        setBackgroundColor(Color.YELLOW)

        paint.color = Color.BLACK
        paint.strokeWidth = 10f
        paint.style = Paint.Style.STROKE
        paint.strokeJoin = Paint.Join.ROUND
        paint.isAntiAlias = true
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawPath(path, paint)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if(event == null) return super.onTouchEvent(event)
        val x:Float = event.x
        val y:Float = event.y

        when (event.action){
            MotionEvent.ACTION_DOWN -> {path.moveTo(x, y)}
            MotionEvent.ACTION_MOVE -> {path.lineTo(x, y)}
            MotionEvent.ACTION_UP -> {/*nothing*/}
            else -> return false
        }
        this.invalidate()
        return true
    }
}