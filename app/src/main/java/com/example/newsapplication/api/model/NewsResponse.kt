package com.example.newsapplication.api.model

import com.google.gson.annotations.SerializedName

 class NewsResponse(

	@field:SerializedName("totalResults")
	val totalResults: Int? = null,

	@field:SerializedName("articles")
	val articles: List<ArticlesItem?>? = null,

	@field:SerializedName("status")
	val status: String? = null,
	 @field:SerializedName("message")
     val message: String? = null
)