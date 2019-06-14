package com.example.romantoarabicnumerals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import java.util.stream.Collectors
import java.util.stream.Stream
import java.util.stream.Stream.*

class RomanActivity : AppCompatActivity() {

    val charToIntMap = hashMapOf(
        'i' to 1,
        'v' to 5,
        'x' to 10,
        'l' to 50,
        'c' to 100,
        'd' to 500,
        'm' to 1000
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun processNumeral(view: View) {
        startActivity(Intent(this, ArabicActivity::class.java).apply {
            putExtra("number", getRomanNumeral())
        })
    }

    //Reverse the Roman numeral list, then subtract values lower than the ones proceeding
    private fun getRomanNumeral(): Int {
        return numeralEditText.text.reversed()
            .map { v -> charToIntMap.get(v) }
            .reduce {
                    first, second -> calculate(first, second)
            }!!
    }

    private fun calculate(first: Int?, second: Int?): Int? {
        if(second!! < first!!) {
            return first - second
        } else {
            return first + second
        }
    }
}
