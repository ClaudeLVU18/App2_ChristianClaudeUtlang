package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast

class InputActivity : AppCompatActivity() {
    private lateinit var inputField: EditText
    private lateinit var numField: EditText
    private lateinit var inputDescription: Spinner
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = Color.BLACK
        supportActionBar?.hide()

        inputField = findViewById(R.id.input_field)
        numField = findViewById(R.id.num_field)
        saveButton = findViewById(R.id.save_button)
        inputField.setTextColor(Color.WHITE)
        numField.setTextColor(Color.WHITE)
        inputDescription = findViewById(R.id.input_description) as Spinner
        inputField.setHintTextColor(Color.WHITE)
        numField.setHintTextColor(Color.WHITE)

        saveButton.setOnClickListener {
            Toast.makeText(this,"Contacts saved!", Toast.LENGTH_SHORT).show()
            val input = inputField.text.toString()
            numField = findViewById(R.id.num_field)
            val num = numField.text.toString()

            if (input.isEmpty()){
                inputField.error = "Input cannot be empty"
            } else if (TextUtils.isEmpty(input)) {
            Toast.makeText(this, "Please enter input", Toast.LENGTH_SHORT).show()
            return@setOnClickListener
        }   else {
                val intent = Intent()
                val description = inputDescription.selectedItem.toString()
                intent.putExtra("description", description)
                intent.putExtra("input", input)
                intent.putExtra("num", num)
                setResult(RESULT_OK, intent)
                finish()
            }
        }

    }
}