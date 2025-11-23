package com.example.waterpark_app.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SupabaseApiClient {

    private const val BASE_URL = "https://fvjsbphcgifdppdqbqnt.supabase.co/rest/v1/"
    private const val API_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImZ2anNicGhjZ2lmZHBwZHFicW50Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NjM4MzgzMTksImV4cCI6MjA3OTQxNDMxOX0.L7UEdhEiid7UCoPf6e0wpPr5RN3vXf8HeVptvRTCIrc"

    private val client = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("apikey", API_KEY)
                .addHeader("Authorization", "Bearer $API_KEY")
                .addHeader("Content-Type", "application/json")
                .build()
            chain.proceed(request)
        }
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        )
        .build()

    val apiService: SupabaseApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(SupabaseApiService::class.java)
    }
}