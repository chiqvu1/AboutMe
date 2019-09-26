package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.getSystemService
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    lateinit var editText: EditText
    lateinit var nickNameTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.done_button).setOnClickListener {
            addNickname(it)
        }

        editText = findViewById(R.id.nicknam_edit)
        nickNameTextView = findViewById(R.id.nickname_text)
    }

    //function to display user input
    private fun addNickname(view: View) {
        nickNameTextView.text = editText.text
        editText.visibility = View.GONE
        view.visibility= View.GONE
        nickNameTextView.visibility = View.VISIBLE

        //hide keyboard
        val inputKeyboard = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputKeyboard.hideSoftInputFromWindow(view.windowToken, 0)
    }



}
