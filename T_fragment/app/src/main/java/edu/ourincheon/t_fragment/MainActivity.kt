package edu.ourincheon.t_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
            FragmentA.ButtonListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(fragment_container != null){
            if(savedInstanceState != null)
                return

            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, FragmentA())
                .commit()    //실행
        }
    }

    override fun buttonClicked() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, FragmentB())
            .addToBackStack(null)
            .commit()
    }

    fun selectFragment(view: View){
        var fr:Fragment = FragmentA()
        if(view.id == R.id.button2){
            fr = FragmentB()
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fr)
            .addToBackStack(null)
            .commit()
    }
}
