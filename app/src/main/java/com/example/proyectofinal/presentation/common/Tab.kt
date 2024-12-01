package com.example.proyectofinal.presentation.common

enum class Tab(val index: Int) {
        Characters(0),
        Comics(1),
        Series(2);

    companion object {
        fun fromIndex(index: Int): Tab? = entries.find { it.index == index }
    }
}