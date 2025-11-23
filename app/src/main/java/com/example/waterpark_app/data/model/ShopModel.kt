package com.example.waterpark_app.data.model

data class ShopModel(
    val id: String,
    val name: String,
    val description: String,
    val price: Double,
    val stock: Int,
    val image_url: String,
    val category: String
)
