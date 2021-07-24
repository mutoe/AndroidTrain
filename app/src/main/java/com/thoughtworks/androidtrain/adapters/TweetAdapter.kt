package com.thoughtworks.androidtrain.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.thoughtworks.androidtrain.R
import com.thoughtworks.androidtrain.model.Tweet

class TweetAdapter(private var dataset: List<Tweet>) :
    RecyclerView.Adapter<TweetAdapter.ViewHolder>() {

    fun setTweets(tweets: List<Tweet>) {
        dataset = tweets
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nickNameView: TextView
        val contentView: TextView

        init {
            nickNameView = view.findViewById(R.id.tweet_nickname)
            contentView = view.findViewById(R.id.tweet_content)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.tweet_row_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.nickNameView.text = dataset[position].sender.nick
        viewHolder.contentView.text = dataset[position].content
    }

    override fun getItemCount(): Int = dataset.size
}
