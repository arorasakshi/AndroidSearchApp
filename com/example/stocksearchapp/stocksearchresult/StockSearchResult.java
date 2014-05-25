package com.example.stocksearchapp.stocksearchresult;

import org.codehaus.jackson.annotate.JsonProperty;


public class StockSearchResult {


	@JsonProperty("result")
	private Result result;

	@JsonProperty("Error")
	private String error;
	
	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}


}
