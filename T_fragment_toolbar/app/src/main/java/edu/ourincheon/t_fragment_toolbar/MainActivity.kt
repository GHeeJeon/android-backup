package edu.ourincheon.t_fragment_toolbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(),
    ToolbarFragment.ToolbarListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onButtonClicked(fontSize: Int, text: String) {
        val textFragment = supportFragmentManager.findFragmentById(R.id.text_fragment)
        as TextFragment
        textFragment.changeTextProperties(fontSize, text)
    }
}
