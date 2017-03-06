package com.cooksys.twitterly.daos;

import java.util.HashMap;
import java.util.List;

import com.cooksys.twitterly.models.Tweet;
import com.cooksys.twitterly.models.User;

public interface TweetDao
{
	List<Tweet> indexAllTweets();
	List<Tweet> indexUsersTweets(String username);
	List<Tweet> indexFollowingTweets(String username);
	Tweet createTweet(String username, Tweet tweet);
	HashMap<User, Tweet> indexAllTweetswithUser();
}
