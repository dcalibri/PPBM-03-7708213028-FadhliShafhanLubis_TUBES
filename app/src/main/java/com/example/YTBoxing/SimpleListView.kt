package com.example.YTBoxing

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class SimpleListView : AppCompatActivity() {

    val fighterNames = arrayOf(
        "Ali Stair",
        "Anderson Silva",
        "Andrei Arlovski",
        "BJ Penn",
        "Brock Lesnar",
        "Conor McGregor",
        "Georges St Pierre",
        "Khabib Nurmagomedov",
        "Rorion Gracie",
        "Tito Ortiz"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the activity to run in immersive mode
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)

        // Hide the status bar
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.simple_list_view)



        // Set up the ListView with the fighter names
        val listView: ListView = findViewById(R.id.fighter_list)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, fighterNames)
        listView.adapter = adapter

        // dapetin id pindah ke scene id masing masing
        // Set item click listener to navigate to SimpleListViewDetail
        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedFighter = fighterNames[position]
            val intent = Intent(this, SimpleListViewDetail::class.java)
            intent.putExtra("selectedFighter", selectedFighter)
            startActivity(intent)
        }

        val gotohome = findViewById<CardView>(R.id.simple_gotohome)
        gotohome.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
    }

    // for use back button on android system to go to certain activity
    override fun onBackPressed() {
        // Handle the back button press
        // For example, navigate to a certain activity
        val intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)
    }
}
