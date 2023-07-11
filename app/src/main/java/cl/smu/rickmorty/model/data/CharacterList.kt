package cl.smu.rickmorty.model.data

import com.google.gson.annotations.SerializedName

data class CharacterList(
    @SerializedName("results") val results: List<Character>
)

