package cl.smu.rickmorty.model.repository


import cl.smu.rickmorty.model.data.CharacterList
import cl.smu.rickmorty.model.networking.ApiModule
import retrofit2.Response


class RickMortyRepository {

    suspend fun getCharacters(page:Int) :Response<CharacterList>{
        return ApiModule.apiService.getCharacters(page)
    }
    /*
    val apiService: ApiService = ApiModule.getRetrofit().create(ApiService::class.java)

    suspend fun getCharacters(): List<CharacterDetail>{
        return withContext(Dispatchers.IO){
            val response = apiService.getCharacters()
            if (response.isSuccessful){
                val character = response.body()?.results ?: emptyList()
                character
            }else{
                Log.e("Rafael", "DataError")
                emptyList()
            }
        }
    }*/
}