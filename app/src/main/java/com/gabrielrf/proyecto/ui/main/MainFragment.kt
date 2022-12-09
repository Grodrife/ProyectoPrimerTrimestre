package com.gabrielrf.proyecto.ui.main

import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.gabrielrf.proyecto.R
import com.gabrielrf.proyecto.databinding.FragmentMainBinding
import com.gabrielrf.proyecto.ui.detail.DetailFragment

class MainFragment : Fragment(R.layout.fragment_main) {
    private val viewModel: MainViewModel by viewModels { MainViewModelFactory(getString(R.string.api_key))}
    private lateinit var binding: FragmentMainBinding
    private val adapter = TeamAdapter(){ team -> viewModel.navigateTo(team)}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view).apply {
            recycler.adapter = adapter
        }

        (requireActivity() as AppCompatActivity).supportActionBar?.title = "NBA TEAMS"

        viewModel.state.observe(viewLifecycleOwner){ state ->
            binding.progress.visibility = if (state.loading) VISIBLE else GONE
            state.teams?.let {
                adapter.teams = state.teams
                adapter.notifyDataSetChanged()
            }

            state.navigateTo?.let {
                findNavController().navigate(
                    R.id.action_mainFragment_to_detailFragment,
                    bundleOf(DetailFragment.EXTRA_TEAM to it)
                )
                viewModel.onNavigateDone()
            }
        }

    }

}

