package cl.smu.rickmorty.domain

import cl.smu.rickmorty.model.repository.RickMortyRepository
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(private val repository:RickMortyRepository) {
    suspend operator fun invoke() = repository.getCharacters()
}