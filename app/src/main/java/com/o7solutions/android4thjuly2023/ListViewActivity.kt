package com.o7solutions.android4thjuly2023

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.o7solutions.android4thjuly2023.databinding.ActivityListViewBinding

class ListViewActivity : AppCompatActivity() {
    lateinit var binding: ActivityListViewBinding
    var array = arrayOf<String>("Shabnam", "Ameesha", "Sonam") // declare n initialise
    lateinit var arrayAdapter : ArrayAdapter<String> //declare
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, array)

        binding.listView.adapter = arrayAdapter

        binding.fab.setOnClickListener {
            var dialog = Dialog(this)

        }
    }
}