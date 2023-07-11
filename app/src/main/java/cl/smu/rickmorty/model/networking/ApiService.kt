package cl.smu.rickmorty.model.networking


import cl.smu.rickmorty.model.data.CharacterList
import cl.smu.rickmorty.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(Constants.END_POINT)
    suspend fun getCharacters(@Query("page") page: Int): Response<CharacterList>
}