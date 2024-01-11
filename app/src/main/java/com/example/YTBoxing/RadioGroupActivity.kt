package com.example.YTBoxing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.ImageView
import android.widget.RadioButton
import androidx.cardview.widget.CardView

class RadioGroupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_group)

        //buttonBack settings here
        val imageViewBack = this.findViewById<ImageView>(R.id.buttonBack)
        imageViewBack.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

    }
    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.radio_pirates ->
                    if (checked) {
                        // Pirates are the best
                    }
                R.id.radio_ninjas ->
                    if (checked) {
                        // Ninjas rule
                    }
            }
        }
    }

}