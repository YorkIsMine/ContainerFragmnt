package com.yorkismine.containerfragmnt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TagAdapter(
    private val list: ArrayList<Tag>
) : RecyclerView.Adapter<TagAdapter.TagHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.tag_item, parent, false)

        return TagHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: TagHolder, position: Int) {
        val tag = list[position]
        holder.tagText.text = tag.text
    }

    class TagHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tagText: TextView = view.findViewById<TextView>(R.id.tag_tv)
    }
}