package com.example.waterpark_app.ui.ticket

data class TicketModel(
    val title: String,
    val description: String,
    val price: String,
    val originalPrice: String,
    val discount: String,
    val rating: Double,
    val reviews: String,
    val buttonText: String,
    val imageResId: Int
)
