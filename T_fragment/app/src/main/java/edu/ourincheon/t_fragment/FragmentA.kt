package edu.ourincheon.t_fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentA : Fragment() {

    var activityCallback:ButtonListener? = null

    interface ButtonListener{
        fun buttonClicked()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try{
            activityCallback = context as ButtonListener
        }catch (e:ClassCastException){
            throw ClassCastException(context?.toString() +
            " must implement ButtonListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_a,
            container, false)
        val b: Button = rootView.findViewById(R.id.button3)
        b.setOnClickListener {
            buttonClicked(it)
        }
        return rootView
    }
    private fun buttonClicked(view:View){
        //hosting activity에서 구현하는 callback 메소드 호출
        activityCallback?.buttonClicked()

    }
}