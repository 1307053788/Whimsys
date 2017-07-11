package com.whimsy.entity;

import java.util.Date;

public class Message {
    private Integer msgId;

	private User user;

	private Content content;

	private String msgLink;

	private Integer msgCollectionNumber;

	private Integer msgCommentNumber;

	private Integer msgForwardNumber;

	private Date msgTime;

	public Integer getMsgId() {
		return msgId;
	}

	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	public String getMsgLink() {
		return msgLink;
	}

	public void setMsgLink(String msgLink) {
		this.msgLink = msgLink == null ? null : msgLink.trim();
	}

	public Integer getMsgCollectionNumber() {
		return msgCollectionNumber;
	}

	public void setMsgCollectionNumber(Integer msgCollectionNumber) {
		this.msgCollectionNumber = msgCollectionNumber;
	}

	public Integer getMsgCommentNumber() {
		return msgCommentNumber;
	}

	public void setMsgCommentNumber(Integer msgCommentNumber) {
		this.msgCommentNumber = msgCommentNumber;
	}

	public Integer getMsgForwardNumber() {
		return msgForwardNumber;
	}

	public void setMsgForwardNumber(Integer msgForwardNumber) {
		this.msgForwardNumber = msgForwardNumber;
	}

	public Date getMsgTime() {
		return msgTime;
	}

	public void setMsgTime(Date msgTime) {
		this.msgTime = msgTime;
	}
}