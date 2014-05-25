package com.example.stocksearchapp.stocksearchresult;

import org.codehaus.jackson.annotate.JsonProperty;

public class Quote {
	
	@JsonProperty(value= "ChangeType")
	private String changeType;
	
	@JsonProperty(value= "Change")
	private String Change;
	
	@JsonProperty(value= "ChangeInPercent")
	private String ChangeInPercent;
	
	@JsonProperty(value= "LastTradePriceOnly")
	private String LastTradePriceOnly;
	
	@JsonProperty(value= "PreviousClose")
	private String PreviousClose;
	
	@JsonProperty(value= "DaysLow")
	private String DaysLow;
	
	@JsonProperty(value= "DaysHigh")
	private String DaysHigh;
	
	@JsonProperty(value= "Open")
	private String Open;
	
	@JsonProperty(value= "YearLow")
	private String YearLow;
	
	@JsonProperty(value= "YearHigh")
	private String YearHigh;
	
	@JsonProperty(value= "Bid")
	private String Bid;
	
	@JsonProperty(value= "Volume")
	private String Volume;
	
	@JsonProperty(value= "Ask")
	private String Ask;
	
	@JsonProperty(value= "OneYearTargetPrice")
	private String OneYearTargetPrice;
	
	@JsonProperty(value= "AverageDailyVolume")
	private String AverageDailyVolume;
	
	@JsonProperty(value= "MarketCapitalization")
	private String MarketCapitalization;

	public String getChangeType() {
		return changeType;
	}

	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}

	public String getChange() {
		return Change;
	}

	public void setChange(String change) {
		Change = change;
	}

	public String getChangeInPercent() {
		return ChangeInPercent;
	}

	public void setChangeInPercent(String changeInPercent) {
		ChangeInPercent = changeInPercent;
	}

	public String getLastTradePriceOnly() {
		return LastTradePriceOnly;
	}

	public void setLastTradePriceOnly(String lastTradePriceOnly) {
		LastTradePriceOnly = lastTradePriceOnly;
	}

	public String getPreviousClose() {
		return PreviousClose;
	}

	public void setPreviousClose(String previousClose) {
		PreviousClose = previousClose;
	}

	public String getDaysLow() {
		return DaysLow;
	}

	public void setDaysLow(String daysLow) {
		DaysLow = daysLow;
	}

	public String getDaysHigh() {
		return DaysHigh;
	}

	public void setDaysHigh(String daysHigh) {
		DaysHigh = daysHigh;
	}

	public String getOpen() {
		return Open;
	}

	public void setOpen(String open) {
		Open = open;
	}

	public String getYearLow() {
		return YearLow;
	}

	public void setYearLow(String yearLow) {
		YearLow = yearLow;
	}

	public String getYearHigh() {
		return YearHigh;
	}

	public void setYearHigh(String yearHigh) {
		YearHigh = yearHigh;
	}

	public String getBid() {
		return Bid;
	}

	public void setBid(String bid) {
		Bid = bid;
	}

	public String getVolume() {
		return Volume;
	}

	public void setVolume(String volume) {
		Volume = volume;
	}

	public String getAsk() {
		return Ask;
	}

	public void setAsk(String ask) {
		Ask = ask;
	}

	public String getOneYearTargetPrice() {
		return OneYearTargetPrice;
	}

	public void setOneYearTargetPrice(String oneYearTargetPrice) {
		OneYearTargetPrice = oneYearTargetPrice;
	}

	public String getAverageDailyVolume() {
		return AverageDailyVolume;
	}

	public void setAverageDailyVolume(String averageDailyVolume) {
		AverageDailyVolume = averageDailyVolume;
	}

	public String getMarketCapitalization() {
		return MarketCapitalization;
	}

	public void setMarketCapitalization(String marketCapitalization) {
		MarketCapitalization = marketCapitalization;
	}

}
