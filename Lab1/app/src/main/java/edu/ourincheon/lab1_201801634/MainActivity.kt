package edu.ourincheon.lab1_201801634

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lis = MyListener()

        radioButton.setOnClickListener(lis)
        radioButton2.setOnClickListener(lis)
        radioButton3.setOnClickListener(lis)

    }
    inner class MyListener : View.OnClickListener{    //내장 클래스
        override fun onClick(v: View?) {
            when (v?.id){
                R.id.radioButton -> imageView2.setImageResource(R.drawable.gingerbread)
                R.id.radioButton2 -> imageView2.setImageResource(R.drawable.jellybean)
                R.id.radioButton3 -> imageView2.setImageResource(R.drawable.kitkat)
            }
        }
    }
}
