package com.example.stocksearchapp.stocksearchresult;

import org.codehaus.jackson.annotate.JsonProperty;

public class Item {

	@JsonProperty(value= "Link")
	private String link;
	
	@JsonProperty(value= "Title")
	private String title;

	@JsonProperty(value= "Error")
	private String Error;
	
	public String getLink() {
		return link;
	}
	
	
	//"ERR_EMPTY_NEWS_FEED"

	public void setLink(String link) {
		this.link = link;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getError() {
		return Error;
	}


	public void setError(String error) {
		Error = error;
	}

}
