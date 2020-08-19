package edu.ourincheon.lab2_201801634

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Float.parseFloat
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val temp = editText.text.toString()
            if (temp.isNotEmpty()) {        //if (temp.length > 0)
                var value:Float = temp.toFloat()
                if (radioButton.isChecked){ //섭씨를 화씨로
                    convertCelsiusToFahrenheit(value)
                    tempConversion(temp)
                } else if (radioButton2.isChecked){ //화씨를 섭씨로
                    convertFahrenheitToCelsius(value)
                    tempConversion(temp)
                }
            }
            else{
                showToast("값을 입력하세요.")
            }
        }
        button2.setOnClickListener {
            editText.text = null
        }

    }


    private fun tempConversion(s: String){
        var value = 0f

        try{
            value = parseFloat(s)
            if (radioButton.isChecked)
                convertCelsiusToFahrenheit(value)
            else if (radioButton2.isChecked)
                convertFahrenheitToCelsius(value)
        }catch (e: NumberFormatException){
            e.printStackTrace()//숫자 이외의 값 들어왔을 때 예외처리
        }
    }

    private fun convertCelsiusToFahrenheit(celsius:Float){
        val fahrenheit = (celsius * 9)/5 + 32
        var temp = String.format("%.1f", fahrenheit)
        editText.setText("섭씨 : ${celsius}C --> 화씨 : ${temp}F")
    }

    private fun convertFahrenheitToCelsius(fahrenheit:Float){
        val celsius = ((fahrenheit - 32) * 5) / 9
        var temp = String.format("%.lf", celsius)
        editText.setText("화씨 : ${fahrenheit}F --> 섭씨 : ${temp}C")
    }

    private fun showToast(mag:String) {
        Toast.makeText(applicationContext, mag, Toast.LENGTH_SHORT).show()
    }
}
