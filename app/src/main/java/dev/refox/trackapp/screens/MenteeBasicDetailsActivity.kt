package dev.refox.trackapp.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.refox.trackapp.R
import dev.refox.trackapp.databinding.ActivityMenteeBasicDetailsBinding

class MenteeBasicDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenteeBasicDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenteeBasicDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {
            startActivity(Intent(this,MenteeProfileDetailsActivity::class.java))
        }
    }
}