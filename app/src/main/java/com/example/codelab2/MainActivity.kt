package com.example.codelab2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    lateinit var doneButton: Button;
    lateinit var nicknameText: TextView;
    lateinit var nicknameEdit: EditText;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        doneButton = findViewById<Button>(R.id.done_button);
        doneButton.setOnClickListener { clickHandlerFunction() };

        nicknameText = findViewById<TextView>(R.id.nickname_text);
        nicknameText.setOnClickListener { editNickname() };

        nicknameEdit = findViewById<EditText>(R.id.nicknameEdit);
    }

    private fun clickHandlerFunction (){
        nicknameText.text = nicknameEdit.text;
        nicknameEdit.visibility = View.GONE;
        nicknameText.visibility = View.VISIBLE;
        doneButton.visibility = View.GONE;

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(doneButton.windowToken, 0)
    }

    private fun editNickname(){
        nicknameEdit.visibility = View.VISIBLE;
        nicknameText.visibility = View.GONE;
        doneButton.visibility = View.VISIBLE;

        nicknameEdit.requestFocus();
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(nicknameEdit.windowToken, 0)
    }
}