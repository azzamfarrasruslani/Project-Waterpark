package com.example.waterpark_app.data.model

data class HistoryModel(
    val id: Int,
    val orderId: String,
    val userId: String,
    val ticketId: Int,
    val title: String,
    val subtitle: String,
    val visitDate: String,
    val price: Double,
    val quantity: Int,
    val totalPrice: Double,
    val status: String,
    val paymentMethod: String?,
    val createdAt: String,
    val updatedAt: String?
)
