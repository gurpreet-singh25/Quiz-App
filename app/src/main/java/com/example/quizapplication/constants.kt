package com.example.quizapplication

object constants {


    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS :String = "total_questions"
    const val CORRECT_ANSWER :String = "correct_answer"


    fun GetQuestions():ArrayList<Questions>{

        val questionslist = ArrayList<Questions>()

//  QUESTION 1:
        val ques1 = Questions(
            1 , "Which country does this flag belong to ?" ,
            R.drawable.argentina,
            "Switzerland" ,"Denmark" ,"Argentina" , "Europe"
            , 3,
        )

        questionslist.add(ques1)

//  QUESTION 2:
        val ques2 = Questions(
            2 , "Which company owns this logo ?" ,
            R.drawable.hermes_ccexpress,
            "Da Milano " ,"Hermes" ,"Baggit " , "Caprese"
            , 2,
        )

        questionslist.add(ques2)

        //  QUESTION 3:
        val ques3 = Questions(
            3, "From which country did this musical instrument originally come from?" ,
            R.drawable.guitar_ccexpress,
            "Spain " ," Germany " ,"France " , "New Zealand"
            , 1,
        )

        questionslist.add(ques3)

        //  QUESTION 4:
        val ques4 = Questions(
            4 , "In which year did the British passenger liner Titanic sink in the North Atlantic Ocean, which made more than 1,500 people die?" ,
            R.drawable.titaniccc,
            "1901" ," 1912 " ,"1923 " , "1942 "
            , 2,
        )

        questionslist.add(ques4)


        //  QUESTION 5:
        val ques5 = Questions(
            5 , "What is the name of the first U.S. President on the right of this picture?" ,
            R.drawable.memmorialstatue_ccexpress,
            " George Washington" ," Thomas Jefferson " ,"Vernon Scoville " , "Abraham Lincoln "
            , 4,
        )

        questionslist.add(ques5)


        //  QUESTION 6:
        val ques6 = Questions(
            6 , "What is the name of this religion, which is mainly popular in Asian countries?" ,
            R.drawable.buddhism_ccexpress,
            " Hinduism" ," Buddhism " ,"Sikh " , "Muslim "
            , 2,
        )

        questionslist.add(ques6)



        return questionslist

    }
}