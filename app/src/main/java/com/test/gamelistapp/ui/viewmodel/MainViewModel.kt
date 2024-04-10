package com.test.gamelistapp.ui.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.test.gamelistapp.data.model.games.Games
import com.test.gamelistapp.data.model.games.ListAllGames
import com.test.gamelistapp.data.repository.GameRepository
import com.test.gamelistapp.ui.BaseViewModel
import com.test.gamelistapp.utillity.state.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    app: Application,
    private val repo: GameRepository
) : BaseViewModel(app){

    private val _listGame = MutableLiveData<Resource<ListAllGames>>()
    val listGame: LiveData<Resource<ListAllGames>> get() = _listGame

    fun getGames(): Flow<PagingData<Games>> {
        return repo.getAllGames().cachedIn(viewModelScope)
    }

}