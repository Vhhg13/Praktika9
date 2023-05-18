package com.vhhg.praktika9

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.ToggleButton

class InteractiveListAdapter(private val context: Context, val elems: MutableList<Int>) :
    ArrayAdapter<Int>(context, R.layout.interactive_list_elem, elems) {
    companion object{
        class ViewHolder(
            val toggle: ToggleButton,
            val text: TextView
        )
    }
        val inflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: inflater.inflate(R.layout.interactive_list_elem,
            parent, false)
        view.tag = view.tag ?: ViewHolder(
            view.findViewById(R.id.toggle_button),
            view.findViewById(R.id.text_view)
        )
        val holder = view.tag as ViewHolder
        val elem = elems[position]
        holder.text.text = if(elem==1) "Включено" else "Выключено"
        holder.toggle.isChecked = elem == 1
        holder.toggle.setOnClickListener {
            elems[position] = elems[position].xor(1)
            holder.text.text = if(holder.toggle.isChecked) "Включено" else "Выключено"
        }
        return view
    }
}