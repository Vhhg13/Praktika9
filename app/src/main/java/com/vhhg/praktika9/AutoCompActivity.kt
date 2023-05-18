package com.vhhg.praktika9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.MultiAutoCompleteTextView

class AutoCompActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auto_comp)
        title = "Автодополнение"
        val numbers = listOf(
            "Один", "Два", "Три", "Четыре", "Пять",
            "Шесть", "Семь", "Восемь", "Девять", "Десять"
        )
        val textView = findViewById<AutoCompleteTextView>(R.id.acmop)
        val adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1,
            numbers
        )
        textView.setAdapter(adapter)

        val multiComp = findViewById<MultiAutoCompleteTextView>(R.id.multi)
        multiComp.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        val mAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1,
            numbers
        )
        multiComp.setAdapter(mAdapter)

        findViewById<Button>(R.id.next).setOnClickListener {
            startActivity(Intent(this, GridActivity::class.java))
        }
    }
}