package com.example.newsapplication.api

import com.example.newsapplication.api.model.SourcesResponse
import org.intellij.lang.annotations.Language
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WebServices {
    @GET("sources")
    fun getNewsSources(@Query("apiKey") key:String,
                       @Query("language") language:String,
                       @Query("country") country:String):Call<SourcesResponse>

}