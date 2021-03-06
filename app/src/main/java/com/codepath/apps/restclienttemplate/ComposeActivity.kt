package com.codepath.apps.restclienttemplate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.codepath.apps.restclienttemplate.TimelineActivity.Companion.TAG
import com.codepath.apps.restclienttemplate.models.Tweet
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers

class ComposeActivity : AppCompatActivity() {

    lateinit var etCompose: EditText
    lateinit var btnTweet: Button
    lateinit var charCount: TextView

    lateinit var client: TwitterClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compose)

        etCompose = findViewById(R.id.etTweetCompose)
        btnTweet = findViewById(R.id.btnTweet)
        charCount = findViewById(R.id.charCount)

        client = TwitterApplication.getRestClient(this)


        etCompose.addTextChangedListener(object : TextWatcher
        {


            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                btnTweet.isEnabled = true



                if (etCompose.length() > 280) {
                    btnTweet.isEnabled = false
                }
                }


            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {



            }

            override fun afterTextChanged(s: Editable) {
                // Fires right after the text has changed
                val tweetLength = etCompose.text.toString()
                val int = tweetLength.length
                charCount.setText(int.toString() + " characters")

            }
        })

        //handling the users click on the tweet button
        btnTweet.setOnClickListener {

            //Grab the content of the edittext (etCompose)
            val tweetContent = etCompose.text.toString()

            // 1. Make sure the tweet isn't empty
            if (tweetContent.isEmpty()) {
                Toast.makeText(this, "Empty tweets not allowed!", Toast.LENGTH_SHORT)
                    .show()
                // Look into displaying SnackBar message
            } else
            // 2. Make sure the tweet is under character count.
                if (tweetContent.length > 140) {
                    Toast.makeText(
                        this, "Exceeded 140 character limit...",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    client.publishTweet(tweetContent, object : JsonHttpResponseHandler() {

                        override fun onSuccess(statusCode: Int, headers: Headers, json: JSON) {
                            Log.i(TAG, "Successfully published tweet!")

                            val tweet = Tweet.fromJson(json.jsonObject)

                            val intent = Intent()
                            intent.putExtra("tweet", tweet)
                            setResult(RESULT_OK, intent)
                            finish()
                        }

                        override fun onFailure(
                            statusCode: Int,
                            headers: Headers?,
                            response: String?,
                            throwable: Throwable?
                        ) {
                            Log.e(TAG, "Failed to publish tweet", throwable)
                        }


                    })
                }


        }
    }
        companion object {
            val TAG = "ComposeActivity"
        }
}