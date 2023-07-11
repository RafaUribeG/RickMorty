package cl.smu.rickmorty.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.smu.rickmorty.domain.GetCharactersUseCase
import cl.smu.rickmorty.model.data.CharacterList
import cl.smu.rickmorty.model.data.CharacterModel
import cl.smu.rickmorty.model.repository.RickMortyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getCharactersUseCase: GetCharactersUseCase) : ViewModel() {


    var charactersList = MutableLiveData<List<CharacterModel>>()

    fun getCharacters(){
        viewModelScope.launch {
            val result = getCharactersUseCase()
            charactersList.postValue(result)
        }
    }
}

/*
   private val repository = RickMortyRepository()
   val characters = MutableLiveData<List<CharacterDetail>>()
   */
/*
if (characterFromRepo.isNotEmpty()){
    characters.postValue(characterFromRepo)
}*/