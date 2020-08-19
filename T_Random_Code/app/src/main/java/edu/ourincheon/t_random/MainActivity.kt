package edu.ourincheon.t_random

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun generateRandNum():Int{

        val lottolist:MutableList<Int> = mutableListOf<Int>()

        for (i in 1..6){
            var j = 0
            do{
                j = Random().nextInt(45)+1
            } while (lottolist.contains(j))
            lottolist.add(j)
        }
        val sortedLotto = lottolist.sorted()
        println(sortedLotto)
        return 0
    }
}
