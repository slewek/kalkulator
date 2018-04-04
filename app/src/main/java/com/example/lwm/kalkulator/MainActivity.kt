package com.example.lwm.kalkulator

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val stos : MutableList<Double> = arrayListOf()
    val REQUEST_CODE = 1000
    var na_stosie=4
    var dokladnosc = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sprawdz_stos()
        uaktualnij()
    }
    fun button_0_click(v: View){
        editText.text.append("0")
    }
    fun button_1_click(v: View){
        editText.text.append("1")

    }
    fun button_2_click(v: View){
        editText.text.append("2")
    }
    fun button_3_click(v: View){
        editText.text.append("3")

    }
    fun button_4_click(v: View){
        editText.text.append("4")

    }
    fun button_5_click(v: View){
        editText.text.append("5")

    }
    fun button_6_click(v: View){
        editText.text.append("6")

    }
    fun button_7_click(v: View){
        editText.text.append("7")

    }
    fun button_8_click(v: View){
        editText.text.append("8")

    }
    fun button_9_click(v: View){
        editText.text.append("9")

    }
    fun uaktualnij(){
        editText.text.clear()
        for (i in na_stosie downTo 1){
            editText.text.append(i.toString()+":")
            if(stos.size>=i){
                editText.text.append(("%." + dokladnosc + "f").format(stos[stos.size-i]))
            }
            editText.text.append("\n")

        }
    }
    fun sprawdz_stos(){
        while(stos.size<=na_stosie){
            stos.add(0.0)
        }
    }

    fun button_enter_click(v: View){
            if (editText.text.endsWith("\n")) {
                stos.add(stos.last())
            } else {
                stos.add(editText.text.split("\n").last().toDouble())
            }
            uaktualnij()
    }

    fun swap_click(v: View){
        val res1 = stos[stos.size-1]
        val res2 = stos[stos.size-2]
        stos.removeAt(stos.size-1)
        stos.removeAt(stos.size-1)
        stos.add(res1)
        stos.add(res2)
        uaktualnij()
    }

    fun drop_click(v: View){
        stos.removeAt(stos.size-1)
        sprawdz_stos()
        uaktualnij()
    }

    fun clear_click(v: View){
        stos.clear()
        sprawdz_stos()
        uaktualnij()
    }

    fun plus_click(v: View){
        val res = stos[stos.size-1] + stos[stos.size-2]
        stos.removeAt(stos.size-1)
        stos.removeAt(stos.size-1)
        sprawdz_stos()
        stos.add(res)
        uaktualnij()
    }

    fun minus_click(v: View) {
        val res = stos[stos.size - 2] - stos[stos.size - 1]
        stos.removeAt(stos.size - 1)
        stos.removeAt(stos.size - 1)
        sprawdz_stos()
        stos.add(res)
        uaktualnij()
    }
    fun multiply_click(v: View){
        val res = stos[stos.size-1].toInt() * stos[stos.size-2]
        stos.removeAt(stos.size-1)
        stos.removeAt(stos.size-1)
        sprawdz_stos()
        stos.add(res)
        uaktualnij()
    }
    fun division_click(v: View){
        val res = stos[stos.size-2].toInt() / stos[stos.size-1]
        stos.removeAt(stos.size-1)
        stos.removeAt(stos.size-1)
        sprawdz_stos()
        stos.add(res)
        uaktualnij()
    }
    fun sqrt_click(v: View){
        val res = Math.sqrt(stos[stos.size-1])
        stos.removeAt(stos.size-1)
        sprawdz_stos()
        stos.add(res)
        uaktualnij()
    }
    fun char_click(v: View){
        val res = (stos[stos.size-1] * -1)
        stos.removeAt(stos.size-1)
        sprawdz_stos()
        stos.add(res)
        uaktualnij()
    }

    fun dot_Click(v:View){
        editText.text.append(".")
    }

    fun power_click(v: View){
        val res = Math.pow(stos[stos.size-2],stos[stos.size-1])
        stos.removeAt(stos.size-1)
        stos.removeAt(stos.size-1)
        sprawdz_stos()
        stos.add(res)
        uaktualnij()
    }

    fun c_click(v: View){
        if(editText.text.last().toString()!="\n") {
            val text = editText.text.substring(0, editText.text.length - 1)
            editText.text.clear()
            editText.text.append(text)
        }
    }

    fun setting_click(v: View) {
        val i = Intent(this, SettingActivity::class.java)
        i.putExtra("Parametr","Twoje dane")
        startActivityForResult(i,REQUEST_CODE)

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if((requestCode==REQUEST_CODE)
                && (resultCode== Activity.RESULT_OK)){
            if(data!=null){
                if(data.hasExtra("stos_liczba")){
                    na_stosie = data.extras.getString("stos_liczba").toInt()
                }
                if(data.hasExtra("color")){
                    editText.setBackgroundColor(data.extras.getInt("color"))
                }
                if(data.hasExtra("dokladnosc")){
                    dokladnosc = data.extras.getString("dokladnosc").toInt()
                }
                uaktualnij()

            }
        }
    }


    }
