package com.cooksys.twitterly.daoimpls;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cooksys.twitterly.daos.UserDao;
import com.cooksys.twitterly.models.Tweet;
import com.cooksys.twitterly.models.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public User create(User user)
	{
		Session session = sessionFactory.getCurrentSession();
		Serializable id = session.save(user);
		return (User) session.get(User.class, id);
	}

	@Override
	public User get(String username)
	{
		Session session = sessionFactory.getCurrentSession();
		return (User) session
				.createQuery("from User u where u.username = :username")
				.setString("username", username)
				.uniqueResult();
	}

	@Override
	public List<User> indexFollowers(String username)
	{
		Session session = sessionFactory.getCurrentSession();
		return session
			.createQuery("select u.followers from User as u where u.username = :username")
			.setString("username", username)
			.list();
		//return new ArrayList<User>(this.get(username).getFollowers());
	}

	@Override
	public List<User> indexFollowing(String username)
	{
		Session session = sessionFactory.getCurrentSession();
		return session
			.createQuery("select u.following from User as u where u.username = :username")
			.setString("username", username)
			.list();
		//return new ArrayList<User>(this.get(username).getFollowing());
		}

	@Override
	public List<User> startFollowing(String username, User user)
	{
		Session session = sessionFactory.getCurrentSession();
		User u = this.get(username);
		u.getFollowing().add(this.get(user.getUsername()));
		session.saveOrUpdate(u);
		//session.persist(u);
		return new ArrayList<User>(u.getFollowing());
				
	}

	@Override
	public List<User> stopFollowing(String username, User user)
	{
		Session session = sessionFactory.getCurrentSession();
		User u = this.get(username);
		u.getFollowing().remove(this.get(user.getUsername()));
		session.saveOrUpdate(u);
		//session.persist(u);
		return new ArrayList<User>(u.getFollowing());
	}
}
