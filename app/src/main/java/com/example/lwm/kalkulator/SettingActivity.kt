package com.example.lwm.kalkulator

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_setting.*

class SettingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        val extras = intent.extras ?: return
        val message = extras.getString("Parametr")
        numberPicker_dokladnosc.minValue = 0
        numberPicker_dokladnosc.maxValue = 6
        numberPicker_dokladnosc.wrapSelectorWheel = true

        numberPicker_stos.minValue = 1
        numberPicker_stos.maxValue = 5
        numberPicker_stos.wrapSelectorWheel = true
    }


    override fun finish() {
        val data = Intent()
        data.putExtra("stos_liczba",numberPicker_stos.value.toString())
        println(radiogroup.checkedRadioButtonId)
        if(red_radio.id==radiogroup.checkedRadioButtonId)
            data.putExtra("color",Color.rgb(255,153,153))
        else if(blue_radio.id==radiogroup.checkedRadioButtonId)
            data.putExtra("color",Color.rgb(153,153,255))
        else if(green_radio.id==radiogroup.checkedRadioButtonId)
            data.putExtra("color",Color.rgb(153,255,153))
        else if(white_radio.id==radiogroup.checkedRadioButtonId)
            data.putExtra("color",Color.WHITE)

        data.putExtra("dokladnosc",numberPicker_dokladnosc.value.toString())
        setResult(Activity.RESULT_OK,data)
        super.finish()
    }
}
