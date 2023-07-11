package cl.smu.rickmorty.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import cl.smu.rickmorty.R
import cl.smu.rickmorty.databinding.ItemApiBinding
import cl.smu.rickmorty.model.data.CharacterModel


class RickMortyAdapter(
    private var rickAndMortyList: List<CharacterModel>,
    private val onItemSelected: () -> Unit
) : RecyclerView.Adapter<RickMortyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RickMortyViewHolder {
        val binding = ItemApiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RickMortyViewHolder(binding)
    }

    override fun getItemCount(): Int = rickAndMortyList.size

    fun updateList(rickAndMortyList: List<CharacterModel>) {
        this.rickAndMortyList = rickAndMortyList
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RickMortyViewHolder, position: Int) {
        val item = rickAndMortyList[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            onItemSelected
        }
    }
}
