package com.example.news_fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.news_fragment.databinding.NewsItemBinding

class Adapter (val nItem: MutableList<NewsItem>) : RecyclerView.Adapter<Adapter.Holder>() {

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }
    var itemClick: ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.Holder {
        val binding = NewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position)
        }
        holder.binding.itemImg.setImageResource(nItem[position].img)
        holder.binding.itemText.text = nItem[position].title
    }

    override fun getItemId(position: Int): Long {
        return  position.toLong()
    }

    override fun getItemCount(): Int {
        return  nItem.size
    }



    inner class Holder(val binding: NewsItemBinding) : RecyclerView.ViewHolder(binding.root)

}
