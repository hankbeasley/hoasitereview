package com.sitereview.server.dao;

import java.util.ArrayList;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Provider {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	@Persistent
	private String name;
	@Persistent
	private String consensus;
	@Persistent
	private String pros;
	@Persistent
	private String cons;
	@Persistent
	private String price;
	//@Persistent
	//private final ArrayList<Key> features = new ArrayList<Key>();
	
	@Persistent(defaultFetchGroup = "true")
	private ArrayList<UserComment> userComments = new ArrayList<UserComment>();
	
	@Persistent
	private String url;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getConsensus() {
		return consensus;
	}
	public void setConsensus(String consensus) {
		this.consensus = consensus;
	}
	public String getPros() {
		return pros;
	}
	public void setPros(String pros) {
		this.pros = pros;
	}
	public String getCons() {
		return cons;
	}
	public void setCons(String cons) {
		this.cons = cons;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Key getKey() {
		return key;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUrl() {
		return url;
	}
	public ArrayList<UserComment> getUserComments() {
		return userComments;
	}
	
	
	
}
