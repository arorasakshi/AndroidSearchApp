package com.example.stocksearchapp;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.json.JSONObject;

import android.annotation.SuppressLint;

import com.example.stocksearchapp.autocomplete.ResultSetContainer;
import com.example.stocksearchapp.stocksearchresult.StockSearchResult;

public class HandleJson {
	private String Name = "";
	private String symbol = "";
	String Quote = "";
	String News = "";
	String ChangeType = "";
	String Change = "";
	String ChangeInPercent = "";
	String LastTradePriceOnly = "";
	String PreviousClose = "";
	String DaysLow = "";
	String DaysHigh = "";
	String Open = "";
	String YearLow = "";
	String YearHigh = "";
	String Bid = "";
	String Volume = "";
	String Ask = "";
	String AverageDailyVolume = "";
	String OneYearTargetPrice = "";
	String MarketCapitalization = "";
	String Title = "";
	String Link = "";
	String StockChartImageURL = "";

	private String urlString = null;

	public volatile boolean parsingComplete = true;

	public HandleJson(String url) {
		this.urlString = url;
	}

	public String getSymbol() {
		return symbol;
	}

	public String getName() {
		return Name;
	}

	public String getChangeType() {
		return ChangeType;
	}

	public String getChange() {
		return Change;
	}

	public String getChangeInPercent() {
		return ChangeInPercent;
	}

	public String getLastTradePriceOnly() {
		return LastTradePriceOnly;
	}

	public String getPreviousClose() {
		return PreviousClose;
	}

	public String getDaysLow() {
		return DaysLow;
	}

	public String getDaysHigh() {
		return DaysHigh;
	}

	public String getOpen() {
		return Open;
	}

	public String getYearLow() {
		return YearLow;
	}

	public String getYearHigh() {
		return YearHigh;
	}

	public String getBid() {
		return Bid;
	}

	public String getVolume() {
		return Volume;
	}

	public String getAsk() {
		return Ask;
	}

	public String getAverageDailyVolume() {
		return AverageDailyVolume;
	}

	public String getOneYearTargetPrice() {
		return OneYearTargetPrice;
	}

	public String getMarketCapitalization() {
		return MarketCapitalization;
	}

	public String getStockChartImageURL() {
		return StockChartImageURL;
	}

	@SuppressLint("NewApi")
	public static StockSearchResult readAndParseJSON(String in) {
		StockSearchResult stockSearchResult = null;

		try {
			JSONObject reader = new JSONObject(in);

			try {
				// Contains the above string

				ObjectMapper mapper = new ObjectMapper();
				stockSearchResult = mapper.readValue(reader.toString(),
						new TypeReference<StockSearchResult>() {
						});

				System.out.println(stockSearchResult.getResult().getName());

			} catch (Throwable throwable) {
				System.out.println(throwable.getMessage());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return stockSearchResult;

	}
	
	
	
	public static ResultSetContainer readAndParseJSONP(String in) {
		ResultSetContainer resultSetContainer = null;

		try {
			
			String json = in.substring(in.indexOf("(") + 1, in.lastIndexOf(")"));

			JSONObject reader = new JSONObject(json);

			try {
				// Contains the above string

				ObjectMapper mapper = new ObjectMapper();
				resultSetContainer = mapper.readValue(reader.toString(),
						new TypeReference<ResultSetContainer>() {
						});


			} catch (Throwable throwable) {
				System.out.println(throwable.getMessage());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultSetContainer;

	}
	
	
	

	public String fetchJSON() {
		URL url;
		HttpURLConnection urlConnection = null;
		InputStream in;
		String data = "";
		try {
			url = new URL(urlString);
			urlConnection = (HttpURLConnection) url.openConnection();
			in = new BufferedInputStream(urlConnection.getInputStream());
			data = convertStreamToString(in);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			urlConnection.disconnect();
		}

		return data;
	}

	static String convertStreamToString(java.io.InputStream is) {
		java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\n");
		return s.hasNext() ? s.next() : "";
	}
}
