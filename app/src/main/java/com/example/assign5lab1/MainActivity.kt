package com.example.assign5lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.app.AlertDialog
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var radioGroup1: RadioGroup
    private lateinit var checkbox1: CheckBox
    private lateinit var checkbox2: CheckBox
    private lateinit var checkbox3: CheckBox
    private lateinit var checkbox4: CheckBox
    private lateinit var submitBtn: Button
    private lateinit var resetBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radioGroup1 = findViewById(R.id.radioGroup1)
        checkbox1 = findViewById(R.id.checkbox1)
        checkbox2 = findViewById(R.id.checkbox2)
        checkbox3 = findViewById(R.id.checkbox3)
        checkbox4 = findViewById(R.id.checkbox4)
        submitBtn = findViewById(R.id.submitBtn)
        resetBtn = findViewById(R.id.resetBtn)

        submitBtn.setOnClickListener { showResultDialog() }
        resetBtn.setOnClickListener { resetQuiz() }

    }

    private fun showResultDialog() {
        val score = calculateScore()
        val currentDateAndTime = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())

        val message = "Congratulations! You submitted on $currentDateAndTime, you achieved $score%"

        AlertDialog.Builder(this)
            .setTitle("Quiz Result")
            .setMessage(message)
            .setPositiveButton("OK") { _, _ -> }
            .show()
    }

    private fun calculateScore(): Int {
        // Each question carries 50 points
        val scoreQuestion1 = if (radioGroup1.checkedRadioButtonId == R.id.option1) 50 else 0
        val scoreQuestion2 = if (checkbox1.isChecked && checkbox2.isChecked && checkbox3.isChecked && !checkbox4.isChecked) 50 else 0

        return scoreQuestion1 + scoreQuestion2
    }

    private fun resetQuiz() {
        radioGroup1.clearCheck()
        checkbox1.isChecked = false
        checkbox2.isChecked = false
        checkbox3.isChecked = false
        checkbox4.isChecked = false
    }
}