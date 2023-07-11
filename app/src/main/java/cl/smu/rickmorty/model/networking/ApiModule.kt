package cl.smu.rickmorty.model.networking

import cl.smu.rickmorty.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiModule {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService:ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}