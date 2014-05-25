package com.example.stocksearchapp.autocomplete;

import org.codehaus.jackson.annotate.JsonProperty;

public class ResultSetContainer {

	@JsonProperty(value = "ResultSet")
	private ResultSet resultset;

	public ResultSet getResultset() {
		return resultset;
	}

	public void setResultset(ResultSet resultset) {
		this.resultset = resultset;
	}

}
