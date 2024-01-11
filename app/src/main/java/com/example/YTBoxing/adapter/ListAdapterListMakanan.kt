package com.example.YTBoxing

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView


class ListAdapterListMakanan(context: Context, dataArrayList: ArrayList<ListDataMakanan>) :
    ArrayAdapter<ListDataMakanan>(context, R.layout.list_item_makanan, dataArrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val listData = getItem(position)

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_makanan, parent, false)
        }

        val listImage = convertView!!.findViewById<ImageView>(R.id.listImage)
        val listName = convertView.findViewById<TextView>(R.id.listName)
        val listTime = convertView.findViewById<TextView>(R.id.listTime)

        listImage.setImageResource(listData?.image ?: R.drawable.makanan_maggi)
        listName.text = listData?.name
        listTime.text = listData?.time

        return convertView
    }
}
