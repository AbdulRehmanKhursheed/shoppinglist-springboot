package com.shoppinglist.shoppinglist

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ShoppinglistBackEndApplication

fun main(args: Array<String>) {
	runApplication<ShoppinglistBackEndApplication>(*args)
}
