package com.edushare.mergeadapterintro.view

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.MergeAdapter
import androidx.recyclerview.widget.RecyclerView
import com.edushare.mergeadapterintro.R
import com.edushare.mergeadapterintro.adapter.PokemonAdapter
import com.edushare.mergeadapterintro.adapter.WhatsNewAdapter
import com.edushare.mergeadapterintro.databinding.ActivityMainBinding
import com.edushare.mergeadapterintro.getPokemonFactory
import com.edushare.mergeadapterintro.model.WhatsNew

class MainActivity : AppCompatActivity(), WhatsNewAdapter.WhatsNewListener {

    private lateinit var whatsNewAdapter: WhatsNewAdapter
    private lateinit var pokemonAdapter: PokemonAdapter
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initRecyclerView()
        fetchNewFeatureDataFromServer()
        fetchPokemon()
    }

    private fun fetchNewFeatureDataFromServer() {
        Handler().postDelayed({
            whatsNewAdapter.whatsNew =
                WhatsNew("Clicking the dismiss button will make this card disappear with an animation!")
            whatsNewAdapter.notifyItemInserted(0)
           binding.feedRecyclerView.scrollToPosition(0)
        }, 2_000L)
    }

    private fun initRecyclerView() {
        whatsNewAdapter = WhatsNewAdapter(this)
        pokemonAdapter = PokemonAdapter()

        binding.feedRecyclerView.adapter = MergeAdapter(whatsNewAdapter, pokemonAdapter)
    }

    private fun fetchPokemon() {
        val listOfPokemons = getPokemonFactory().sortedBy { it.name }
        pokemonAdapter.pokemons = listOfPokemons
        pokemonAdapter.notifyItemRangeInserted(0, listOfPokemons.size)
        binding.feedRecyclerView.scrollToPosition(0)
    }

    override fun onDismiss() {
        whatsNewAdapter.whatsNew = null
        whatsNewAdapter.notifyItemRemoved(0)
    }

}


