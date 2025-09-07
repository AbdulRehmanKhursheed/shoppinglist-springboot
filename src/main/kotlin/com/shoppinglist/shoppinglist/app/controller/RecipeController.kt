package com.shoppinglist.shoppinglist.app.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/recipes")
class RecipeController {
    
    @GetMapping("/{recipeName}/tags")
    fun getRecipeTags(@PathVariable recipeName: String): List<String> {
        val recipes = mapOf(
            "biryani" to listOf("aloo", "rice", "chicken", "oil", "onion", "garlic", "ginger", "spices", "saffron", "mint", "yogurt"),
            "qorma" to listOf("qorma masala", "chicken", "oil", "dahi", "onion", "garlic", "ginger", "cream", "almonds"),
            "pasta" to listOf("pasta", "tomato", "onion", "garlic", "cheese", "oil", "basil", "oregano", "salt"),
            "pizza" to listOf("dough", "tomato", "cheese", "basil", "olive oil", "salt", "yeast")
        )
        return recipes[recipeName.lowercase()] ?: emptyList()
    }
}