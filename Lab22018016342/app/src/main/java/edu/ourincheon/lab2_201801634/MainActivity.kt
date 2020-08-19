package edu.ourincheon.lab2_201801634

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View

        class MainActivity : AppCompatActivity() {

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                //setContentView(R.layout.activity_main)

                val myView = MyView(this)
        myView.isFocusable = true
        setContentView(myView)

        myView.setOnKeyListener { _, keyCode, _ ->
            val maxX = myView.maxWidth
            val maxY = myView.maxHeight
            when (keyCode){
                KeyEvent.KEYCODE_J->{
                if(myView.x-50 -20 < 0) myView.x = 50
                else myView.x -= 20
            }
                KeyEvent.KEYCODE_K->{
                    if(myView.x+50 +20 > maxX) myView.x = maxX - 50
                    else myView.x += 20
                }
                KeyEvent.KEYCODE_M->{
                    if(myView.y+50+20 < 0) myView.y = maxY - 260
                    else myView.y += 20
                }
                KeyEvent.KEYCODE_N->{
                    if(myView.y-50-20 > maxY) myView.y = 50
                    else myView.y -= 20
                }

            }
            myView.invalidate()     //request to draw
            true
        }
    }
}
