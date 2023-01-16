package com.example.newsapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapplication.api.model.ArticlesItem

class NewsAdapter(var newsList:List<ArticlesItem?>?):
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val date: TextView =itemView.findViewById(R.id.data)
        val title: TextView =itemView.findViewById(R.id.title)
        val image: ImageView =itemView.findViewById(R.id.image)
        val desc: TextView =itemView.findViewById(R.id.desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_news ,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val newsItem =newsList?.get(position)
        holder.date.setText(newsItem?.publishedAt)
        holder.title.setText(newsItem?.title)
        holder.desc.setText(newsItem?.description)

    }
    fun changeData(newsList: List<ArticlesItem?>?){
        this.newsList=newsList
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return newsList?.size?:0
    }
}
//        if (onPlayClickListener!=null){
//            holder.play.setOnClickListener{
//                onPlayClickListener?.onItemClick(position,item!!)
//            }
//        }
//        if (onStopClickListener!=null){
//            holder.stop.setOnClickListener{
//                onStopClickListener?.onItemClick(position,item!!)
//            }
//        }
//
//
//    }
//    var onStopClickListener:OnItemClickListener?=null
//    var onPlayClickListener:OnItemClickListener?=null
//    interface OnItemClickListener{
//        fun onItemClick(position: Int,radioUrl:RadiosChannel)
//    }
//
