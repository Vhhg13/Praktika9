package com.vhhg.praktika9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class RecyclerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        title = "Recycler"

        val random = Random(0)
        val elems = MutableList(30){random.nextInt(2)}

        val recycler = findViewById<RecyclerView>(R.id.recycler)
        val adapter = RecyclerAdapter(this, elems)
        recycler.adapter = adapter
    }
}
