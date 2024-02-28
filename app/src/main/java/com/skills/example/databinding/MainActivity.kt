package com.skills.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val greetingTextView = findViewById<TextView>(R.id.tv_greeting)
        val nameEditText = findViewById<EditText>(R.id.et_enter_name)
        val submitButton = findViewById<Button>(R.id.btn_submit)

        submitButton.setOnClickListener {
            val name = nameEditText.text.toString()
            greetingTextView.text = "Hi, $name"
        }
    }
}