package cl.smu.rickmorty.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import cl.smu.rickmorty.R
import cl.smu.rickmorty.databinding.ItemApiBinding
import cl.smu.rickmorty.model.data.CharacterList

class RickMortyAdapter(
    private var rickAndMortyList: List<CharacterList> = emptyList()
) : RecyclerView.Adapter<RickMortyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RickMortyViewHolder {
        val binding = ItemApiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RickMortyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return rickAndMortyList.size
    }

    fun updateList(rickAndMortyList: List<CharacterList>) {
        this.rickAndMortyList = rickAndMortyList
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RickMortyViewHolder, position: Int) {
        rickAndMortyList[position]
        holder.itemView.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_homeFragment_to_detailFragment)
        }
    }
}
}