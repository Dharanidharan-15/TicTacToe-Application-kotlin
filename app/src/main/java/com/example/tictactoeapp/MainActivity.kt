package com.example.tictactoeapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.Toast
import com.example.tictactoeapp.R.drawable
import com.example.tictactoeapp.databinding.ActivityMainBinding
import com.lrm.tictactoe.MyBounceInterpolator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var player = "P1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            box1.setOnClickListener { onButtonClick(binding.box1) }
            box2.setOnClickListener { onButtonClick(binding.box2) }
            box3.setOnClickListener { onButtonClick(binding.box3) }
            box4.setOnClickListener { onButtonClick(binding.box4) }
            box5.setOnClickListener { onButtonClick(binding.box5) }
            box6.setOnClickListener { onButtonClick(binding.box6) }
            box7.setOnClickListener { onButtonClick(binding.box7) }
            box8.setOnClickListener { onButtonClick(binding.box8) }
            box9.setOnClickListener { onButtonClick(binding.box9) }

            resetButton.setOnClickListener { resetGame() }
        }
    }

    // reset game function
    @SuppressLint("UseCompatLoadingForDrawables")
    private fun resetGame() {
        player = "P1"

        // getting back to empty square containers
        binding.apply {
            box1.background = resources.getDrawable(drawable.square)
            box2.background = resources.getDrawable(drawable.square)
            box3.background = resources.getDrawable(drawable.square)
            box4.background = resources.getDrawable(drawable.square)
            box5.background = resources.getDrawable(drawable.square)
            box6.background = resources.getDrawable(drawable.square)
            box7.background = resources.getDrawable(drawable.square)
            box8.background = resources.getDrawable(drawable.square)
            box9.background = resources.getDrawable(drawable.square)

            // changing the element text back to empty
            box1.text = ""
            box2.text = ""
            box3.text = ""
            box4.text = ""
            box5.text = ""
            box6.text = ""
            box7.text = ""
            box8.text = ""
            box9.text = ""

            //turning all box containers to take up values
            box1.isClickable = true
            box2.isClickable = true
            box3.isClickable = true
            box4.isClickable = true
            box5.isClickable = true
            box6.isClickable = true
            box7.isClickable = true
            box8.isClickable = true
            box9.isClickable = true

            //turning back the result text
            tvResult.text = ""
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun onButtonClick(button : Button){

        val anim =AnimationUtils.loadAnimation(this,R.anim.bounce)
        val interpolator = MyBounceInterpolator(0.2,20.0)
        anim.interpolator = interpolator
        if(button.text == ""){
            if(player == "P1"){
                button.background = resources.getDrawable(drawable.x)
                button.text = "x"
                button.isClickable = false
                button.startAnimation(anim)
                player = "P2"
            }else {
                button.background = resources.getDrawable(drawable.o)
                button.text = "o"
                button.isClickable = false
                button.startAnimation(anim)
                player = "P1"
            }
        }
        win()
    }

    // winning logic function
    @SuppressLint("SetTextI18n")
    private fun win(){
        binding.apply {
            if( (box1.text == "x" && box2.text == "x" && box3.text == "x") ||
                (box4.text == "x" && box5.text == "x" && box6.text == "x") ||
                (box7.text == "x" && box8.text == "x" && box9.text == "x") ||
                (box1.text == "x" && box4.text == "x" && box7.text == "x") ||
                (box2.text == "x" && box5.text == "x" && box8.text == "x") ||
                (box3.text == "x" && box6.text == "x" && box9.text == "x") ||
                (box1.text == "x" && box5.text == "x" && box9.text == "x") ||
                (box3.text == "x" && box5.text == "x" && box7.text == "x") )
            {
                tvResult.text = "X won the Match"
                Toast.makeText(this@MainActivity,"X won the Match",Toast.LENGTH_SHORT).show()
                disableButtons()
            }
            else if( (box1.text == "o" && box2.text == "o" && box3.text == "o") ||
                (box4.text == "o" && box5.text == "o" && box6.text == "o") ||
                (box7.text == "o" && box8.text == "o" && box9.text == "o") ||
                (box1.text == "o" && box4.text == "o" && box7.text == "o") ||
                (box2.text == "o" && box5.text == "o" && box8.text == "o") ||
                (box3.text == "o" && box6.text == "o" && box9.text == "o") ||
                (box1.text == "o" && box5.text == "o" && box9.text == "o") ||
                (box3.text == "o" && box5.text == "o" && box7.text == "o") )
            {
                tvResult.text = "O won the Match"
                Toast.makeText(this@MainActivity,"O won the Match",Toast.LENGTH_SHORT).show()
                disableButtons()
            }
            else if( box1.text != "" && box2.text != "" && box3.text != "" && box4.text != "" &&
                box5.text != "" && box6.text != "" && box7.text != "" && box8.text != "" && box9.text != ""){
                tvResult.text = "Match Draw"
                Toast.makeText(this@MainActivity,"it's a Tie.. Play Again...",Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Disable button click to hold back when reached results
    private fun disableButtons(){
        binding.apply {
            box1.isClickable = false
            box2.isClickable = false
            box3.isClickable = false
            box4.isClickable = false
            box5.isClickable = false
            box6.isClickable = false
            box7.isClickable = false
            box8.isClickable = false
            box9.isClickable = false
        }
    }
}