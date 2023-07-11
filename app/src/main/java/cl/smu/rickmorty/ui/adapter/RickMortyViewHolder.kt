package cl.smu.rickmorty.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import cl.smu.rickmorty.databinding.ItemApiBinding
import cl.smu.rickmorty.model.data.Character
import com.squareup.picasso.Picasso

class RickMortyViewHolder(val binding : ItemApiBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(detail: Character){
        binding.tvNameCharacter.text = detail.name
        binding.tvSpecies.text = detail.species
        binding.tvStatus.text = detail.status
        Picasso.get().load(detail.image).into(binding.myView)

    }
}