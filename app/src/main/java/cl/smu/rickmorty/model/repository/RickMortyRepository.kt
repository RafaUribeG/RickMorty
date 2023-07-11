package cl.smu.rickmorty.model.repository


import android.util.Log
import cl.smu.rickmorty.model.data.CharacterList
import cl.smu.rickmorty.model.data.CharacterModel
import cl.smu.rickmorty.model.networking.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class RickMortyRepository @Inject constructor(private val apiService: ApiService) {


    suspend fun getCharacters(): List<CharacterModel> {
        return withContext(Dispatchers.IO) {
            val response = apiService.getCharacters()
            if (response.isSuccessful){
                val character = response.body()?.results ?: emptyList()
                character
            }else {
                emptyList()
            }
        }
    }
}