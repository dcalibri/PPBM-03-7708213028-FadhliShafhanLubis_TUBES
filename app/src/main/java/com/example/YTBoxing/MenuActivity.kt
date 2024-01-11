package com.example.YTBoxing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView


class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        supportActionBar?.title = "Menu"

        val cardView1: CardView = findViewById(R.id.cardView1)
        val cardView2: CardView = findViewById(R.id.cardView2)
        val cardView3: CardView = findViewById(R.id.cardView3)
        val cardView4: CardView = findViewById(R.id.cardView4)
        val cardView5: CardView = findViewById(R.id.cardView5)

        val cardView6: CardView = findViewById(R.id.cardView6)
        val cardView7: CardView = findViewById(R.id.cardView7)
        val cardView8: CardView = findViewById(R.id.cardView8)

        cardView1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        cardView2.setOnClickListener {
            val intent = Intent(this, RadioGroupActivity::class.java)
            startActivity(intent)
        }

        cardView3.setOnClickListener {
            val intent = Intent(this, SpinnerActivity::class.java)
            startActivity(intent)
        }

        cardView4.setOnClickListener {
        val intent = Intent(this, RatingActivity::class.java)
        startActivity(intent)
        }

        cardView5.setOnClickListener {
            val intent = Intent(this, LoginUtamaActivity::class.java)
            startActivity(intent)
        }

        cardView6.setOnClickListener {
            val intent = Intent(this, SimpleListView::class.java)
            startActivity(intent)
        }

        cardView7.setOnClickListener {
            val intent = Intent(this, MakananListView::class.java)
            startActivity(intent)
        }

        cardView8.setOnClickListener {
            val intent = Intent(this, SlideShowUfcPoster::class.java)
            startActivity(intent)
        }


    }
        // Add similar code for other CardViews (cardView3 and cardView4)
}

