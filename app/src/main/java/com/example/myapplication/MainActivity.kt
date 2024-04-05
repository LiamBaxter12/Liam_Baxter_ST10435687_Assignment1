package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {

        private lateinit var ageEditText: EditText
        private lateinit var resultTextView: TextView

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            ageEditText = findViewById(R.id.numberText)
            resultTextView = findViewById(R.id.editHistoryText)

            val generateButton: Button = findViewById(R.id.Generate)
            val clearButton: Button = findViewById(R.id.Clear)

            generateButton.setOnClickListener {
                generateHistory()
            }

            clearButton.setOnClickListener {
                clearFields()
            }
        }

        @SuppressLint("SetTextI18n")
        private fun generateHistory() {
            val ageText = ageEditText.text.toString()

            if (ageText.isNotEmpty()) {
                val age = ageText.toInt()

          // setting if statement for ages outside  certain age range.
                val historicalFigure = getHistoricalFigure(age)
                if (historicalFigure.isNotEmpty()) {
                    resultTextView.text = "You are the same age as $historicalFigure who is a famous historical figure"
                } else {
                    resultTextView.text = "There is no famous historical figure for this age"
                }
            } else {
                resultTextView.text = "Please enter an age"
            }
        }

        private fun clearFields() {
            ageEditText.text.clear()
            resultTextView.text = ""
        }

    // getting age to correlate to historical figures.
        private fun getHistoricalFigure(age: Int): String {
            return when (age) {
                76 -> "Albert Einstein"
                92 -> "Rosa Parks"
                84 -> "Thomas Edison"
                95 -> "Nelson Mandela"
                39 -> "Martin Luther King Jr."
                52 -> "William Shakespeare"
                67 -> "George Washington"
                86 -> "Nikola Tesla"
                75 -> "Alexander Graham Bell"
                56 -> "Abraham Lincoln"
                else -> ""
            }
        }
    }
