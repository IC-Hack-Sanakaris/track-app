package dev.refox.trackapp.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import dev.refox.trackapp.screens.AddMenteeActivity

class SplashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        val uid = FirebaseAuth.getInstance().uid
        if (uid == null) {
            startActivity(Intent(this, LoginActivity::class.java))
        } else {
            startActivity(Intent(this, AddMenteeActivity::class.java))
        }
        super.onCreate(savedInstanceState)
    }
}