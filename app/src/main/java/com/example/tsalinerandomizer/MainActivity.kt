package com.example.tsalinerandomizer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    // lateinit = Late initialization allowing us to set the value of the variables later.
    private lateinit var tapHereButton: Button
    private lateinit var leftArrowButton: ImageButton
    private lateinit var rightArrowButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // findViewByID lets us find our objects view id and call functions on that view. 
        tapHereButton = findViewById(R.id.tap_here_button)
        leftArrowButton = findViewById(R.id.left_arrow)
        rightArrowButton = findViewById(R.id.right_arrow)

        tapHereButton.setOnClickListener {
            showRandomArrow()
        }

        leftArrowButton.setOnClickListener {
            showTapHereButton(leftArrowButton)
        }

        rightArrowButton.setOnClickListener {
            showTapHereButton(rightArrowButton)
        }
    }
    // Creates A function that hides a ImageButton and shows our tapHereButton
    private fun showTapHereButton(button: ImageButton) {
        button.visibility = View.INVISIBLE
        tapHereButton.visibility = View.VISIBLE
    }
    // Hides the TapHereButton and selects a random view button to reveal.
    private fun showRandomArrow() {
        tapHereButton.visibility = View.INVISIBLE
        // Selects a random direction from our lift of directions.
        val direction = listOf("Left", "Right").random()
        if (direction == "Left") {
            leftArrowButton.visibility = View.VISIBLE
        } else {
            rightArrowButton.visibility = View.VISIBLE
        }
    }
}