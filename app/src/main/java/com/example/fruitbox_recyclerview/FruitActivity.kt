package com.example.fruitbox_recyclerview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class FruitActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruit)

        val headingFruit : TextView = findViewById(R.id.tv_heading)
        val mainFruit : TextView = findViewById(R.id.rv_fruit)
    }
}