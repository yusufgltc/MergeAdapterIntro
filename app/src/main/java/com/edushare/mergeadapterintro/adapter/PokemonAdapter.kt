package com.edushare.mergeadapterintro.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.edushare.mergeadapterintro.R
import com.edushare.mergeadapterintro.model.Pokemon

class PokemonAdapter : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    var pokemons: List<Pokemon> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
        return PokemonViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int = R.layout.item_pokemon

    override fun getItemCount(): Int {
        return pokemons.size
    }

    override fun onBindViewHolder(holder: PokemonAdapter.PokemonViewHolder, position: Int) {
        holder.bind(pokemons[position])
    }

    inner class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val name =  itemView.findViewById<TextView>(R.id.pokemonName)
        private val role =  itemView.findViewById<TextView>(R.id.pokemonRole)
        private val image =  itemView.findViewById<ImageView>(R.id.pokemonImage)

        fun bind(pokemon: Pokemon){
            name.text = pokemon.name
            role.text = pokemon.type
            image.setImageResource(pokemon.image)
        }
    }
}