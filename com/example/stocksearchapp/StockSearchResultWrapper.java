package com.example.stocksearchapp;

import com.example.stocksearchapp.stocksearchresult.StockSearchResult;

public class StockSearchResultWrapper {

	private String json;
	private StockSearchResult stockSearchResult;

	public StockSearchResultWrapper(String json,
			StockSearchResult stockSearchResult) {
		super();
		this.json = json;
		this.stockSearchResult = stockSearchResult;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public StockSearchResult getStockSearchResult() {
		return stockSearchResult;
	}

	public void setStockSearchResult(StockSearchResult stockSearchResult) {
		this.stockSearchResult = stockSearchResult;
	}

}
