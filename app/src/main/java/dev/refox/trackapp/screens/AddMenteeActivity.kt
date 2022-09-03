package dev.refox.trackapp.screens

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import dev.refox.trackapp.auth.LoginActivity
import dev.refox.trackapp.databinding.ActivityAddMenteeBinding

class AddMenteeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddMenteeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddMenteeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAddMentee.setOnClickListener {
            startActivity(Intent(this, MenteeBasicDetailsActivity::class.java))
        }

        binding.btnLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            finish()
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }


    override fun onBackPressed() {
        finishAffinity()
    }
}