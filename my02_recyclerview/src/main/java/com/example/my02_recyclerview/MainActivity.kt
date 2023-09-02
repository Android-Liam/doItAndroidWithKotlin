package com.example.my02_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv_board = findViewById<RecyclerView>(R.id.recyclerView)

        val itemList = ArrayList<Item>()

        // item List
        for(i in 1..9) {
            itemList.add(Item("0$i:00", i.toString().repeat(10),"Liam"))
        }

        // Adapter
        val Adapter = Adapter(itemList)
        Adapter.notifyDataSetChanged()

        rv_board.adapter = Adapter
        rv_board.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }
}

data class Item(val time: String, val title: String, val name: String)

class Adapter(val itemList: ArrayList<Item>) :
    RecyclerView.Adapter<Adapter.ViewHorder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHorder { // View Create
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
        return ViewHorder(view)
    }

    override fun onBindViewHolder(holder: ViewHorder, position: Int) { // View Bind
        holder.tv_time.text = itemList[position].time
        holder.tv_title.text = itemList[position].title
        holder.tv_name.text = itemList[position].name

        holder.tv_title.setOnClickListener {
            Log.d("Log", "Click!")
        }
    }

    override fun getItemCount(): Int { // return Item Count
        return itemList.count()
    }

    inner class ViewHorder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv_time = itemView.findViewById<TextView>(R.id.tv_time)
        val tv_title = itemView.findViewById<TextView>(R.id.tv_title)
        val tv_name = itemView.findViewById<TextView>(R.id.tv_name)
    }

}