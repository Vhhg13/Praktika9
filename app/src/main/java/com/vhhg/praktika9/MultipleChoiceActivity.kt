package com.vhhg.praktika9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast

class MultipleChoiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiple_choice)
        title = "Multiple Choice"

        val listView = findViewById<ListView>(R.id.list_view)
        val adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_multiple_choice,
            resources.getStringArray(R.array.elements)
        )
        listView.adapter = adapter

        listView.onItemClickListener =
            OnItemClickListener { p0, p1, p2, p3 ->
                val checked = listView.checkedItemPositions
                Toast.makeText(applicationContext, checked.toString(), Toast.LENGTH_SHORT).show()
            }
        findViewById<Button>(R.id.next).setOnClickListener {
            startActivity(Intent(this, ListEditorActivity::class.java))
        }
    }
}