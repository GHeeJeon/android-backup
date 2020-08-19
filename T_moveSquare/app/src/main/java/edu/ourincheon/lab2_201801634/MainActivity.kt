package edu.ourincheon.lab2_201801634

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val temp = editText.text.toString()
            if (temp.length > 0) {        //if (temp.length > 0)
                var value:Float = temp.toFloat()
                if (radioButton.isChecked){ //섭씨를 화씨로
                    convertCelsiusToFahrenheit(value)
                } else if (radioButton2.isChecked){ //화씨를 섭씨로
                    convertFahrenheitToCelsius(value)
                }
            }
            else{
                showToast("값을 입력하세요.")
            }
        }
    }

    private fun convertCelsiusToFahrenheit(celsius:Float){
        val fahrenheit = (celsius * 9)/5 + 32
        var temp = String.format("%.if", fahrenheit)
        editText.setText("섭씨 : $celsius C --> 화씨 : $temp F")
    }

    private fun convertFahrenheitToCelsius(fahrenheit:Float){
        val celsius = ((fahrenheit - 32) * 5) / 9
        var temp = String.format("%.if", celsius)
        editText.setText("화씨 : $fahrenheit F --> 섭씨 : $temp C")
    }

    private fun showToast(mag:String) {
        Toast.makeText(applicationContext, mag, Toast.LENGTH_SHORT).show()
    }
}
