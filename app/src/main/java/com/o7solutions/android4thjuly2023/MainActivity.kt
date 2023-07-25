package com.o7solutions.android4thjuly2023

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import com.o7solutions.android4thjuly2023.fragmentpackage.FragmentContainerActivity

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
    var btnAlertDialog : Button ?= null
    var btnSimpleListAlertDialog : Button ?= null
    var btnCheckboxListAlertDialog : Button ?= null
    var btnCustomDialog : Button ?= null
    var btnViewBindingActivity : Button ?= null
    var btnFragmentContainerActivity : Button ?= null
    var tvSelectedColors : TextView ?= null
    var btnListView : Button ?= null
    var simpleList = arrayOf("Black", "Blue", "Red", "Green")
    var booleanArray = booleanArrayOf(false, false,false, false)
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
        btnAlertDialog = findViewById(R.id.btnAlertDialog)
        btnSimpleListAlertDialog = findViewById(R.id.btnSimpleListAlertDialog)
        btnCheckboxListAlertDialog = findViewById(R.id.btnCheckboxListAlertDialog)
        tvSelectedColors = findViewById(R.id.tvSelectedColors)
        btnCustomDialog = findViewById(R.id.btnCustomDialog)
        btnViewBindingActivity = findViewById(R.id.btnViewBindingActivity)
        btnFragmentContainerActivity = findViewById(R.id.btnFragmentContainerActivity)
        btnListView = findViewById(R.id.btnListView)
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

        btnAlertDialog?.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("This is title")
                .setMessage("This is message")
                .setCancelable(false)
                .setPositiveButton("Ok", {_,_->
                    Toast.makeText(this, "Positive button click", Toast.LENGTH_SHORT).show()
                })
                .setNegativeButton("No", {_,_->
                    etName?.setText("Changed from alert")
                })
                .show()
        }

        btnSimpleListAlertDialog?.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("This is simple list alert")
                //.setMessage("This is simple list alert message")
                .setItems(simpleList, {_, position->
                    Toast.makeText(this, "Clicked Item ${simpleList[position]}", Toast.LENGTH_SHORT).show()
                })
                .show()
        }

        btnCheckboxListAlertDialog?.setOnClickListener {
            AlertDialog.Builder(this)
                .setMultiChoiceItems(simpleList,booleanArray, {_, position, isChecked->
                    Toast.makeText(this, "position $position isChecked $isChecked", Toast.LENGTH_LONG).show()
                    System.out.println("position $position isChecked $isChecked")
                })
                .setPositiveButton("Ok", {_,_->
                    var selectedColor = ""
                    for(i in 0..booleanArray.size-1){
                        if(booleanArray[i] == true){
                            selectedColor = selectedColor+ simpleList[i] +" "
                        }
                    }
                    tvSelectedColors?.setText(selectedColor)
                })
                .show()
        }

        btnCustomDialog?.setOnClickListener {
            var dialog = Dialog(this)
            dialog.setContentView(R.layout.custom_dialog_layout)
            dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            dialog.show()
            var btnGetName : Button = dialog.findViewById(R.id.btnGetName)
            var etname : EditText = dialog.findViewById(R.id.etName)

            btnGetName.setOnClickListener {
                if(etname.text.toString().isNullOrEmpty()){
                    etname.error = "Enter your name"
                }else{
                    btnCustomDialog?.setText(etname.text.toString())
                    dialog.dismiss()
                }
            }
        }

        btnViewBindingActivity?.setOnClickListener {
            var intent = Intent(this, ViewBindingActivity::class.java)
            startActivity(intent)
        }

        btnFragmentContainerActivity?.setOnClickListener {
            var intent = Intent(this, FragmentContainerActivity::class.java)
            startActivity(intent)
        }

        btnListView?.setOnClickListener {
            var intent = Intent(this, ListViewActivity::class.java)
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