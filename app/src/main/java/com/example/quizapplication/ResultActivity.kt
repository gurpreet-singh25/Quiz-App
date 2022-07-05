package com.example.quizapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvName :TextView = findViewById(R.id.result_username)
        val tvScore : TextView = findViewById(R.id.tv_score)
        val btnFinish : Button = findViewById(R.id.btn_finish)


        tvName.text = intent.getStringExtra(constants.USER_NAME)
        val totalQuestions = intent.getIntExtra(constants.TOTAL_QUESTIONS , 0)
        val correctquestions = intent.getIntExtra(constants.CORRECT_ANSWER , 0)
        tvScore.text = "Your score is $correctquestions out of $totalQuestions"


        btnFinish.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }



    }






//    resultInputTextView.text = "${input_text.text}"

}