package com.example.homework1

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val itemId = intent.getIntExtra("ITEM_ID", 0)
        val itemColor = intent.getIntExtra("ITEM_COLOR", Color.BLUE)

        val numberTextView = findViewById<TextView>(R.id.number)
        numberTextView.text = itemId.toString()

        findViewById<android.view.View>(R.id.root).setBackgroundColor(itemColor)
    }
}