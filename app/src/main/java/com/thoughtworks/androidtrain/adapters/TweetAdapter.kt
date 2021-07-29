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

    companion object {
        const val FOOTER_VIEW = 1
    }

    open class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    class NormalViewHolder(view: View) : ViewHolder(view) {
        val nickNameView: TextView = view.findViewById(R.id.tweet_nickname)
        val contentView: TextView = view.findViewById(R.id.tweet_content)
    }

    class FooterViewHolder(view: View) : ViewHolder(view)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            FOOTER_VIEW -> {
                val view = LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.recycler_view_footer, viewGroup, false)
                FooterViewHolder(view)
            }
            else -> {
                val view = LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.tweet_row_item, viewGroup, false)
                NormalViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        when (viewHolder) {
            is NormalViewHolder -> {
                viewHolder.nickNameView.text = dataset[position].sender.nick
                viewHolder.contentView.text = dataset[position].content
            }
        }
    }

    override fun getItemCount(): Int = dataset.size + 1

    override fun getItemViewType(position: Int): Int {
        if (position == dataset.size) {
            return FOOTER_VIEW
        }
        return super.getItemViewType(position)
    }

}
