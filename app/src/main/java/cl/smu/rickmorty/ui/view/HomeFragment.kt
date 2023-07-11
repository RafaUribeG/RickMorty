package cl.smu.rickmorty.ui.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import cl.smu.rickmorty.databinding.FragmentHomeBinding
import cl.smu.rickmorty.ui.adapter.RickMortyAdapter
import cl.smu.rickmorty.ui.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    //Lazy Initialization
    private val binding by lazy { FragmentHomeBinding.inflate(layoutInflater) }

    private val viewModel : HomeViewModel by activityViewModels()

    private lateinit var characterAdapter : RickMortyAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecycler()
        initObserver()

    }

    private fun initObserver() {
        viewModel.getCharacters()
        viewModel.charactersList.observe(viewLifecycleOwner, Observer { characters ->
            binding.rvHome.adapter = RickMortyAdapter(characters) { onItemSelected() }
        })
    }

    private fun onItemSelected(){
        Toast.makeText(context, "Click", Toast.LENGTH_SHORT).show()
    }

    private fun initRecycler() {
        val myRecyclerView = binding.rvHome
        myRecyclerView.layoutManager = LinearLayoutManager(context)
        myRecyclerView.adapter = characterAdapter
    }
}