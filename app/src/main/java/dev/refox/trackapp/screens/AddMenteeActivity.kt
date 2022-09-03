package dev.refox.trackapp.screens

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.firebase.auth.FirebaseAuth
import dev.refox.trackapp.auth.LoginActivity
import dev.refox.trackapp.databinding.ActivityAddMenteeBinding


class AddMenteeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddMenteeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddMenteeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setStatusBarColor(ContextCompat.getColor(baseContext, dev.refox.trackapp.R.color.yellow))

        binding.btnAddMentee.setOnClickListener {
            startActivity(Intent(this, MenteeBasicDetailsActivity::class.java))
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }

        binding.btnLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            finish()
            startActivity(Intent(this, LoginActivity::class.java))
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    }


    override fun onBackPressed() {
        finishAffinity()
    }
}