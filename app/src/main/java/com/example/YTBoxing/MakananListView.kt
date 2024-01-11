package com.example.YTBoxing

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.YTBoxing.MakananDetailed
import com.example.YTBoxing.R

class MakananListView : AppCompatActivity() {

    private lateinit var listAdapter: ArrayAdapter<String>
    private val nameList = arrayOf("Pasta", "Maggi", "Cake", "Pancake", "Pizza", "Burgers", "Fries")
    private val timeList = arrayOf("30 mins", "2 mins", "45 mins", "10 mins", "60 mins", "45 mins", "30 mins")
    private val ingredientList = arrayOf(
        R.string.pastaIngredients,
        R.string.maggiIngredients,
        R.string.cakeIngredients,
        R.string.pancakeIngredients,
        R.string.pizzaIngredients,
        R.string.burgerIngredients,
        R.string.friesIngredients
    )
    private val descList = arrayOf(
        R.string.pastaDesc,
        R.string.maggieDesc,
        R.string.cakeDesc,
        R.string.pancakeDesc,
        R.string.pizzaDesc,
        R.string.burgerDesc,
        R.string.friesDesc
    )
    private val imageList = intArrayOf(
        R.drawable.makanan_pasta,
        R.drawable.makanan_maggi,
        R.drawable.makanan_cake,
        R.drawable.makanan_pancake,
        R.drawable.makanan_pizza,
        R.drawable.makanan_burger,
        R.drawable.makanan_fries
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_makananlistview)

        val listView: ListView = findViewById(R.id.listview)
        val dataList = ArrayList<ListDataMakanan>()

        for (i in nameList.indices) {
            val data = ListDataMakanan(
                nameList[i],
                timeList[i],
                getString(ingredientList[i]), // Menggunakan getString() untuk resource string
                getString(descList[i]), // Menggunakan getString() untuk resource string
                imageList[i]
            )
            dataList.add(data)
        }

        val listAdapter = ListAdapterListMakanan(this, dataList) // Menggunakan adapter kustom
        listView.adapter = listAdapter

        listView.setOnItemClickListener { _, _, i, _ ->
            val intent = Intent(this@MakananListView, MakananDetailed::class.java)
            intent.putExtra("name", dataList[i].name)
            intent.putExtra("time", dataList[i].time)
            intent.putExtra("ingredients", dataList[i].ingredients)
            intent.putExtra("desc", dataList[i].desc)
            intent.putExtra("image", dataList[i].image)
            startActivity(intent)
        }

        // Set an OnClickListener for the "Rate" button
        val imageViewBack = findViewById<ImageView>(R.id.buttonBack)
        imageViewBack.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
    }




}
