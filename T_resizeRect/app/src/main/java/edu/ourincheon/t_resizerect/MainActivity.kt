package edu.ourincheon.t_resizerect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(view:View){
    when (view.id){
        R.id.button -> myCustomView.paddingUp(40)
        R.id.button2 -> myCustomView.swapColor()
        R.id.button3 -> myCustomView.paddingDown(40)
    }

    }
}
