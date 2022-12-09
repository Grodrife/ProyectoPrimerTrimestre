package com.gabrielrf.proyecto.ui.main

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gabrielrf.proyecto.R
import com.gabrielrf.proyecto.databinding.ViewTeamBinding
import com.gabrielrf.proyecto.inflate
import com.gabrielrf.proyecto.loadUrl
import com.gabrielrf.proyecto.model.Team

class TeamAdapter(val listener: (Team) -> Unit): RecyclerView.Adapter<TeamAdapter.ViewHolder>() {

    var teams = emptyList<Team>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val view = parent.inflate(R.layout.view_team,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        holder.bind(teams[position])
        holder.itemView.setOnClickListener {
            listener(teams[position])
        }
    }

    override fun getItemCount(): Int = teams.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val binding = ViewTeamBinding.bind(view)

        fun bind(team: Team){
            binding.textId.text = "#${team.id.toString()}"
            binding.textName.text = team.fullName
            binding.textConference.text = team.conference

        }
    }
}