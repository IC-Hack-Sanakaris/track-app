package dev.refox.trackapp.screens

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import dev.refox.trackapp.databinding.ActivityMenteeDashBinding

class MenteeDashActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenteeDashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenteeDashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getMenteeDetails(intent.getStringExtra("usn"))


    }

    private fun getMenteeDetails(usn: String?) {

        FirebaseDatabase.getInstance().getReference("mentee").child(usn!!.toString()).child("name").addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var name = snapshot.value
                binding.invName.text = name.toString()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

        FirebaseDatabase.getInstance().getReference("mentee").child(usn!!.toString()).child("email").addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var email = snapshot.value
                binding.invEmail.text = email.toString()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

        FirebaseDatabase.getInstance().getReference("mentee").child(usn!!.toString()).child("usn").addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var Usn = snapshot.value
                binding.invUsn.text = Usn.toString()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

        FirebaseDatabase.getInstance().getReference("mentee").child(usn!!.toString()).child("cc").addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var cc = snapshot.value
                binding.invCcRating.text = cc.toString()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

        FirebaseDatabase.getInstance().getReference("mentee").child(usn!!.toString()).child("cf").addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var cf = snapshot.value
                binding.invCfRating.text = cf.toString()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }
}