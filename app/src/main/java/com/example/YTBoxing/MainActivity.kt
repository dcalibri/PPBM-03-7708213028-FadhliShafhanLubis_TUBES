package com.example.YTBoxing


import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.adapter.ItemAdapter
import com.example.YTBoxing.data.Datasource
import com.example.YTBoxing.model.Affirmation
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listboxer)

        //buttonBack settings here
        val imageViewBack = this.findViewById<ImageView>(R.id.buttonBack)
        imageViewBack.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }



        // Get the custom Toolbar by its ID
       // val customToolbar: Toolbar = findViewById(R.id.custom_toolbar)


        // Set the custom Toolbar as the SupportActionBar
        //setSupportActionBar(customToolbar)


        // Enable the back button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        // Set the title for the Toolbar
        supportActionBar?.title = "List Boxers"


        // Initialize data.
        val myDataset = Datasource().loadAffirmations()


        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val itemAdapter = ItemAdapter(this, myDataset, object : ItemAdapter.OnItemClickListener {
            override fun onItemClick(affirmation: Affirmation) {
                val affirmationText = getString(affirmation.stringResourceId)
                val imageResourceId = affirmation.imageResourceId
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("affirmationText", affirmationText)
                intent.putExtra("imageResourceId", imageResourceId)
                startActivity(intent)
            }
        })


        recyclerView.adapter = itemAdapter
        recyclerView.setHasFixedSize(true)
    }
}
