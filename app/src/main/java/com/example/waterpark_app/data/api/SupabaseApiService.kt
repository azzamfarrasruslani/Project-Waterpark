package com.example.waterpark_app.data.api


import com.example.waterpark_app.data.model.HistoryModel
import com.example.waterpark_app.data.model.ShopModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SupabaseApiService {

    @GET("history")
    fun getHistory(
        @Query("select") select: String = "*",
        @Query("order") order: String = "created_at.desc"
    ): Call<List<HistoryModel>>

    @GET("shop")
    fun getShopItems(
        @Query("select") select: String = "*"
    ): Call<List<ShopModel>>

}