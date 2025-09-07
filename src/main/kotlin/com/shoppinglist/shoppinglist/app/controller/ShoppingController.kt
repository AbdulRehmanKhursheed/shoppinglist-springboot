package com.shoppinglist.shoppinglist.app.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/shopping")
class ShoppingController {
    
    // Endpoint 1: Get recipe tags
    @GetMapping("/recipes/{recipeName}/tags")
    fun getRecipeTags(@PathVariable recipeName: String): List<String> {
        val recipes = mapOf(
            "biryani" to listOf("aloo", "rice", "chicken", "oil", "onion", "garlic", "ginger", "spices", "saffron", "mint", "yogurt"),
            "qorma" to listOf("qorma masala", "chicken", "oil", "dahi", "onion", "garlic", "ginger", "cream", "almonds"),
            "pasta" to listOf("pasta", "tomato", "onion", "garlic", "cheese", "oil", "basil", "oregano", "salt"),
            "pizza" to listOf("dough", "tomato", "cheese", "basil", "olive oil", "salt", "yeast")
        )
        return recipes[recipeName.lowercase()] ?: emptyList()
    }
    
    // Endpoint 2: Get products by tags
    @GetMapping("/products")
    fun getProductsByTags(@RequestParam tags: String): List<Map<String, Any>> {
        val tagList = tags.split(",").map { it.trim() }
        val products = listOf(
            mapOf("id" to "aloo-001", "name" to "Potatoes (Aloo)", "category" to "vegetables", "price" to 1.50, "unit" to "kg"),
            mapOf("id" to "rice-001", "name" to "Basmati Rice", "category" to "grains", "price" to 2.50, "unit" to "kg"),
            mapOf("id" to "chicken-001", "name" to "Chicken", "category" to "meat", "price" to 8.99, "unit" to "kg"),
            mapOf("id" to "oil-001", "name" to "Cooking Oil", "category" to "oils", "price" to 3.99, "unit" to "1L"),
            mapOf("id" to "onion-001", "name" to "Onions", "category" to "vegetables", "price" to 1.99, "unit" to "kg"),
            mapOf("id" to "garlic-001", "name" to "Garlic", "category" to "vegetables", "price" to 3.50, "unit" to "kg"),
            mapOf("id" to "ginger-001", "name" to "Ginger", "category" to "vegetables", "price" to 4.99, "unit" to "kg"),
            mapOf("id" to "spices-001", "name" to "Mixed Spices", "category" to "spices", "price" to 5.99, "unit" to "100g"),
            mapOf("id" to "saffron-001", "name" to "Saffron", "category" to "spices", "price" to 25.99, "unit" to "1g"),
            mapOf("id" to "mint-001", "name" to "Fresh Mint", "category" to "herbs", "price" to 2.99, "unit" to "bunch"),
            mapOf("id" to "yogurt-001", "name" to "Yogurt (Dahi)", "category" to "dairy", "price" to 4.99, "unit" to "500g"),
            mapOf("id" to "qorma-masala-001", "name" to "Qorma Masala", "category" to "spices", "price" to 6.99, "unit" to "50g"),
            mapOf("id" to "cream-001", "name" to "Heavy Cream", "category" to "dairy", "price" to 3.99, "unit" to "250ml"),
            mapOf("id" to "almonds-001", "name" to "Almonds", "category" to "nuts", "price" to 12.99, "unit" to "200g"),
            mapOf("id" to "pasta-001", "name" to "Spaghetti", "category" to "grains", "price" to 3.99, "unit" to "500g"),
            mapOf("id" to "tomato-001", "name" to "Tomatoes", "category" to "vegetables", "price" to 2.99, "unit" to "kg"),
            mapOf("id" to "cheese-001", "name" to "Mozzarella Cheese", "category" to "dairy", "price" to 6.99, "unit" to "250g"),
            mapOf("id" to "basil-001", "name" to "Fresh Basil", "category" to "herbs", "price" to 3.99, "unit" to "bunch"),
            mapOf("id" to "oregano-001", "name" to "Dried Oregano", "category" to "spices", "price" to 4.99, "unit" to "50g"),
            mapOf("id" to "salt-001", "name" to "Salt", "category" to "condiments", "price" to 1.99, "unit" to "1kg"),
            mapOf("id" to "dough-001", "name" to "Pizza Dough", "category" to "grains", "price" to 2.99, "unit" to "500g"),
            mapOf("id" to "yeast-001", "name" to "Active Dry Yeast", "category" to "baking", "price" to 3.49, "unit" to "10g")
        )
        
        return products.filter { product ->
            tagList.any { tag ->
                product["name"]?.toString()?.contains(tag, ignoreCase = true) == true ||
                product["category"]?.toString()?.contains(tag, ignoreCase = true) == true
            }
        }
    }
}
