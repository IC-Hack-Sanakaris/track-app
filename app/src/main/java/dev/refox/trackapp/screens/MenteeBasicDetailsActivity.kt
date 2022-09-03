package dev.refox.trackapp.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import dev.refox.trackapp.R
import dev.refox.trackapp.data.MenteeDetails
import dev.refox.trackapp.databinding.ActivityMenteeBasicDetailsBinding

class MenteeBasicDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenteeBasicDetailsBinding
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenteeBasicDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmitMenteeData.setOnClickListener {
            val name = binding.menteeName.text.toString()
            val email = binding.menteeEmail.text.toString()
            val number = binding.menteePhone.text.toString()
            val usn = binding.menteeUsn.text.toString()
            val codechef = binding.menteeCodechef.text.toString()
            val codeforces = binding.menteeCodeforces.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && number.isNotEmpty() && usn.isNotEmpty()
                && codechef.isNotEmpty() && codeforces.isNotEmpty()) {

                database = FirebaseDatabase.getInstance().getReference("mentee")
                val mentee = MenteeDetails(name,email, number, usn, codechef, codeforces)
                database.child(usn).setValue(mentee).addOnSuccessListener {
                    binding.menteeName.text?.clear()
                    binding.menteeEmail.text?.clear()
                    binding.menteePhone.text?.clear()
                    binding.menteeUsn.text?.clear()
                    binding.menteeCodechef.text?.clear()
                    binding.menteeCodeforces.text?.clear()

                    Toast.makeText(this, "Successfully Entered", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }
}