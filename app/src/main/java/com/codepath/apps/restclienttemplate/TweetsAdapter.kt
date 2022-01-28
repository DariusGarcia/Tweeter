package com.codepath.apps.restclienttemplate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codepath.apps.restclienttemplate.models.Tweet

class TweetsAdapter(val tweets: ArrayList<Tweet>) : RecyclerView.Adapter<TweetsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TweetsAdapter.ViewHolder {
       // Responsible for inflating layout for each item into the recycler view.
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        // Inflate our item layout
        val view = inflater.inflate(R.layout.item_tweet, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: TweetsAdapter.ViewHolder, position: Int) {
        // In charge of populating date into the item through view holder.
        // Get teh data model based on the position.
        val tweet: Tweet = tweets.get(position)

        // Set item views based on views and data model.
        holder.tvUserName.text = tweet.user?.name // '?' signifies it that if the user was not parsed correctly and we don't have a user object as part of the tweet objet then the name will just be blank.
        holder.tvTweetBody.text = tweet.body

        var formattedTime = TimeFormatter.getTimeDifference(tweet.createdAt)
        holder.tvTime.text = formattedTime
        // Use glide
        Glide.with(holder.itemView).load(tweet.user?.publicImageUrl).into(holder.ivProfileImage)
    }

    override fun getItemCount(): Int { // method to tell adapter how many views are going to be in the recyclerview.
        return tweets.size
    }
        /* Within the RecyclerView.Adapter class */
        // Clean all elements of the recycler
        fun clear() {
            tweets.clear()
            notifyDataSetChanged()
        }

        // Add a list of items -- change to type used
        fun addAll(tweetList: List<Tweet>) {
            tweets.addAll(tweetList)
            notifyDataSetChanged()
        }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivProfileImage = itemView.findViewById<ImageView>(R.id.ivProfileImage)
        val tvUserName = itemView.findViewById<TextView>(R.id.tvUsername)
        val tvTweetBody = itemView.findViewById<TextView>(R.id.tvTweetBody)
        val tvTime = itemView.findViewById<TextView>(R.id.tvTime)
    }
}