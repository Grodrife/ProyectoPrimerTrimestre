package com.gabrielrf.proyecto.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gabrielrf.proyecto.model.Team

class DetailViewModel(team: Team): ViewModel(){
    private val _team = MutableLiveData(team)
    val team: LiveData<Team> get() = _team
}

@Suppress("UNCHECKED_CAST")
class DetailViewModelFactory(private val team: Team): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T{
        return DetailViewModel(team) as T
    }
}