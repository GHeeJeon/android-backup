package edu.ourincheon.lab1_201801634

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val lis = MyListener()
        button.setOnClickListener(lis)

        radioButton.setOnClickListener(lis)
        radioButton2.setOnClickListener(lis)
        radioButton3.setOnClickListener(lis)
    }

    inner class MyListener : View.OnClickListener {    //내장 클래스
        override fun onClick(v: View?) {

            when (v?.id) {
                R.id.button ->
                    if (radioButton.isChecked == true) {
                        imageView2.setImageResource(R.drawable.gingerbread)
                    } else if (radioButton2.isChecked == true) {
                        imageView2.setImageResource(R.drawable.jellybean)
                    } else if (radioButton3.isChecked == true) {
                        imageView2.setImageResource(R.drawable.kitkat)
                    }
            }
        }
    }
}


