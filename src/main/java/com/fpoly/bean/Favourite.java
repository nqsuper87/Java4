package com.fpoly.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(
	name="Favorites", uniqueConstraints = {
		@UniqueConstraint (columnNames = {"VideoId","UserId"})
	}
)
public class Favourite {
	@Id 
	Integer id;
	
	@ManyToOne @JoinColumn (name = "UserId")
	User user;
	
	@ManyToOne @JoinColumn (name = "VideoId")
	Video video;
	
	@Temporal (TemporalType.TIME)
	Date likeDate = new Date();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public Date getLikeDate() {
		return likeDate;
	}

	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}
}
