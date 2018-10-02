/**
 * 
 */
package com.assign.coauthor.rest;

/**
 * Class to hold information about each author and the total number of CoAuthored  books 
 * @author poonam
 *
 */
public class CoAuthorScore {
	String authorName;
	Integer score;
	public CoAuthorScore(String authorName, Integer score) {
		super();
		this.authorName = authorName;
		this.score = score;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public CoAuthorScore() {
		super();
		// Needed for reflection API on REST API client side.
	}
	
}
