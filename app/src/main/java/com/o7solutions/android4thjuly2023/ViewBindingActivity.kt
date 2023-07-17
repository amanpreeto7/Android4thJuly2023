package com.o7solutions.android4thjuly2023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.o7solutions.android4thjuly2023.databinding.ActivityViewBindingBinding

class ViewBindingActivity : AppCompatActivity() {
    var binding :ActivityViewBindingBinding ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewBindingBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.btnValidate?.setOnClickListener {
            if(binding?.etName?.text?.toString().isNullOrEmpty()){
                binding?.etName?.error = "Enter your name"
            }
        }
    }
}