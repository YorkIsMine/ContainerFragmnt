package com.yorkismine.containerfragmnt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val list: ArrayList<Tag> = intent
            .getParcelableArrayListExtra<Tag>("list") as ArrayList<Tag>

        list.reverse()

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = TagAdapter(list)
    }
}
