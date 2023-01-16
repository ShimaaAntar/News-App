package com.example.newsapplication.api.model

import com.example.newsapplication.api.model.SourcesItem
import com.google.gson.annotations.SerializedName

data class SourcesResponse(

    @field:SerializedName("sources")
	val sources: List<SourcesItem?>? = null,

    @field:SerializedName("status")
	val status: String? = null,

    @field:SerializedName("code")
    val code: String? = null,
    @field:SerializedName("message")
    val message: String? = null

)