package com.example.stocksearchapp.stocksearchresult;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

@XmlRootElement(name = "result")
public class Result {

	@JsonProperty(value= "Name")
	private String name;
	
	@JsonProperty(value= "symbol")
	private String symbol;
	
	@JsonProperty(value= "Quote")
	private Quote quote;
	
	@JsonProperty(value= "News")
	private News news;
	
	@JsonProperty(value= "StockChartImageURL")
	private String StockChartImageURL;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Quote getQuote() {
		return quote;
	}

	public void setQuote(Quote quote) {
		this.quote = quote;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public String getStockChartImageURL() {
		return StockChartImageURL;
	}

	public void setStockChartImageURL(String stockChartImageURL) {
		StockChartImageURL = stockChartImageURL;
	}

	
}
