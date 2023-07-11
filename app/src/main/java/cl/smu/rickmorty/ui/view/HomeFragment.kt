package cl.smu.rickmorty.ui.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cl.smu.rickmorty.databinding.FragmentHomeBinding
import cl.smu.rickmorty.ui.adapter.RickMortyAdapter
import cl.smu.rickmorty.ui.viewmodel.HomeViewModel


class HomeFragment : Fragment() {

    //Lazy Initialization
    private val binding by lazy { FragmentHomeBinding.inflate(layoutInflater) }

    private lateinit var myRecyclerView : RecyclerView
    //ViewModel
    private val viewModel : HomeViewModel by viewModels()

    //Adapter
    private lateinit var adapter : RickMortyAdapter()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel.getCharacters(1)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        //Recycler
        myRecyclerView = binding.rvHome
        myRecyclerView.layoutManager = LinearLayoutManager(context)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.charactersList.observe(viewLifecycleOwner, {response ->
            if (response.isSuccessful){
                adapter.updateList(response.body().results)
            }else{
                Log.d("RE")
            }
        })





    }







}