package com.cooksys.twitterly.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.twitterly.daos.UserDao;
import com.cooksys.twitterly.models.Tweet;
import com.cooksys.twitterly.models.User;

@RestController
@RequestMapping("/users")
public class UserController
{
	@Autowired
	private UserDao userDao;

	@RequestMapping(method = RequestMethod.POST)
	public User create(@RequestBody User user) {
		return userDao.create(user);
	}
	
	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
		public User get(@PathVariable String username) {
			return userDao.get(username);
	}
	
	@RequestMapping(value = "/{username}/followers", method = RequestMethod.GET)
	public List<User> indexFollowers(@PathVariable String username) {
		return userDao.indexFollowers(username);
	}
	
	@RequestMapping(value = "/{username}/following", method = RequestMethod.GET)
	public List<User> indexFollowing(@PathVariable String username) {
		return userDao.indexFollowing(username);
	}
	
	@RequestMapping(value = "/{username}/following", method = RequestMethod.PATCH)
		public List<User> startFollowing(@PathVariable String username, @RequestBody User user) {
			return userDao.startFollowing(username, user);
	}
	
	@RequestMapping(value = "/{username}/following", method = RequestMethod.DELETE)
		public List<User> stopFollowing(@PathVariable String username, @RequestBody User user) {
			return userDao.stopFollowing(username, user);
	}


}