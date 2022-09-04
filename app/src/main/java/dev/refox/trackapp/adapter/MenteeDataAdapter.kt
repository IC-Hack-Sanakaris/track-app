package dev.refox.trackapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.animation.AnimationUtils
import com.google.android.material.card.MaterialCardView
import dev.refox.trackapp.R
import dev.refox.trackapp.data.MenteeDataApi

class MenteeDataAdapter(private val menteeList:ArrayList<MenteeDataApi>):
    RecyclerView.Adapter<MenteeDataAdapter.MenteeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenteeViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.mentee_details_card_layout, parent, false)
        return MenteeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MenteeViewHolder, position: Int) {
        val currentItem = menteeList[position]

        holder.name.text = currentItem.name
        holder.email.text = currentItem.email
        holder.usn.text = currentItem.usn
        holder.cf.text = currentItem.cf
        holder.cc.text = currentItem.cc

        holder.card.animation = android.view.animation.AnimationUtils.loadAnimation(holder.itemView.context, R.anim.setting_anim)
    }

    override fun getItemCount(): Int {
        return menteeList.size
    }

    class MenteeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val name: TextView = itemView.findViewById(R.id.cardName)
        val email: TextView = itemView.findViewById(R.id.cardEmail)
        val usn: TextView = itemView.findViewById(R.id.cardUsn)
        val cf: TextView = itemView.findViewById(R.id.cardcfRating)
        val cc: TextView = itemView.findViewById(R.id.cardccRating)
        val card: MaterialCardView = itemView.findViewById(R.id.rvCardItem)
    }
}