package com.example.YTBoxing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.content.Intent
import android.view.Gravity
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.core.view.WindowCompat
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.sidesheet.SideSheetDialog
import com.ncorti.slidetoact.SlideToActView


class SlideShowUfcPoster : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        WindowCompat.setDecorFitsSystemWindows(
            window,false
        )

        val imageList = ArrayList<SlideModel>() // Create image list

        // imageList.add(SlideModel("String Url" or R.drawable)
        // imageList.add(SlideModel("String Url" or R.drawable, "title") You can add title

        imageList.add(SlideModel(R.drawable.ufc290, "Poster 1", ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.ufc291, "Poster 2", ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.ufc292, "Poster 3", ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.ufc294, "Poster 4", ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.ufc295, "Poster 5", ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.ufc296, "Poster 6", ScaleTypes.FIT))

        val imageSlider = findViewById<ImageSlider>(R.id.image_slider)
        imageSlider.setImageList(imageList)

        val ec = findViewById<CardView>(R.id.executiveC)
        ec.setOnClickListener {
            val intent = Intent(this, TabLayoutActivity::class.java)
            startActivity(intent)
            finish()}

        val hc = findViewById<CardView>(R.id.hardworkC)
        hc.setOnClickListener {
            val intent = Intent(this, TabLayoutActivity::class.java)
            startActivity(intent)
            finish()}

        val et = findViewById<CardView>(R.id.executiveT)
        et.setOnClickListener {
            val intent = Intent(this, TabLayoutActivity::class.java)
            startActivity(intent)
            finish()}

        val navView = findViewById<ImageView>(R.id.navView)
        navView.setOnClickListener {
            val sideSheetDialog = SideSheetDialog(this)
            sideSheetDialog.setContentView(R.layout.side_sheet)

            val sideSheetLayoutParams = sideSheetDialog.window?.attributes
            sideSheetLayoutParams?.gravity = Gravity.START
            sideSheetDialog.window?.attributes = sideSheetLayoutParams

            sideSheetDialog.show()
        }

        val slide = findViewById<SlideToActView>(R.id.sliderBottomSheet)
        slide.animDuration = 600
        slide.bumpVibration = 500
        slide.onSlideCompleteListener = object : SlideToActView.OnSlideCompleteListener {
            override fun onSlideComplete(view: SlideToActView) {
                val dialog = BottomSheetDialog(this@SlideShowUfcPoster) // Replace YourActivity with the actual name of your activity
                val view = layoutInflater.inflate(R.layout.bottom_sheet, null)
                dialog.setContentView(view)
                dialog.show()

                Handler().postDelayed({
                    // Check if the dialog is still showing before navigating
                    if (dialog.isShowing) {
                        dialog.dismiss() // Dismiss the bottom sheet if it's still open
                        // Navigate to another page here (replace with your actual navigation code)
                        val destinationIntent = Intent(this@SlideShowUfcPoster, TabLayoutActivity::class.java)
                        startActivity(destinationIntent)
                    }
                }, 3000)
            }
        }

    }

}