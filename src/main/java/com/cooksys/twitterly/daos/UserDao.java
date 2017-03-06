package com.cooksys.twitterly.daos;

import java.util.List;

import com.cooksys.twitterly.models.Tweet;
import com.cooksys.twitterly.models.User;

public interface UserDao
{
	User create(User user);
	User get(String username);
	List<User> indexFollowers(String username);
	List<User> indexFollowing(String username);
	List<User> startFollowing(String username, User user);
	List<User> stopFollowing(String username, User user);
}
