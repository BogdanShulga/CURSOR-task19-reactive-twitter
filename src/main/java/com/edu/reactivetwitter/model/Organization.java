package com.edu.reactivetwitter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Model class
 */
@Document
@Data
@NoArgsConstructor
public class Organization {
	@Id
	private String name;
	private List<String> technologies;

	/**
	 * Method to prepend hashtags to all technologies within the organization. Method uses <code>@JsonIgnore</code> to
	 * prevent MongoDB from saving this as a field, and Spring WebFlux to prevent it from appearing in the
	 * <code>/api/organization</code> REST API.
	 */
	@JsonIgnore
	public List<String> getHashtags() {
		return getTechnologies().stream().map(this::getHashtag).collect(Collectors.toList());
	}

	/**
	 * Method to prepend a hashtag to a given technology
	 */
	private String getHashtag(String technology) {
		return "#" + technology;
	}
}
