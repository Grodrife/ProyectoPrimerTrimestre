package com.gabrielrf.proyecto.ui.main

import androidx.lifecycle.*
import com.gabrielrf.proyecto.model.Team
import com.gabrielrf.proyecto.model.server.RemoteConnection
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(api_key: String): ViewModel(){
    private val _state = MutableLiveData(UiState())
    val state: LiveData<UiState> get() = _state

    init {
        viewModelScope.launch(Dispatchers.Main) {
            _state.value = _state.value?.copy(loading = true)
            val result = RemoteConnection.service.getTeams()

            val teams = result.team.map {
                Team(
                    it.id,it.abbreviation,it.city,it.conference,it.division,it.fullName,it.name
                )
            }
            _state.value = _state.value?.copy(loading = false, teams = teams)
        }
    }


    fun navigateTo(team: Team){
        _state.value = _state.value?.copy(navigateTo = team)
    }

    fun onNavigateDone(){
        _state.value = _state.value?.copy(navigateTo = null)
    }

    data class UiState(
        val loading: Boolean = false,
        val teams: List<Team>? = null,
        val navigateTo: Team? = null
    )
}

class MainViewModelFactory(private val api_key: String): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T{
        return MainViewModel(api_key) as T
    }
}