package com.vhhg.praktika9

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(val context: Context, val elems: MutableList<Int>) :
    RecyclerView.Adapter<RecyclerAdapter.Companion.ViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    companion object{
        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            val toggle: ToggleButton = itemView.findViewById(R.id.toggle_button)
            val txt: TextView = itemView.findViewById(R.id.text_view)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.interactive_list_elem,
            parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = elems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.toggle.isChecked = elems[position] == 1
        holder.toggle.setOnClickListener {
            elems[position] = elems[position].xor(1)
            holder.toggle.isChecked = elems[position] == 1
            holder.txt.text = if(elems[position] == 1) "Включено" else "Выключено"
        }
        holder.txt.text = if(elems[position] == 1) "Включено" else "Выключено"
        holder.itemView.setOnClickListener {
            Toast.makeText(context, holder.txt.text, Toast.LENGTH_SHORT).show()
        }
    }

}