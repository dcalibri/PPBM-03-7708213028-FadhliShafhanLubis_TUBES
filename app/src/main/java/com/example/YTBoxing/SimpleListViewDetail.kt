package com.example.YTBoxing

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class SimpleListViewDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the activity to run in immersive mode
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)

        // Hide the status bar
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.simple_listview_detail)

        //back button
        val gotosimple = findViewById<CardView>(R.id.simple_detail_gotohome)
        gotosimple.setOnClickListener {
            finish() // Go back to the previous activity (SimpleListView)
        }

//kunci
        // Retrieve selected fighter name from Intent extras
        val selectedFighter = intent.getStringExtra("selectedFighter")

        // Display selected fighter details in SimpleListViewDetail
        val fighterImageView: ImageView = findViewById(R.id.fighter_in_imageview)

        // Set the image based on the fighter name
        val imageResourceId = resources.getIdentifier(selectedFighter?.replace(" ", "_")?.
        toLowerCase(), "drawable", packageName)
        fighterImageView.setImageResource(imageResourceId)

        //text----
        val fighterNameTextView: TextView = findViewById(R.id.fighter_name)
        fighterNameTextView.text = selectedFighter

        val fighterWorthTextView: TextView = findViewById(R.id.fighter_worth)
        // Retrieve fighter worth from resources based on the selected fighter name
        val fighterWorthResourceId = resources.getIdentifier(selectedFighter?.replace(" ", "_")?.
        toLowerCase(), "string", packageName)
        fighterWorthTextView.text = getString(fighterWorthResourceId)


    }

    override fun onBackPressed() {
        // Handle the back button press
        // For example, navigate to a certain activity
        val intent = Intent(this, SimpleListView::class.java)
        startActivity(intent)
    }
}








