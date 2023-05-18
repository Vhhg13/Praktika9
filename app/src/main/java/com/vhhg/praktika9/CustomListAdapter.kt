package com.vhhg.praktika9

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class CustomListAdapter(context: Context, var elements: List<DataClass>) :
    ArrayAdapter<DataClass>(context, R.layout.my_list_item, elements) {
    private val inflater = LayoutInflater.from(context)

    companion object{
        class ViewHolder(val textView: TextView)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        if(convertView == null) {
            view = inflater.inflate(R.layout.my_list_item, parent, false)
            view.tag = ViewHolder(view.findViewById(R.id.text_view))
        }else
            view = convertView

        val holder = view.tag as ViewHolder
        val elem = elements[position]


        holder.textView.setBackgroundColor(context.getColor(elem.color))
        holder.textView.text = elem.text
        return view
    }
}
