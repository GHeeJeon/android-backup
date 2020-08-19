package edu.ourincheon.t_volume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        volumeControl.setOnTouchListener { v, event ->
            if(event == null) false
            val x:Float = event.x
            val y:Float = event.y
            (v as MyView).setAngle(x, y)
            v?.invalidate()
            true
        }
    }
}
