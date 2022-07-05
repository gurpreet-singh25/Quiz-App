package com.example.quizapplication

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi


class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1 : Button = findViewById(R.id.btn1)
        val input_text : EditText = findViewById(R.id.inputText)
        btn1.setOnClickListener {
            if (input_text.text.isEmpty()) {
                Toast.makeText(this, "Please enter your name ",Toast.LENGTH_LONG).show()

            }
            else{
                val intent = Intent(this , QuiizPage::class.java)
                intent.putExtra(constants.USER_NAME ,input_text.text.toString())
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
            }

        }


    }
}