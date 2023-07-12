package com.o7solutions.android4thjuly2023

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    //variable declaration
    var etName : EditText ?= null
    var etHeight : EditText ?= null
    var etRollNo : EditText ?= null
    var btnValidate : Button ?= null
    var btnRelativeLayout : Button ?= null
    var btnSnackbar : Button ?= null
    var btnSnackbarButton : Button ?= null
    var btnConstraint : Button ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialization
        etName = findViewById(R.id.etName)
        etHeight = findViewById(R.id.etHeight)
        etRollNo = findViewById(R.id.etRollNo)
        btnValidate = findViewById(R.id.btnValidate)
        btnRelativeLayout = findViewById(R.id.btnRelativeLayout)
        btnSnackbar = findViewById(R.id.btnSnackbar)
        btnSnackbarButton = findViewById(R.id.btnSnackbarButton)
        btnConstraint = findViewById(R.id.btnConstraint)
        //operation perform

       // btnValidate?.setOnClickListener(View.OnClickListener {  })
        btnValidate?.setOnClickListener {
            if(etName?.text.toString().isNullOrEmpty()){
                etName?.error = "Enter your name"
            }else if(etRollNo?.text?.toString().isNullOrEmpty()){
                etRollNo?.error = "Enter your rollno"
            }else if(etHeight?.text?.toString().isNullOrEmpty()){
                etHeight?.error = "Enter your height"
            }else{
                Toast.makeText(this,
                    "Validation completed",
                    Toast.LENGTH_SHORT).show()

                //toast short length - 2 seconds and long = 3.5 seconds
                //Intent - source class, destination class
                var intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        btnRelativeLayout?.setOnClickListener {
            var intent = Intent(this, RelativeActivity::class.java)
            startActivity(intent)
        }

        btnSnackbar?.setOnClickListener {
            Snackbar.make(btnSnackbar!!, "This is snackbar", Snackbar.LENGTH_SHORT).show()

            /*btnSnackbar?.let {

            }*/
        }

        btnSnackbarButton?.setOnClickListener {
            Snackbar.make(it,
                "This is snackbar with button",
                Snackbar.LENGTH_INDEFINITE)
                .setAction("Ok", {
                    Toast.makeText(this, "Started from snackbar",
                        Toast.LENGTH_SHORT).show()
                    var intent = Intent(this, RelativeActivity::class.java)
                    startActivity(intent)
                })
                .show()
        }

        btnConstraint?.setOnClickListener{
            var intent = Intent(this, ConstraintLayout::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, " on Start Called", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "on resume called", Toast.LENGTH_SHORT).show()
    }

    //function
}