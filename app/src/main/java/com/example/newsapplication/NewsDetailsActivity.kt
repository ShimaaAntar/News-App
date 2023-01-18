package com.example.newsapplication

import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.newsapplication.api.model.ArticlesItem
import com.example.newsapplication.databinding.ActivityNewsDetailsBinding

class NewsDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityNewsDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val item = intent.getSerializableExtra(Constants.ITEM) as ArticlesItem?
        binding.data.setText(item?.publishedAt)
        binding.title.setText(item?.title)
        Glide.with(this)
            .load(item?.urlToImage)
            .into(binding.image)
        binding.author.setText(item?.author)
        binding.content.setText(item?.content)

        binding.url.isClickable = true
        binding.url.movementMethod = LinkMovementMethod.getInstance()
        val text = "<a href='${item?.url}'> ${item?.source?.name} </a>"
        binding.url.text = Html.fromHtml(text)
    }

}