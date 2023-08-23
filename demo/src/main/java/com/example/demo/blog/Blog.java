package com.example.demo.blog;

import java.time.LocalDateTime;

public class Blog {
	private int bid;
	private String penName;
	private String title;
	private String content;
	private LocalDateTime modTime;
	private int viewcount;
	private int isDeleted;
	
	public Blog() {	}
	// Insert하는 경우 사용되는 생성자
	public Blog(String penName, String title, String content) {
		super();
		this.penName = penName;
		this.title = title;
		this.content = content;
	}
	// Update하는 경우 사용되는 생성자
	public Blog(int bid, String penName, String title, String content) {
		super();
		this.bid = bid;
		this.penName = penName;
		this.title = title;
		this.content = content;
	}
	
	public Blog(int bid, String penName, String title, String content, LocalDateTime modTime, int viewcount,
			int isDeleted) {
		this.bid = bid;
		this.penName = penName;
		this.title = title;
		this.content = content;
		this.modTime = modTime;
		this.viewcount = viewcount;
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "Blog [bid=" + bid + ", penName=" + penName + ", title=" + title + ", content=" + content + ", modTime="
				+ modTime.toString().substring(2, 16).replace("T"," ") + ", viewcount=" + viewcount + "]";
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getPenName() {
		return penName;
	}

	public void setPenName(String penName) {
		this.penName = penName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getModTime() {
		return modTime;
	}

	public void setModTime(LocalDateTime modTime) {
		this.modTime = modTime;
	}

	public int getViewcount() {
		return viewcount;
	}

	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	
}
