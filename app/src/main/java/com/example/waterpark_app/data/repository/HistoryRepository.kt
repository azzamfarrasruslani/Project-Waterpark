package com.example.waterpark_app.data.repository

import com.example.waterpark_app.data.api.SupabaseApiClient
import com.example.waterpark_app.data.model.HistoryModel
import retrofit2.Call

class HistoryRepository {
    private val api = SupabaseApiClient.apiService

    // Nama harus konsisten dengan yang dipanggil Fragment
    fun getAllHistory(): Call<List<HistoryModel>> {
        return api.getHistory()
    }
}
