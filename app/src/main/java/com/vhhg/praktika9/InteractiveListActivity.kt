package com.vhhg.praktika9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import kotlin.random.Random

class InteractiveListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interactive_list)
        title = "Интерактивный список"

        val random = Random(0)
        val elems = MutableList(20){random.nextInt(2)}
        val adapter = InteractiveListAdapter(this, elems)
        val listView = findViewById<ListView>(R.id.list_view)

        listView.adapter = adapter

        findViewById<Button>(R.id.next).setOnClickListener {
            startActivity(Intent(this, SpinnerActivity::class.java))
        }
    }
}
