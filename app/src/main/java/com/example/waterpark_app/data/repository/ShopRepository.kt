package com.example.waterpark_app.data.repository

import com.example.waterpark_app.data.api.SupabaseApiClient
import com.example.waterpark_app.data.model.ShopModel
import retrofit2.Call

class ShopRepository {

    private val api = SupabaseApiClient.apiService

    fun getAllShopItems(): Call<List<ShopModel>> {
        return api.getShopItems()
    }
}
