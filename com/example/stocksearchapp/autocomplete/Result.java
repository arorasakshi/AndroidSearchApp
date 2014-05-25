package com.example.stocksearchapp.autocomplete;

import org.codehaus.jackson.annotate.JsonProperty;

public class Result {

	@JsonProperty(value = "symbol")
	private String symbol;

	@JsonProperty(value = "name")
	private String name;

	@JsonProperty(value = "exch")
	private String exch;

	@JsonProperty(value = "type")
	private String type;

	@JsonProperty(value = "exchDisp")
	private String exchDisp;

	@JsonProperty(value = "typeDisp")
	private String typeDisp;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getexch() {
		return exch;
	}

	public void setexch(String exch) {
		this.exch = exch;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getExchDisp() {
		return exchDisp;
	}

	public void setExchDisp(String exchDisp) {
		this.exchDisp = exchDisp;
	}

	public String getTypeDisp() {
		return typeDisp;
	}

	public void setTypeDisp(String typeDisp) {
		this.typeDisp = typeDisp;
	}

}
