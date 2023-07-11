package cl.smu.rickmorty.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.smu.rickmorty.model.data.CharacterList
import cl.smu.rickmorty.model.repository.RickMortyRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel(val respository: RickMortyRepository) : ViewModel() {


    var charactersList = MutableLiveData<Response<CharacterList>>()
    /*
    private val repository = RickMortyRepository()
    val characters = MutableLiveData<List<CharacterDetail>>()
    */
    fun getCharacters(page:Int){
        viewModelScope.launch {
            val characterFromRepo = respository.getCharacters(page)
            if (characterFromRepo.isSuccessful){
                charactersList.postValue(characterFromRepo)
            }
        }
    }
}

/*
if (characterFromRepo.isNotEmpty()){
    characters.postValue(characterFromRepo)
}*/