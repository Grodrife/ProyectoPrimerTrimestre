package com.gabrielrf.proyecto.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.gabrielrf.proyecto.R
import com.gabrielrf.proyecto.databinding.FragmentDetailBinding
import com.gabrielrf.proyecto.loadUrl
import com.gabrielrf.proyecto.model.Team

class DetailFragment : Fragment(R.layout.fragment_detail){
    private val viewModel: DetailViewModel by viewModels {
        DetailViewModelFactory(arguments?.getParcelable<Team>(EXTRA_TEAM)!!)
    }
    companion object{
        const val EXTRA_TEAM = "DetailActivity:Team"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentDetailBinding.bind(view)

        viewModel.team.observe(viewLifecycleOwner){ team ->
            (requireActivity() as AppCompatActivity).supportActionBar?.title = team.abbreviation
            binding.textName.text = team.fullName
            binding.textAbr.text = team.abbreviation
            binding.textCity.text = "Ciudad: "+ team.city
            binding.textConference.text = "Conferencia: " + team.conference
            binding.textDivision.text = "Division: " + team.division
        }

    }
}