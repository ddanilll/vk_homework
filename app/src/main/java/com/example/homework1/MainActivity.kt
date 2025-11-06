package com.example.homework1

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homework1.recycler.Item
import com.example.homework1.recycler.adapter.CardAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var fab: FloatingActionButton
    private val cardAdapter: CardAdapter = CardAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        fab = findViewById(R.id.floatingActionButton)

        setupLayoutManager()

        fab.setOnClickListener {
            val newItems = ArrayList<Item>(cardAdapter.items).apply {
                val newId = cardAdapter.items.size + 1
                val newColor = if (newId % 2 == 0) Color.RED else Color.BLUE
                this.add(Item(newId, newColor))
            }
            cardAdapter.update(newItems)
        }

        recyclerView.adapter = cardAdapter
    }

    private fun setupLayoutManager() {
        val orientation = resources.configuration.orientation
        val spanCount = if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            4 // 4 колонки в ландшафтной ориентации
        } else {
            3 // 3 колонки в портретной ориентации
        }

        recyclerView.layoutManager = GridLayoutManager(this, spanCount)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        setupLayoutManager()
    }
}