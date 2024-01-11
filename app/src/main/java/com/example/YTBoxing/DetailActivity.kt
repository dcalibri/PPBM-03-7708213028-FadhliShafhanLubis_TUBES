package com.example.YTBoxing


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Button
import android.content.Intent
import com.example.YTBoxing.data.Datasource
import com.example.YTBoxing.R

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Detail of Boxers"
        setContentView(R.layout.activity_detail)

        val NamaBoxerText = intent.getStringExtra("affirmationText")
        val imageResourceId = intent.getIntExtra("imageResourceId", 0)

        val dataSource = Datasource() // Pass the context here
        val affirmations = dataSource.loadAffirmations()


        // Pemeriksaan apakah NamaBoxerText tidak null dan tidak kosong
        val selectedAffirmation = if (!NamaBoxerText.isNullOrEmpty()) {
            affirmations.find { getString(it.stringResourceId) == NamaBoxerText }
        } else {
            null
        }


        val additionalText = selectedAffirmation?.additionalText?.let { getString(it) } ?: ""


        // Here, you can access the additional text from the Affirmation object
        //val additionalText = getString(affirmations[3].additionalText) // Change the index as needed



        //me-Tampilkan ke XML
        val detailImage = findViewById<ImageView>(R.id.detail_image)
        val detailText = findViewById<TextView>(R.id.detail_text)
        val additionalTextView = findViewById<TextView>(R.id.additional_text)

        detailText.text = NamaBoxerText
        detailImage.setImageResource(imageResourceId)

        // Pastikan nama resource string yang Anda gunakan sesuai dengan yang ada di file strings.xml
        additionalTextView.text = getString(R.string.scoreText) + " " + additionalText


        val backButton = findViewById<Button>(R.id.back_to_main_button)

        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}

