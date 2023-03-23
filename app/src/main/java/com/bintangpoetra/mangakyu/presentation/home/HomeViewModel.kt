package com.bintangpoetra.mangakyu.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bintangpoetra.mangakyu.data.lib.Results
import com.bintangpoetra.mangakyu.domain.anime.AnimeUseCase
import com.bintangpoetra.mangakyu.domain.anime.model.Anime
import com.bintangpoetra.mangakyu.domain.manga.MangaUseCase
import com.bintangpoetra.mangakyu.domain.manga.model.Manga
import kotlinx.coroutines.launch

class HomeViewModel(
    private val mangaUseCase: MangaUseCase,
    private val animeUseCase: AnimeUseCase
) : ViewModel() {

    private val _mangaList = MutableLiveData<Results<List<Manga>>>()
    val mangaList: LiveData<Results<List<Manga>>> get() = _mangaList

    private val _animeList = MutableLiveData<Results<List<Anime>>>()
    val animeList: LiveData<Results<List<Anime>>> get() = _animeList

    fun getMangaList() {
        viewModelScope.launch {
            mangaUseCase.getMangaList().collect {
                _mangaList.value = it
            }
        }
    }

    fun getAnimeList() {
        viewModelScope.launch {
            animeUseCase.getAnimeList().collect {
                _animeList.value = it
            }
        }
    }

}