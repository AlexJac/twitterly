package com.cooksys.twitterly.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.twitterly.daos.TweetDao;
import com.cooksys.twitterly.models.Tweet;
import com.cooksys.twitterly.models.User;

@RestController
@RequestMapping("/tweets")
public class TweetController
{
	@Autowired
	private TweetDao tweetDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Tweet> indexAllTweets() {
		return tweetDao.indexAllTweets();
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public HashMap<User, Tweet> indexAllTweetswithUser() {
		return tweetDao.indexAllTweetswithUser();
	}
	
	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public List<Tweet> indexUsersTweets(@PathVariable String username) {
		return tweetDao.indexUsersTweets(username);
	}
	
	@RequestMapping(value = "/{username}/following", method = RequestMethod.GET)
	public List<Tweet> indexFollowingTweets(@PathVariable String username) {
		return tweetDao.indexFollowingTweets(username);
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.POST)
	public Tweet createTweet(@PathVariable String username, @RequestBody Tweet tweet) {
		return tweetDao.createTweet(username, tweet);	
	}
}
