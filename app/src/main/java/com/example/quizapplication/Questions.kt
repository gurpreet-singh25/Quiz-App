package com.example.quizapplication

data class Questions(
    val id : Int,
    val question :String,
    val image :Int,

    val Optionone :String,
    val Optiontwo :String,
    val Optionthree :String,
    val Optionfour :String,
    val CorrectAnswer : Int,
    
)


//naming convetions :
/*
* Class NAme : Should start with Capital letter  i.e JavaClass
* function Name: should use camelcase  i.e. camelCase
* variables optionName ,optionOne
* */