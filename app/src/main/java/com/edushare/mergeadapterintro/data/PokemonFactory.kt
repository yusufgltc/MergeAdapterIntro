package com.edushare.mergeadapterintro

import com.edushare.mergeadapterintro.model.Pokemon

fun getPokemonFactory(): List<Pokemon> {
    return listOf<Pokemon>(
        Pokemon(
            "Bulbasuar",
            "Water",
            image = R.drawable.bulbasuar
        ),
        Pokemon(
            "Cubone",
            "Earth",
            image = R.drawable.cubone
        ),
        Pokemon(
            "Dragonite",
            "Legend",
            image = R.drawable.dragonite
        ),
        Pokemon(
            "Gengar",
            "Dark",
            image = R.drawable.gengar
        ),
        Pokemon(
            "Snorlax",
            "Earth",
            image = R.drawable.snorlax
        ),
        Pokemon(
            "Flareon",
            "Fire",
            image = R.drawable.flareon
        ),
        Pokemon(
            "Squirtle",
            "Water",
            image = R.drawable.squirtle
        )
    )
}