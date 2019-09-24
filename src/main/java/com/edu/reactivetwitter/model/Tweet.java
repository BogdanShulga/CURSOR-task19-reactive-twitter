package com.edu.reactivetwitter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import twitter4j.Status;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Tweet {
	private String username;
	private String text;

	/**
	 * Method to convert the more complex <code>Status</code> object from Twitter4J to a simplified <code>Tweet</code>
	 */
	public static Tweet fromStatus(Status status) {
		return new Tweet(status.getUser().getName(), status.getText());
	}
}