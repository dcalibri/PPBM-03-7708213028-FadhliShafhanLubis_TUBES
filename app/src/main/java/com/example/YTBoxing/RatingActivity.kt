package com.example.YTBoxing

import android.content.Intent
import android.graphics.PorterDuff
import android.graphics.drawable.LayerDrawable
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RatingActivity : AppCompatActivity() {
    private var rate: RatingBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating)

        // Initialize the RatingBar
        rate = findViewById(R.id.RatingBar)

        // Change the color of the progress in the RatingBar to green
        val rating = rate?.progressDrawable as LayerDrawable
        val stars = rating.getDrawable(2) // The third layer is the stars

        stars.setColorFilter(resources.getColor(R.color.Yellow), PorterDuff.Mode.SRC_ATOP)

        // Set an OnClickListener for the "Rate" button
        val imageViewBack = findViewById<ImageView>(R.id.buttonBack)
        imageViewBack.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
    }

    // This function is called when the "Rate" button is clicked
    fun Rate(view: View) {
        val t = findViewById<TextView>(R.id.Result)
        t.text = "You Rated: " + rate?.rating.toString()
    }
}




