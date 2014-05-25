package com.example.stocksearchapp.stocksearchresult;

import org.codehaus.jackson.annotate.JsonProperty;


public class News {

	@JsonProperty(value= "Item")
	private Item[] item;

	public Item[] getItem() {
		return item;
	}

	public void setItem(Item[] item) {
		this.item = item;
	}

}
