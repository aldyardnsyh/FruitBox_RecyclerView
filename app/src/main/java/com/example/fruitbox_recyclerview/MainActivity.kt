package com.example.fruitbox_recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Fruit>
    lateinit var imageId : Array <Int>
    lateinit var heading : Array <String>
    lateinit var description : Array <String>
    lateinit var function : Array <String>
    lateinit var fruit : Array <String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageId = arrayOf(
            R.drawable.durian,
            R.drawable.semangka,
            R.drawable.hazelnut,
            R.drawable.leci,
            R.drawable.pepaya,
            R.drawable.pisang,
            R.drawable.durian,
            R.drawable.semangka,
            R.drawable.hazelnut
        )

        heading = arrayOf(
            "Durian",
            "Semangka",
            "Hazelnut",
            "Leci",
            "Pepaya",
            "Pisang",
            "Durian",
            "Semangka",
            "Hazelnut"
        )

        description = arrayOf(
            "Durizo zibethinus",
            "Citrullus lanatus",
            "Corylus avellana",
            "Dimocarpus longan",
            "Carica papaya",
            "Musa acuminata",
            "Durizo zibethinus",
            "Citrullus lanatus",
            "Corylus avellana"
        )

        function = arrayOf(
            "Baik untuk perbaikan kerusakan sel",
            "Baik untuk menangkal radikal bebas",
            "Baik untuk regenerasi sel",
            "Baik untuk daya tahan tubuh",
            "Baik untuk melancarkan pencernaan",
            "Baik untuk menurunkan berat badan",
            "Baik untuk perbaikan kerusakan sel",
            "Baik untuk menangkal radikal bebas",
            "Baik untuk regenerasi sel",
        )

        fruit = arrayOf(
            getString(R.string.durian_desc),
            getString(R.string.semangka_desc),
            getString(R.string.hazelnut_desc),
            getString(R.string.leci_desc),
            getString(R.string.pepaya_desc),
            getString(R.string.pisang_desc),
            getString(R.string.durian_desc),
            getString(R.string.semangka_desc),
            getString(R.string.hazelnut_desc)
        )

        newRecyclerView = findViewById(R.id.rv_fruit)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Fruit>()

        getUserdata()
    }

    private fun getUserdata() {
        for (i in imageId.indices){
            val fruit = Fruit(imageId[i], heading[i], description[i], function[i])
            newArrayList.add(fruit)
        }

        var adapter = FruitAdapter(newArrayList)
        newRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : FruitAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                val selectedFruit = newArrayList[position]
                val fruitName = selectedFruit.heading

                Toast.makeText(this@MainActivity, "You Clicked on item: $fruitName", Toast.LENGTH_SHORT).show()

                val intent = Intent(this@MainActivity, FruitActivity::class.java)
                intent.putExtra("imageId", newArrayList[position].titleImage)
                intent.putExtra("heading", newArrayList[position].heading)
                intent.putExtra("description", newArrayList[position].description)
                intent.putExtra("function", newArrayList[position].function)
                intent.putExtra("fruit", fruit[position])
                startActivity(intent)
            }
        })

    }
}