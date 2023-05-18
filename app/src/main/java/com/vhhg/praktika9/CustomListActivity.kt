package com.vhhg.praktika9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView

class CustomListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_list)
        title = "Кастомный список"

        val elems = listOf(
            DataClass(R.color.purple_500, "Строка 1"),
            DataClass(R.color.teal_700, "Строка 3"),
            DataClass(R.color.green, "Строка 2"),
            DataClass(R.color.purple_500, "Строка 1"),
            DataClass(R.color.teal_700, "Строка 3"),
            DataClass(R.color.green, "Строка 2"),
            DataClass(R.color.purple_500, "Строка 1"),
            DataClass(R.color.teal_700, "Строка 3"),
            DataClass(R.color.green, "Строка 2"),
            DataClass(R.color.purple_500, "Строка 1"),
            DataClass(R.color.teal_700, "Строка 3"),
            DataClass(R.color.green, "Строка 2"),
            DataClass(R.color.green, "Строка 2"),
            DataClass(R.color.purple_500, "Строка 1"),
            DataClass(R.color.teal_700, "Строка 3"),
            DataClass(R.color.green, "Строка 2"),
        )

        val adapter = CustomListAdapter(this, elems)
        val listView = findViewById<ListView>(R.id.list_view)
        listView.adapter = adapter
        findViewById<Button>(R.id.next).setOnClickListener {
            startActivity(Intent(this, InteractiveListActivity::class.java))
        }
    }
}