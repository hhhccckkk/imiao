package com.hck.imiao.bean;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class BackMessageBean {
	/**
	 * requestParam={ "UserPhone":"手机号", "UserKey":1342,
	 * "MessageKey":"视频播放 Token ",// 消息 ID "UserMessage":"手机 App 语音推送 Token",
	 * "UniqueID":"加密后的通讯凭据", "RandomKey":"客户端的随机加密字符串", 13 / 15
	 * "SendMessageTime": "2016-05-10 09:22:19" }
	 */
	@JsonProperty("UserPhone")
	private String phoneNumber;
	@JsonProperty("UserKey")
	private int userKey;
	@JsonProperty("MessageKey")
	private String messageKey;
	@JsonProperty("UserMessage")
	private String userMessage;
	@JsonProperty("UniqueID")
	private String uniqueID;
	@JsonProperty("RandomKey")
	private String randomKey;
	@JsonProperty("SendMessageTime")
	private String sendMessageTime;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	

	public int getUserKey() {
		return userKey;
	}

	public void setUserKey(int userKey) {
		this.userKey = userKey;
	}

	public String getMessageKey() {
		return messageKey;
	}

	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

	public String getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}

	public String getRandomKey() {
		return randomKey;
	}

	public void setRandomKey(String randomKey) {
		this.randomKey = randomKey;
	}

	public String getSendMessageTime() {
		return sendMessageTime;
	}

	public void setSendMessageTime(String sendMessageTime) {
		this.sendMessageTime = sendMessageTime;
	}

}
