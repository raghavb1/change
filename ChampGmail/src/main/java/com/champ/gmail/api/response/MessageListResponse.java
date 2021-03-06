package com.champ.gmail.api.response;

import java.util.List;

public class MessageListResponse {
	
	private List<Message> messages;
	private String nextPageToken;


	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
	public class Message{
		private String id;
		private String threadId;
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getThreadId() {
			return threadId;
		}
		public void setThreadId(String threadId) {
			this.threadId = threadId;
		}
		@Override
		public String toString() {
			return "Message [id=" + id + ", threadId=" + threadId + "]";
		}
		
		
	}

	public String getNextPageToken() {
		return nextPageToken;
	}

	public void setNextPageToken(String nextPageToken) {
		this.nextPageToken = nextPageToken;
	}

	@Override
	public String toString() {
		return "MessageListResponse [messages=" + messages + ", nextPageToken=" + nextPageToken + "]";
	}
	
	
	
	
	
}
