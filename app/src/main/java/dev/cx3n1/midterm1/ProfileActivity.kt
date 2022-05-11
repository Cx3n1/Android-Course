package dev.cx3n1.midterm1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val sharedPreference = getSharedPreferences("SHARED_PREFS", Context.MODE_PRIVATE)
        val profTextView = findViewById<TextView>(R.id.txt_profileText);
        val backToMainButton = findViewById<ImageButton>(R.id.imgBtn_backToMain)

        val greetingText = "Hello, " + sharedPreference.getString("Username", "Your name");

        profTextView.setText(greetingText);

        backToMainButton.setOnClickListener{
            goBackToMainActivity();
        }
    }

    private fun goBackToMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        this.finish()
    }

}