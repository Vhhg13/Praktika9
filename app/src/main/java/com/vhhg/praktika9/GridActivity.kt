package com.vhhg.praktika9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.GridView

class GridActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid)
        title = "Решёткаx"

        val grid = findViewById<GridView>(R.id.grid)

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
        grid.adapter = adapter
        findViewById<Button>(R.id.next).setOnClickListener {
            startActivity(Intent(this, RecyclerActivity::class.java))
        }
    }
}