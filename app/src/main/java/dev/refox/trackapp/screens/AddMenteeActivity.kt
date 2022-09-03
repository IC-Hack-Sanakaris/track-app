package dev.refox.trackapp.screens

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
    }

    override fun onBackPressed() {
        finishAffinity()
    }
}