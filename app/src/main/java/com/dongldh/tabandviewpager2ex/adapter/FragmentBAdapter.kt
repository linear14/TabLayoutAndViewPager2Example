package com.dongldh.tabandviewpager2ex.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dongldh.tabandviewpager2ex.R
import com.dongldh.tabandviewpager2ex.data.Book
import kotlinx.android.synthetic.main.item_view_pager2.view.*

class PagerViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val title = view.book_title_text
    val author = view.book_author_text
    val published = view.book_published_text
}

class FragmentBAdapter(val list: MutableList<Book>): RecyclerView.Adapter<PagerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        return PagerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager2, parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        val item = list[position]

        holder.title.text = item.title
        holder.author.text = item.author
        holder.published.text = item.published
    }

}