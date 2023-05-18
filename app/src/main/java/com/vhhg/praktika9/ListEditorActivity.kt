package com.vhhg.praktika9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import kotlin.random.Random

class ListEditorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_editor)
        title = "List Editor"

        val listView = findViewById<ListView>(R.id.list_view)
        val elems = mutableListOf<String>()
        val adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1,
            elems
        )
        listView.adapter = adapter

        val add = findViewById<Button>(R.id.add)
        val remove = findViewById<Button>(R.id.remove)
        val random = Random(0)
        add.setOnClickListener {
            adapter.add((random.nextInt().mod(100)).toString())
        }
        remove.setOnClickListener {
            try {
                adapter.remove(adapter.getItem(0))
            }catch (_: java.lang.IndexOutOfBoundsException){
                Toast.makeText(applicationContext, "Больше нет элементов",
                    Toast.LENGTH_SHORT).show()
            }
        }
        findViewById<Button>(R.id.next).setOnClickListener {
            startActivity(Intent(this, CustomListActivity::class.java))
        }
    }
}