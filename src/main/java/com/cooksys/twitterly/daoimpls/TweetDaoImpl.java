package com.cooksys.twitterly.daoimpls;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cooksys.twitterly.daos.TweetDao;
import com.cooksys.twitterly.models.Tweet;
import com.cooksys.twitterly.models.User;

@Repository
@Transactional
public class TweetDaoImpl implements TweetDao
{
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Tweet> indexAllTweets()
	{
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("select t from Tweet as t order by t.tweetId DESC").list();
	}

	@Override
	public List<Tweet> indexUsersTweets(String username)
	{
		Session session = sessionFactory.getCurrentSession();
		return session
				.createQuery("select t from Tweet as t inner join t.users as tu where tu.username = :username order by t.tweetId DESC")
				.setString("username", username)
				.list();
	}

	@Override
	public List<Tweet> indexFollowingTweets(String username)
	{
		Session session = sessionFactory.getCurrentSession();
		ArrayList<Tweet> allFollowingTweets = new ArrayList<Tweet>();
		ArrayList<User> followingTweets= new ArrayList<User>(((User)session.createQuery("from User as u where u.username = :username").setString("username", username).uniqueResult()).getFollowing());
		for (User user : followingTweets) {
			ArrayList<Tweet> tweets = new ArrayList<Tweet>(user.getTweets());
			for (Tweet tweet : tweets) {
				allFollowingTweets.add(tweet);
			}
		}
	    Collections.sort(allFollowingTweets, new Comparator<Tweet>() {
	        public int compare(Tweet t1, Tweet t2) {
	            return t2.getTweetId() - t1.getTweetId(); // Descending
	        }});
	    return allFollowingTweets;
	}

	@Override
	public Tweet createTweet(String username, Tweet tweet)
	{
		Session session = sessionFactory.getCurrentSession();
		tweet.getUsers().add(((User)session.createQuery("from User as u where u.username = :username").setString("username", username).uniqueResult()));
		Serializable id = session.save(tweet);
		return (Tweet)session.get(Tweet.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public HashMap<User, Tweet> indexAllTweetswithUser()
	{
		Session session = sessionFactory.getCurrentSession();
		HashMap<User, Tweet> tweetsWithUser = new HashMap<User, Tweet>();
		ArrayList<Tweet> tweets= new ArrayList<Tweet>(session.createQuery("select t from Tweet as t order by t.tweetId DESC").list());
		for(Tweet t : tweets) {
			int i = t.getTweetId();
			tweetsWithUser.put(((User)session.createQuery("select u from User as u where u.tweet.tweetId = :id").setInteger("id", i).uniqueResult()), t);
			}
		return tweetsWithUser;
	}
}

