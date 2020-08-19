package edu.ourincheon.eventhandler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
//listener 인터페이스를 상속받아 구현

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myBtn.setOnClickListener{this}

/*//내장클래스 이용, 여러 번 이용할 때
class Listener : View.OnClickListener{
override fun onClick(p0: View?) {
Toast.makeText(applicationContext,
"버튼이 눌렸어요!", Toast.LENGTH_SHORT).show()
}
}
val myListener = MyListener()
myBtn.setOnClickListener {myListener}
*/

/*//무명클래스 이용, 한 번만 필요할 때, 전구를 통해 람다로 바꾸기
    myBtn.setOnClickListener {object :View.OnClickListener{
    override fun onClick(p0: View?) {
        Toast.makeText(applicationContext,
            "버튼이 눌렸어요!", Toast.LENGTH_SHORT).show()
    }
}}*/
    }
    override fun onClick(p0: View?) {
        Toast.makeText(applicationContext,
            "버튼이 눌렸어요!", Toast.LENGTH_SHORT).show()
    }

    //xml OnClick 속성에서 OnButtonClicked 추가 후
    //View.OnClickListener 구현상속 지우고
    //OnClick 추상메소드 지우고
    //        myBtn.setOnClickListener{this} 주석처리
    /*fun OnButtonClicked(view: View) {
        Toast.makeText(applicationContext,
            "버튼이 눌렸어요!", Toast.LENGTH_SHORT).show()
    }*/
}
