package com.example.romantoarabicnumerals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_arabic.*

class ArabicActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_arabic)

        arabicNumeral.text = intent.getIntExtra("number", -1).toString()
    }
}
