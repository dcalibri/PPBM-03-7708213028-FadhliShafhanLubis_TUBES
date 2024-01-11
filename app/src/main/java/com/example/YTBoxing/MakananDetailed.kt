


package com.example.YTBoxing

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.YTBoxing.R

class MakananDetailed : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_makanandetailed)

        val intent = intent
        if (intent != null) {
            val name = intent.getStringExtra("name")
            val time = intent.getStringExtra("time")
            val ingredients = intent.getStringExtra("ingredients") // Gunakan getStringExtra untuk string
            val desc = intent.getStringExtra("desc") // Gunakan getStringExtra untuk string
            val image = intent.getIntExtra("image", R.drawable.makanan_maggi)

            val detailNamaDepan = findViewById<TextView>(R.id.detailName)
            val detailTime = findViewById<TextView>(R.id.detailTime)
            val detailDesc = findViewById<TextView>(R.id.detailDesc)
            val detailIngredients = findViewById<TextView>(R.id.detailIngredients)
            val detailImage = findViewById<ImageView>(R.id.detailImage)

            detailNamaDepan.text = name
            detailTime.text = time
            detailDesc.text = desc // Gunakan setText untuk string
            detailIngredients.text = ingredients // Gunakan setText untuk string
            detailImage.setImageResource(image)
        }

        // Set an OnClickListener for the "Rate" button
        val imageViewBack = findViewById<ImageView>(R.id.buttonBack)
        imageViewBack.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

    }


}
