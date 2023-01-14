package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var count = 0
    private val inputList = mutableListOf<String>()
    private lateinit var inputListTextView: TextView
    private lateinit var plusButton: Button
    private lateinit var clearButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = Color.BLACK

        supportActionBar?.hide()

        inputListTextView = findViewById(R.id.input_list)
        inputListTextView.setTextColor(Color.WHITE)

        plusButton = findViewById(R.id.plus_button)
        clearButton = findViewById(R.id.clear_button)
        clearButton.isEnabled = false
        plusButton.setOnClickListener{
            if (count < 4) {
                val intent = Intent(this, InputActivity::class.java)
                startActivityForResult(intent, 1)
            }
        }
        clearButton.setOnClickListener {
            inputList.clear()
            inputListTextView.text = ""
            count = 0
            plusButton.isEnabled = true
            if (inputList.isEmpty()) {
                clearButton.isEnabled = false
            }
            Toast.makeText(this,"Contacts Cleared", Toast.LENGTH_SHORT).show()

        }




    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            val input = data?.getStringExtra("input")
            val num = data?.getStringExtra("num")
            val description = data?.getStringExtra("description")
            inputList.add("\n\n$input\n$num\n- $description")
            count++
            inputListTextView.text = inputList.joinToString(separator = "\n")
            inputListTextView.text = inputList.joinToString(separator = "\n_____________________")
            if (count == 4) plusButton.isEnabled = false
        }
        if (inputList.isNotEmpty()) {
            clearButton.isEnabled = true
        } else {
            clearButton.isEnabled = false
        }


    }



}