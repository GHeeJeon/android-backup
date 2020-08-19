package edu.ourincheon.t_fragment_toolbar

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.toolbar_fragment.*
import java.util.*

class ToolbarFragment:Fragment() ,
                SeekBar.OnSeekBarChangeListener{

    var seekValue:Int = 10
    var activityCallBack: ToolbarListener? = null

    interface ToolbarListener {
        fun onButtonClicked(fontSize:Int, text:String)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try{
            activityCallBack = context as ToolbarListener

        }catch(e: ClassCastException){
            throw ClassCastException(context?.toString()
                + "must implement ToolbarListener")
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.toolbar_fragment, container, false
        )
        val seekbar:SeekBar = rootView.findViewById(R.id.seekBar)
        val button: Button = rootView.findViewById(R.id.button)

        seekBar.setOnSeekBarChangeListener(this)
        button.setOnClickListener { v->
            buttonClicked(v)
        }
        return rootView
    }

    private fun buttonClicked(view:View){
        activityCallBack?.onButtonClicked(seekValue, editText.text.toString())
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        seekValue = progress
    }

    override fun onStartTrackingTouch(p0: SeekBar?) {
    }

    override fun onStopTrackingTouch(p0: SeekBar?) {
    }
}