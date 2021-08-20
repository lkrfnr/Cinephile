package com.lkrfnr.cinephileapp.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.lkrfnr.cinephileapp.ui.adapter.HomePageRecyclerAdapter.HomePageRecyclerViewHolder
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.lkrfnr.cinephileapp.R

class HomePageRecyclerAdapter(
    private val recyclerItems: List<Map<String, List<*>>>,
    private val clickListener: View.OnClickListener
) : RecyclerView.Adapter<HomePageRecyclerViewHolder>() {
    class HomePageRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePageRecyclerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.home_page_recycler_item_view, parent, false)
        return HomePageRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomePageRecyclerViewHolder, position: Int) {}
    override fun getItemCount(): Int {
        return 0
    }
}