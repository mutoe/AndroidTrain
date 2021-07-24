package com.thoughtworks.androidtrain

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.thoughtworks.androidtrain.adapters.TweetAdapter
import com.thoughtworks.androidtrain.constants.TweetsData
import com.thoughtworks.androidtrain.model.Tweet

class RecyclerViewActivity : AppCompatActivity() {
    private val gson = Gson()
    private val TAG = "RecyclerViewActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.getSupportActionBar()?.hide()
        setContentView(R.layout.recycler_view_layout)
        initUI()
    }

    private fun initUI() {
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val tweets = loadTweets().filterNot { it.content == null && it.sender?.avatar == null }
        recyclerView.adapter = TweetAdapter(tweets)
    }

    private fun loadTweets(): Array<Tweet> {
        val tweetsType = object : TypeToken<Array<Tweet>>() {}.type
        return gson.fromJson(TweetsData.data, tweetsType)
    }
}
