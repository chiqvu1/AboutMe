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
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Chi")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName


        binding.doneButton.setOnClickListener {
            addNickname(it)
        }

       // editText = findViewById(R.id.nicknam_edit)
        //nickNameTextView = findViewById(R.id.nickname_text)
    }

    //function to display user input
    private fun addNickname(view: View) {
        binding.apply {
            //nicknameText.text = nicknameEdit.text
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        //hide keyboard
        val inputKeyboard = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputKeyboard.hideSoftInputFromWindow(view.windowToken, 0)
    }



}
