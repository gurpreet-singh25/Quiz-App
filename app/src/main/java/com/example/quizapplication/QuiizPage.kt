package com.example.quizapplication

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.graphics.Color
import android.graphics.Color.parseColor
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuiizPage : AppCompatActivity(), View.OnClickListener {


    private var mCurrentPosition : Int = 1
    private var mQuestionList : ArrayList<Questions>? = null
    private var mSelectedOptionPosition : Int = 0
    private var mUserName :String? = null
    private var mCorrectAnswers : Int =0




    private var ProgressBar : ProgressBar? = null
    private var TvProgress : TextView? = null
    private var TvQuestion : TextView? = null
    private var ivImage : ImageView? = null
    private var tvOptionOne : TextView? = null
    private var tvOptionTwo : TextView? = null
    private var tvOptionThree: TextView? = null
    private var tvOptionFour : TextView? = null
    private var btnSubmit: Button? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiiz_page)



        mUserName = intent.getStringExtra(constants.USER_NAME)
        ProgressBar= findViewById(R.id.progressBar)
        TvProgress = findViewById(R.id.tvprogress)
        TvQuestion = findViewById(R.id.tvquestion)
        ivImage = findViewById(R.id.iv_image)
        tvOptionOne = findViewById(R.id.tv_optionOne)
        tvOptionTwo = findViewById(R.id.tv_optionTwo)
        tvOptionThree = findViewById(R.id.tv_optionThree)
        tvOptionFour = findViewById(R.id.tv_optionFour)
        btnSubmit = findViewById(R.id.btnSubmit)

        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)


        mQuestionList = constants.GetQuestions()


        setQuestion()
        defaultOptionsView()


    }

    private fun setQuestion() {

        defaultOptionsView()



       // mCurrentPosition = 1
        val question: Questions = mQuestionList!![mCurrentPosition - 1]

        ProgressBar?.progress = mCurrentPosition
        TvProgress?.text = "$mCurrentPosition/${ProgressBar?.max}"
        ivImage?.setImageResource(question.image)
        TvQuestion?.text = question.question
        tvOptionOne?.text = question.Optionone
        tvOptionTwo?.text = question.Optiontwo
        tvOptionThree?.text = question.Optionthree
        tvOptionFour?.text = question.Optionfour

        if(mCurrentPosition == mQuestionList!!.size){
            btnSubmit?.text = "FINISH"
        }else{
            btnSubmit?.text = "SUBMIT"
        }
    }


    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()

        tvOptionOne?.let{
            options.add(0,it)
        }
        tvOptionTwo?.let{
            options.add(1,it)
        }
        tvOptionThree?.let{
            options.add(2,it)
        }
        tvOptionFour?.let{
            options.add(3,it)
        }

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background= ContextCompat.getDrawable(this,
            R.drawable.default_option_border_bg)
        }


    }

    private fun selectedOptionView(tv:TextView, selectedOptionNumber : Int){
        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNumber

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background= ContextCompat.getDrawable(this,
            R.drawable.selected_option_background_bg)
    }

    override fun onClick(view: View?) {
        when (view?.id){
            R.id.tv_optionOne->{
                tvOptionOne?.let{
                    selectedOptionView(it,1)
                }

            }
            R.id.tv_optionTwo->{
                tvOptionTwo?.let{
                    selectedOptionView(it,2)
                }

            }

            R.id.tv_optionThree->{
                tvOptionThree?.let{
                    selectedOptionView(it,3)
                }

            }

            R.id.tv_optionFour->{
                tvOptionFour?.let{
                    selectedOptionView(it,4)
                }

            }

            R.id.btnSubmit->{
                btnSubmit?.let{
                    if(mSelectedOptionPosition == 0){
                        mCurrentPosition++
                        when {
                            mCurrentPosition <= mQuestionList!!.size ->{

                                setQuestion()
                            }else ->{
                                val intent = Intent(this, ResultActivity :: class.java)

                                intent.putExtra(constants.USER_NAME ,mUserName)
                                intent.putExtra(constants.CORRECT_ANSWER , mCorrectAnswers)
                                intent.putExtra(constants.TOTAL_QUESTIONS , mQuestionList?.size)
                                startActivity(intent)
                                finish()

                            }

                        }

                    }
                    else{
                        val question = mQuestionList?.get(mCurrentPosition-1)
                        if(question!! .CorrectAnswer != mSelectedOptionPosition){
                            answerView(mSelectedOptionPosition , R.drawable.wrong_option_border_bg)
                        }else{
                            mCorrectAnswers++
                        }

                        answerView(question.CorrectAnswer , R.drawable.correct_option_border_bg)

                        if(mCurrentPosition == mQuestionList!!.size){
                            btnSubmit?.text ="FINISH"

                        }
                        else{
                            btnSubmit?.text = "Go To Next Question"

                        }
                        mSelectedOptionPosition = 0


                    }

                }
            }

        }

    }
    private fun answerView(answer:Int , drawableView: Int){

        when (answer){
            1 -> {
                tvOptionOne?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 -> {
                tvOptionTwo?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 -> {
                tvOptionThree?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 -> {
                tvOptionFour?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }

        }

    }
}