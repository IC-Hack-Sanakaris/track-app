package dev.refox.trackapp.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.*
import dev.refox.trackapp.databinding.ActivitySignupBinding
import dev.refox.trackapp.screens.AddMenteeActivity

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.tvToLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        binding.btnSignup.setOnClickListener {
            val email = binding.emailET.text.toString()
            val name = binding.nameEt.text.toString()
            val confirmPass = binding.confirmPassEt.text.toString()

            if (email.isNotEmpty() && name.isNotEmpty() && confirmPass.isNotEmpty()) {

                    firebaseAuth.createUserWithEmailAndPassword(email, confirmPass).addOnSuccessListener {

                        startMenteeActivity()

                    }.addOnFailureListener {
                        if (it is FirebaseAuthInvalidUserException) {
                            Toast.makeText(this, "Email cannot be used to create account", Toast.LENGTH_SHORT).show()
                        } else if (it is FirebaseAuthUserCollisionException) {
                            Toast.makeText(this, "Email Already Exists", Toast.LENGTH_SHORT).show()
                        } else if (it is FirebaseAuthWeakPasswordException) {
                            Toast.makeText(this, "Weak Password", Toast.LENGTH_SHORT).show()
                        } else if (it is FirebaseAuthEmailException) {
                            Toast.makeText(this, "Incorrect Email", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, "Unknown error", Toast.LENGTH_SHORT).show()
                        }
                        it.printStackTrace()
                    }

            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()

            }
        }
    }

    private fun startMenteeActivity(){
        startActivity(Intent(this, AddMenteeActivity::class.java))
    }
}