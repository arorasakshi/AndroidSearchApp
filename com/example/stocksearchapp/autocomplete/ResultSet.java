package com.example.stocksearchapp.autocomplete;

import org.codehaus.jackson.annotate.JsonProperty;


public class ResultSet {
	
	@JsonProperty(value= "Query")
	private String Query;
	
	@JsonProperty(value= "Result")
	private Result[] result;
	
	public String getQuery() {
		return Query;
	}
	public void setQuery(String query) {
		Query = query;
	}
	public Result[] getResult() {
		return result;
	}
	public void setResult(Result[] result) {
		this.result = result;
	}
	
	
}
