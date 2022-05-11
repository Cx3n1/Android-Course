package dev.cx3n1.midterm1

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var nameInputField : EditText
    lateinit var confirmInputButton : ImageButton
    lateinit var profileIconButton : ImageButton

    lateinit var sharedPreference: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreference = getSharedPreferences("SHARED_PREFS", Context.MODE_PRIVATE)

        nameInputField = findViewById(R.id.etxt_nameInput)
        confirmInputButton = findViewById(R.id.imgBtn_confirmInput)
        profileIconButton = findViewById(R.id.imgBtn_profileIcon)

        confirmInputButton.setOnClickListener {
            saveNewNameInSharedPreferences()
            startProfileActivity()
        }

        profileIconButton.setOnClickListener{
            startProfileActivity()
        }
    }


    private fun startProfileActivity() {
        startActivity(Intent(this, ProfileActivity::class.java));
        this.finish();
    }

    @SuppressLint("CommitPrefEdits")
    private fun saveNewNameInSharedPreferences() {
        val inputtedUsername : String = nameInputField.text.toString()

        if(isEmptyOrBlank(inputtedUsername)) return

        val editor = sharedPreference.edit()
        editor.putString("Username", inputtedUsername)
        editor.apply()
    }


    private fun isEmptyOrBlank(inputtedUsername: String) =
        inputtedUsername.isBlank() || inputtedUsername.isEmpty()
}