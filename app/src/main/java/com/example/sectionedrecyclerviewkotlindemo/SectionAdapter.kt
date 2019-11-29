package com.example.sectionedrecyclerviewkotlindemo

import android.content.Context
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import io.github.luizgrp.sectionedrecyclerviewadapter.Section
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionParameters
import kotlinx.android.synthetic.main.header.view.*
import kotlinx.android.synthetic.main.item.view.*

class SectionAdapter(
    private val context: Context,
    private val header: String,
    private val item: Array<String>
) :
    Section(
        SectionParameters.builder()
            .itemResourceId(R.layout.item)
            .headerResourceId(R.layout.header)
            .build()
    ) {

    override fun getContentItemsTotal(): Int {
        return item.size
    }

    override fun getHeaderViewHolder(view: View): ViewHolder {
        return HeaderViewHolder(view)
    }

    override fun getItemViewHolder(view: View): ViewHolder {
        return ItemViewHolder(view)
    }

    override fun onBindHeaderViewHolder(holder: ViewHolder) {
        val headerHolder = holder as HeaderViewHolder
        headerHolder.headerText.text = header
    }

    override fun onBindItemViewHolder(holder: ViewHolder, position: Int) {
        val itemHolder = holder as ItemViewHolder
        itemHolder.itemText.text = item[position]
        itemHolder.itemText.setOnClickListener {
            Toast.makeText(context, "正在點擊: $header 的 ${item[position]}", Toast.LENGTH_SHORT).show()
        }
    }

    internal inner class HeaderViewHolder(itemView: View) : ViewHolder(itemView) {
        val headerText: TextView = itemView.headerText
    }

    internal inner class ItemViewHolder(itemView: View) : ViewHolder(itemView) {
        val itemText: TextView = itemView.itemText
    }

}