# Tweeter 

Tweeter is a native Android mobile app that allows a user to view their Twitter timeline and post a new tweet. The app utilizes [Twitter REST API](https://dev.twitter.com/rest/public).


## User Stories

The following functionality is completed:

- [x] User can **compose and post a new tweet**
  - [x] User can click a “Compose” icon in the Action Bar on the top right
  - [x] User can then enter a new tweet and post this to twitter
  - [x] User is taken back to home timeline with **new tweet visible** in timeline
  - [x] Newly created tweet should be manually inserted into the timeline and not rely on a full refresh
  - [x] User can **see a counter with total number of characters left for tweet** on compose tweet page

The following additional features are implemented:

- [x] User is using **"Twitter branded" colors and styles**
- [x] Use Parcelable instead of Serializable using the popular [Parceler library](http://guides.codepath.org/android/Using-Parceler).

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='https://i.imgur.com/qJyfqca.gif' title='Part 2 Video Walkthrough' width='' alt='Video Walkthrough' />


## Notes

I had trouble trying to implement a character counter in the compose activity which shows how many characters you have left to compose a tweet. I was able to solve this by using the "OnTextChanged" method to set the character counter and match the length of my tweets. 

## Open-source libraries used

- [Android Async HTTP](https://github.com/codepath/CPAsyncHttpClient) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Android

## License

    Copyright [2022] [Darius Garcia]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

# Tweeter [part 1]

Tweeter is an android app that allows a user to view their Twitter timeline. The app utilizes [Twitter REST API](https://dev.twitter.com/rest/public).

## User Stories

The following **required** functionality is completed:

- [x] User can **sign in to Twitter** using OAuth login
- [x]	User can **view tweets from their home timeline**
  - [x] User is displayed the username, name, and body for each tweet
  - [x] User is displayed the [relative timestamp](https://gist.github.com/nesquena/f786232f5ef72f6e10a7) for each tweet "8m", "7h"
- [x] User can refresh tweets timeline by pulling down to refresh

The following **optional** features are implemented:

- [x] Improve the user interface and theme the app to feel "twitter branded"

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='https://i.imgur.com/zxFx8WA.gif' title='Part 1 Video Walkthrough' width='' alt='Video Walkthrough' />


## Notes

I faced an issue where my emulator was not being granted access to the Twitter REST API so tweets were not able to display on my recyclerView. I was able to fix this by using the provided CodePath API consumer and consumer secret keys instead of using my own API keys. 

## Open-source libraries used

- [Android Async HTTP](https://github.com/codepath/CPAsyncHttpClient) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Android

## License

    Copyright [2022] [Darius Ry Garcia]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
