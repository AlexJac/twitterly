package com.cooksys.twitterly.models;

// Generated Apr 28, 2016 5:43:41 PM by Hibernate Tools 4.3.1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Tweet generated by hbm2java
 */
@Entity
@Table(name = "tweet", catalog = "mydb")
public class Tweet implements java.io.Serializable
{

	private Integer tweetId;
	private String text;
	private Date tweetTime;
	@JsonIgnore
	private Set<User> users = new HashSet<User>(0);

	public Tweet()
	{
	}

	public Tweet(String text, Date tweetTime)
	{
		this.text = text;
		this.tweetTime = tweetTime;
	}

	public Tweet(String text, Date tweetTime, Set<User> users)
	{
		this.text = text;
		this.tweetTime = tweetTime;
		this.users = users;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "tweet_id", unique = true, nullable = false)
	public Integer getTweetId()
	{
		return this.tweetId;
	}

	public void setTweetId(Integer tweetId)
	{
		this.tweetId = tweetId;
	}

	@Column(name = "text", nullable = false, length = 65535)
	public String getText()
	{
		return this.text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "tweet_time", nullable = false, length = 19)
	public Date getTweetTime()
	{
		return this.tweetTime;
	}

	public void setTweetTime(Date tweetTime)
	{
		this.tweetTime = tweetTime;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_tweet", catalog = "mydb", joinColumns = { @JoinColumn(name = "tweet_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "user_id", nullable = false, updatable = false) })
	public Set<User> getUsers()
	{
		return this.users;
	}

	public void setUsers(Set<User> users)
	{
		this.users = users;
	}

}