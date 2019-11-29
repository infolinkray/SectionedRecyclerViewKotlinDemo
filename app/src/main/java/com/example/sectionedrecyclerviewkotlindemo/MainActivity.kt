package com.example.sectionedrecyclerviewkotlindemo


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup

import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val header1 = "A"
    private val header2 = "B"
    private val header3 = "C"
    private val item1: Array<String> = arrayOf("001", "002", "003", "004", "005", "006")
    private val item2: Array<String> = arrayOf("007", "008", "009", "010", "011", "012")
    private val item3: Array<String> = arrayOf("013", "014", "015", "016", "017", "018")
    private val ITEM_PER_LINE: Int = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sectionAdapter = SectionedRecyclerViewAdapter()
        sectionAdapter.addSection(SectionAdapter(this, header1, item1))
        sectionAdapter.addSection(SectionAdapter(this, header2, item2))
        sectionAdapter.addSection(SectionAdapter(this, header3, item3))
        val glm = GridLayoutManager(this, ITEM_PER_LINE)
        glm.spanSizeLookup = object : SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (sectionAdapter.getSectionItemViewType(position) == SectionedRecyclerViewAdapter.VIEW_TYPE_HEADER) {
                    ITEM_PER_LINE
                } else {
                    1
                }
            }
        }
        recyclerView.layoutManager = glm
        recyclerView.adapter = sectionAdapter

    }
}
