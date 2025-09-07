package com.shoppinglist.shoppinglist.domain.model

data class Recipe(
    val name: String,
    val tags: List<String>,
    val description: String? = null,
    val difficulty: String? = null
)
