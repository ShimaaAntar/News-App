package com.example.newsapplication

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import com.example.islami.Base.BaseActivity
import com.example.newsapplication.api.ApiManager
import com.example.newsapplication.api.model.ArticlesItem
import com.example.newsapplication.api.model.NewsResponse
import com.example.newsapplication.api.model.SourcesItem
import com.example.newsapplication.api.model.SourcesResponse
import com.example.newsapplication.databinding.ActivityHomePageBinding
import com.google.android.material.tabs.TabLayout
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response

class HomePage :BaseActivity(),TabLayout.OnTabSelectedListener {
    lateinit var binding: ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getSources()
    }

    private fun getSources() {
        ApiManager.getApi()
            .getNewsSources(Constants.apiKey,
                "en", country = "us")
            .enqueue(object :Callback<SourcesResponse>{
                override fun onResponse(
                    call: Call<SourcesResponse>,
                    response: Response<SourcesResponse>
                ) {
                    binding.progressPar.visibility= View.GONE
                    if (response.isSuccessful){
                        showSourceInTabLayout(response.body()?.sources)
                    }
                    else{
                        showDialoge(message = response.body()?.message?:"",
                            posActionName = getString(R.string.ok), posAction =DialogInterface.OnClickListener{dialog, which ->
                                dialog.dismiss()
                            }  )
                    }
                }

                override fun onFailure(call: Call<SourcesResponse>, t: Throwable) {
                    binding.progressPar.visibility= View.GONE
                    showDialoge(message =t.localizedMessage, posActionName =getString(R.string.retry) ,
                        posAction =DialogInterface.OnClickListener{dialog, which ->
                            call.clone().enqueue(this)
                            dialog.dismiss()
                        } )
                }

            })
    }

    private fun showSourceInTabLayout(sources: List<SourcesItem?>?) {
        sources?.forEach{item ->
            val tab= binding.tabLayout.newTab()
            tab.setText(item?.name)
            tab.setTag(item)
            binding.tabLayout.addTab(tab)
        }
        binding.tabLayout.addOnTabSelectedListener(this)
    }
    override fun onTabSelected(tab: TabLayout.Tab?) {
        val item = tab?.tag as SourcesItem
        getNews(item.id)
    }
    override fun onTabUnselected(tab: TabLayout.Tab?) {
        TODO("Not yet implemented")
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {
        TODO("Not yet implemented")
    }
    private fun getNews(sourceId: String?) {
        ApiManager.getApi()
            .getNews(Constants.apiKey,"en","")
            .enqueue(object :Callback<NewsResponse>{
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    if (response.isSuccessful){
                        showNewsInRecycleView(response.body()?.articles)
                    }
                    else{
                        showDialoge(message = response.body()?.message?:"",
                            posActionName = getString(R.string.ok),
                            posAction =DialogInterface.OnClickListener{dialog, which ->
                                dialog.dismiss()
                            })
                    }
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    showDialoge(message =t.localizedMessage, posActionName =getString(R.string.retry) ,
                        posAction =DialogInterface.OnClickListener{dialog, which ->
                            call.clone().enqueue(this)
                            dialog.dismiss()
                        } )
                }

            })
    }

    private fun showNewsInRecycleView(newsList: List<ArticlesItem?>?) {
        TODO("Not yet implemented")
    }
}