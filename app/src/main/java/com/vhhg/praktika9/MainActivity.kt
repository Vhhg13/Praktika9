package com.vhhg.praktika9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemClickListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Простой список"

        val listView = findViewById<ListView>(R.id.list_view)

        listView.onItemClickListener =
            OnItemClickListener { p0, p1, p2, p3 ->
                Toast.makeText(applicationContext,
                    "Нажат " + (p1 as TextView).text,
                    Toast.LENGTH_SHORT).show()
            }

        val adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1,
            resources.getStringArray(R.array.elements)
        )
        listView.adapter = adapter

        findViewById<Button>(R.id.next).setOnClickListener {
            startActivity(Intent(this, MultipleChoiceActivity::class.java))
        }
    }
}