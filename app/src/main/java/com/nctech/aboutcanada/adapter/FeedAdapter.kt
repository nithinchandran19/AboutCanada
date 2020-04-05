package com.nctech.aboutcanada.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nctech.aboutcanada.R
import com.nctech.aboutcanada.network.helper.CoreManager
import com.nctech.aboutcanada.network.model.responsemodel.FeedDetails
import kotlinx.android.synthetic.main.feed_list_item.view.*

/**
 * Adapter class for Binding  Feed list
 */
class FeedAdapter(private var listData: ArrayList<FeedDetails>) :
    RecyclerView.Adapter<FeedAdapter.CustomViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.feed_list_item, parent, false)
        return CustomViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val feedDetails = listData[position]
        holder.listItemView.list_header.text = feedDetails.title
        holder.listItemView.list_details.text = feedDetails.description
        Glide.with(CoreManager.getContext()!!).load(feedDetails.imageHref)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(holder.listItemView.listImageView); }

    class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val listItemView = view
    }

}