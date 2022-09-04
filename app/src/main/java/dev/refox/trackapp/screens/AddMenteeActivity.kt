package dev.refox.trackapp.screens

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import dev.refox.trackapp.R
import dev.refox.trackapp.adapter.MenteeDataAdapter
import dev.refox.trackapp.auth.LoginActivity
import dev.refox.trackapp.data.MenteeDataApi
import dev.refox.trackapp.databinding.ActivityAddMenteeBinding

class AddMenteeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddMenteeBinding
    private lateinit var userRecyclerView: RecyclerView
    private lateinit var menteeArrayList: ArrayList<MenteeDataApi>
    private lateinit var dbref: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddMenteeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setStatusBarColor(ContextCompat.getColor(baseContext, R.color.yellow))

        userRecyclerView = findViewById(R.id.rvRatings)
        userRecyclerView.layoutManager = LinearLayoutManager(this)
        userRecyclerView.setHasFixedSize(true)

        menteeArrayList = arrayListOf<MenteeDataApi>()
        getMenteeData()

        binding.swipe.setOnRefreshListener {
            val adapter = binding.rvRatings.adapter
            menteeArrayList.clear()
            getMenteeData()
            adapter?.notifyDataSetChanged()

            Handler().postDelayed(Runnable {
                binding.swipe.isRefreshing = false
            }, 3000)
        }

        binding.btnAddMentee.setOnClickListener {
            startActivity(Intent(this, MenteeBasicDetailsActivity::class.java))
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }

        binding.btnLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            finish()
            startActivity(Intent(this, LoginActivity::class.java))
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }
    }

    private fun getMenteeData() {

        dbref = FirebaseDatabase.getInstance().getReference("mentee")

        dbref.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                if(snapshot.exists()) {
                    for (menteeSnapshot in snapshot.children){

                        val mentee = menteeSnapshot.getValue(MenteeDataApi::class.java)
                        menteeArrayList.add(mentee!!)
                    }

                    userRecyclerView.adapter = MenteeDataAdapter(menteeArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })


    }


    override fun onBackPressed() {
        finishAffinity()
    }
}