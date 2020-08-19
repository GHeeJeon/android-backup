package edu.ourincheon.t_longorshort_click

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myBtn.setOnClickListener{object: View.OnClickListener{
            override fun onClick(p0: View?) {
                textView.text="짧은 클릭"
            }
        }}
        myBtn.setOnLongClickListener(object:View.OnLongClickListener{
            override fun onLongClick(p0: View?): Boolean {
                textView.text="긴 클릭"
                return true     //제대로 처리했으면 true,
                                // return false 일 경우 길게 클릭했다 뗐을 때 짧은 클릭으로 바뀐다.
            }
        })
    }
}
