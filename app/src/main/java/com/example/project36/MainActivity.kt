package com.example.project36

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



getName(olya())


    }


    fun getName(human: human){



    }




   interface human{
       fun name(){


       }
       fun age()


   }



    class max():human

    {
        override fun name() {

        }

        override fun age() {

        }


    }
    class ruslan(  ) :human{
        override fun name() {

        }

        override fun age() {

        }


    }
    class olya():human{
        override fun name() {

        }

        override fun age() {

        }


    }




}