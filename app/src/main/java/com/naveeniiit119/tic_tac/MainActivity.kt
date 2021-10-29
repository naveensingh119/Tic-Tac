package com.naveeniiit119.tic_tac

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.forEach
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var activePlayer= 0
    private val getState = intArrayOf(2,2,2,2,2,2,2,2,2)
    private val winningPositions = arrayOf(intArrayOf(0,1,2), intArrayOf(3,4,5), intArrayOf(6,7,8), intArrayOf(0,3,6),
        intArrayOf(1,4,7),
        intArrayOf(2,5,8),
        intArrayOf(0,4,8),
        intArrayOf(2,4,6))
    private var gameActive:Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }



    fun dropIn(view: android.view.View) {

        val tappedCounter = (view.tag.toString()).toInt()

        if (getState[tappedCounter] == 2&&gameActive) {
            getState[tappedCounter] = activePlayer
            view.translationY = -1500F
            if(activePlayer == 0) {
                view.setBackgroundResource(R.drawable.zero)
                activePlayer=1
            } else {
                view.setBackgroundResource(R.drawable.x)
                activePlayer=0
            }

            view.animate().translationYBy(1500F).rotation(1800F).setDuration(300)

            for (winningPosition in winningPositions) {
                if (getState[winningPosition[0]] == getState[winningPosition[1]] && getState[winningPosition[1]] == getState[winningPosition[2]] && getState[winningPosition[2]] != 2) {
                    gameActive = false
                    var winner :String
                    if (activePlayer == 1) {
                       winner = textView3.editableText.toString()
                    } else {
                       winner=textView4.editableText.toString()
                    }
                    textView2.setText(winner+" is Win Hurrah!")

                     textView2.visibility=View.VISIBLE
                    button.visibility=View.GONE
                    button1.visibility=View.VISIBLE

                }
            }
        }
    }

    fun startGame(view: android.view.View) {
        var firstPlayer = textView3.editableText.toString()
        var secondPlayer = textView4.editableText.toString()
        if(firstPlayer.isNotEmpty()&&secondPlayer.isNotEmpty()&&firstPlayer!=secondPlayer)
        {
            gameActive=true
        }
        else{
            Toast.makeText(this,"Enter the Valid Name",Toast.LENGTH_LONG).show()
        }

    }

    fun PlayAgain(view: android.view.View) {
        for(i in 1..getState.size) {
            getState[i - 1] = 2
        }
       imageView8.setBackgroundResource(R.drawable.blank)
        imageView7.setBackgroundResource(R.drawable.blank)
        imageView6.setBackgroundResource(R.drawable.blank)
        imageView5.setBackgroundResource(R.drawable.blank)
        imageView4.setBackgroundResource(R.drawable.blank)
        imageView3.setBackgroundResource(R.drawable.blank)
        imageView2.setBackgroundResource(R.drawable.blank)
        imageView1.setBackgroundResource(R.drawable.blank)
        imageView0.setBackgroundResource(R.drawable.blank)

        button1.visibility=View.GONE
        button.visibility=View.VISIBLE
        activePlayer=0
    }


}







