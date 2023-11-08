package com.example.fruitbox_recyclerview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class FruitActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruit)

        val imageFruit : ImageView = findViewById(R.id.img_fruit_detail)
        val headingFruit : TextView = findViewById(R.id.heading_fruit_detail)
        val genusFruit : TextView = findViewById(R.id.genus_fruit)
        val descFruit : TextView = findViewById(R.id.desc_fruit)

        val bundle : Bundle?= intent.extras
        val heading = bundle!!.getString("heading")
        val imageId = bundle.getInt("imageId")
        val fruit = bundle.getString("fruit")
        val description  = bundle.getString("description")

        headingFruit.text = heading
        imageFruit.setImageResource(imageId)
        genusFruit.text = description
        descFruit.text = fruit

    }
}