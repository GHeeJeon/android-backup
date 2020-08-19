package edu.ourincheon.t_touchevent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    val sb = StringBuilder() //mutable <-> immutable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //↓람다변환가능, 사용안되는 변수의 경우 언더바
        myView.setOnTouchListener(object: View.OnTouchListener{//? : null 값을 가질 수도 있고 아닐 수도 있고~ safecall
            override fun onTouch(p0: View?, event: MotionEvent?): Boolean {
                handlerTouch(event)
                return true
            }
        })
    }
    private fun handlerTouch(m: MotionEvent?){

        //if(m == null) return ↓?를 없애고 싶을 때
       var x = m?.x // 멀티터치의 경우 m.getX(i)ㅇㅇ
        var y = m?.y

        when (m?.action){   //switch-case
            MotionEvent.ACTION_DOWN ->sb.append{"손가락을 터치: x = $x, y = $y \n"}
            MotionEvent.ACTION_UP -> sb.append{"손가락을 뗌: x = $x, y = $y \n"}
            MotionEvent.ACTION_MOVE ->sb.append{"손가락을 이동:x = $x, y = $y \n"}
            else -> sb.append{"아무짓도 하지 않음\n"}
        }
        textView.text = sb
    }
}
