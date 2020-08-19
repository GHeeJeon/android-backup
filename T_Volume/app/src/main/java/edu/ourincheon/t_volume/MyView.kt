package edu.ourincheon.t_volume

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import org.w3c.dom.Attr
import kotlin.math.atan2

class MyView :AppCompatImageView{

    var half_width:Float = 0f
    var half_height:Float = 0f
    var angle:Float = 0f
    val PI:Float = 3.1415f
    constructor(context: Context):super(context){
        setImageResource(R.mipmap.ic_launcher)
    }

    constructor(context: Context, attrs:AttributeSet):super(context, attrs){
        setImageResource(R.mipmap.ic_launcher)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        half_width = (w/2).toFloat()
        half_height = (h/2).toFloat()
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.save()
        canvas?.rotate(angle, half_width, half_height)
        super.onDraw(canvas)
        canvas?.restore()
    }

    fun setAngle(x:Float, y:Float){
        var mx = x - half_width
        var my = half_height - y
                angle = (atan2(x, y) * 180.0 / PI).toFloat()
    }
}
