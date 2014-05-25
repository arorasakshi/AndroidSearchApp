package com.example.stocksearchapp;

import java.io.IOException;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.stocksearchapp.stocksearchresult.StockSearchResult;

public class MainActivity extends ActionBarActivity {
	private String servletUrl = "http://cs-server.usc.edu:27324/examples/servlet/HelloWorldExample/?symbol=";
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
	StockSearchResult stockSearchResult = null;
	StockSearchResultWrapper stockSearchResultWrapper = null;

	TextView textViewToChange0;
	TextView textViewToChange1;
	TextView textViewToChange2;
	TextView textViewToChange3;
	TextView textViewToChange4;
	TextView textViewToChange5;
	TextView textViewToChange6;

	TextView textViewToChange7;
	TextView textViewToChange8;
	TextView textViewToChange9;
	TextView textViewToChange10;
	TextView textViewToChange11;
	TextView textViewToChange12;
	TextView textViewToChange5a;
	TextView textViewToChange6a;
	TextView textViewToChange7a;
	TextView textViewToChange8a;
	TextView textViewToChange9a;
	TextView textViewToChange10a;
	TextView textViewToChange11a;
	TextView textViewToChange12a;
	TextView textViewToChange13;
	TextView textViewToChange13a;
	ImageView imageTochange;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_main);

		setContentView(R.layout.fragment_main);
		ArrayAdapter<String> adapter = new AutocompleteAdaptor(this,
				android.R.layout.simple_list_item_1);
		AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.autoComplete);
		textView.setAdapter(adapter);
		textView.setThreshold(1);

		textView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.autoComplete);
				String message = textView.getText().toString();
				String[] temp = message.split(",");
				textView.setText(temp[0]);
				performDisplay(temp[0]);
			}
		});

	}

	public void sendMessage(View view) throws IOException {
		AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.autoComplete);
		String message = textView.getText().toString();
		performDisplay(message);

	}

	private void fbFeed() {
	}

	private void performDisplay(String message) {
		AsyncHttpServletCall runner = new AsyncHttpServletCall();

		message = message.trim();
		String url = servletUrl + message;
		if (message.equals("") || message.trim().length() == 0) {
			alertbox("Error", "Please enter  symbol");
		} else {
			runner.execute(url);
		}

	}

	String image = "";

	public void sendNews(View view) {

		Intent intent = new Intent(this, DisplayMessageActivity.class);

		intent.putExtra(EXTRA_MESSAGE, stockSearchResultWrapper.getJson());
		startActivity(intent);
	}

	// alertbox http://www.androidsnippets.com/display-an-alert-box
	protected void alertbox(String title, String mymessage) {
		new AlertDialog.Builder(this)
				.setMessage(mymessage)
				.setTitle(title)
				.setCancelable(true)
				.setNeutralButton(android.R.string.ok,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
							}
						}).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

	private class AsyncHttpServletCall extends
			AsyncTask<String, Integer, StockSearchResult> {
		private String json;

		@Override
		protected void onPostExecute(StockSearchResult stockSearchResult) {

			initTextView();

			
			
			stockSearchResultWrapper = new StockSearchResultWrapper(json,
					stockSearchResult);
			
		
			
			if (stockSearchResult.getResult() == null || stockSearchResult.getResult().getName().equals(stockSearchResult.getResult().getSymbol())) {

				textViewToChange1.setText("");
				textViewToChange2.setText("");
				textViewToChange4.setText("");
				textViewToChange5.setText("");
				textViewToChange6.setText("");
				textViewToChange7.setText("");
				textViewToChange8.setText("");
				textViewToChange9.setText("");
				textViewToChange10.setText("");
				textViewToChange11.setText("");
				textViewToChange12.setText("");
				textViewToChange13.setText("");
				textViewToChange5a.setText("");
				textViewToChange6a.setText("");
				textViewToChange7a.setText("");
				textViewToChange8a.setText("");
				textViewToChange9a.setText("");
				textViewToChange10a.setText("");
				textViewToChange11a.setText("");
				textViewToChange12a.setText("");
				textViewToChange13a.setText("");

				WebView webView1 = (WebView) findViewById(R.id.img1);
				webView1.loadUrl("about:blank");

				ImageView imagebtns = (ImageView) findViewById(R.id.image);
				imagebtns.setVisibility(View.GONE);
				
				alertbox("No Stock", "Stock Not found");

			} else {

				textViewToChange1.setText(stockSearchResult.getResult()
						.getName()
						+ "( "
						+ stockSearchResult.getResult().getSymbol() + ")");
				textViewToChange2.setText(stockSearchResult.getResult()
						.getQuote().getLastTradePriceOnly());

				textViewToChange4.setText(stockSearchResult.getResult()
						.getQuote().getChange()
						+ "("
						+ stockSearchResult.getResult().getQuote()
								.getChangeInPercent() + ")");

				textViewToChange5a.setText("Prev Close");

				textViewToChange5.setText(stockSearchResult.getResult()
						.getQuote().getPreviousClose());
				textViewToChange6a.setText("Open");
				textViewToChange6.setText(stockSearchResult.getResult()
						.getQuote().getOpen());

				textViewToChange7a.setText("Bid");

				textViewToChange7.setText(stockSearchResult.getResult()
						.getQuote().getBid());
				textViewToChange8a.setText("Ask ");
				textViewToChange8.setText(stockSearchResult.getResult()
						.getQuote().getAsk());
				textViewToChange9a.setText("1st Year target ");
				textViewToChange9.setText(stockSearchResult.getResult()
						.getQuote().getOneYearTargetPrice());
				textViewToChange10a.setText("Day's Range");

				textViewToChange10.setText(stockSearchResult.getResult()
						.getQuote().getDaysLow()
						+ "-"
						+ stockSearchResult.getResult().getQuote()
								.getDaysHigh());
				textViewToChange11a.setText("52wk Range \t\t\t\t\t");
				textViewToChange11.setText(stockSearchResult.getResult()
						.getQuote().getYearLow()
						+ "-"
						+ stockSearchResult.getResult().getQuote()
								.getYearHigh());
				textViewToChange12a.setText("Volume");
				textViewToChange12.setText(stockSearchResult.getResult()
						.getQuote().getVolume());
				textViewToChange13a.setText("MarketCap ");
				textViewToChange13.setText(stockSearchResult.getResult()
						.getQuote().getMarketCapitalization());

				String stockUrl = stockSearchResult.getResult()
						.getStockChartImageURL();
				WebView webView = (WebView) findViewById(R.id.img1);
				webView.getSettings().setJavaScriptEnabled(true);
				webView.loadUrl(stockUrl);

				String sign = stockSearchResult.getResult().getQuote()
						.getChangeType();

				
				ImageView imagebtns = (ImageView) findViewById(R.id.image);
				imagebtns.setVisibility(0);
				
				if (sign.equals("+")) {
					textViewToChange4.setTextColor(Color.GREEN);
					textViewToChange4.setPadding(2,0,0,0);
					imageTochange.setImageResource(R.drawable.g);

				}
				if (sign.equals("-")) {
					textViewToChange4.setTextColor(Color.RED);
					textViewToChange4.setPadding(2,0,0,0);
					imageTochange.setImageResource(R.drawable.r);
					
				}
				if (sign.equals("")) {
					textViewToChange4.setTextColor(Color.GREEN);
					imageTochange.setVisibility(View.GONE);
					textViewToChange4.setPadding(70,0,0,0);
	
				}

				int length = stockSearchResult.getResult().getNews().getItem().length;

				System.out.println(length);
				if (length > 2) {
					Button btns = (Button) findViewById(R.id.btn);
					btns.setVisibility(0);
				}
				Button btn_fb = (Button) findViewById(R.id.btn_fb);
				btn_fb.setVisibility(0);

			}
		}

		@Override
		protected StockSearchResult doInBackground(String... params) {
			HandleJson obj = new HandleJson(params[0]);
			String json = obj.fetchJSON();

			stockSearchResult = HandleJson.readAndParseJSON(json);

			this.json = json;
			return stockSearchResult;

		}

		private void initTextView() {

			Button btn = (Button) findViewById(R.id.btn);
			btn.setVisibility(View.GONE);
			Button btn_fb = (Button) findViewById(R.id.btn_fb);
			btn_fb.setVisibility(View.GONE);
			textViewToChange0 = (TextView) findViewById(R.id.txt0);
			textViewToChange1 = (TextView) findViewById(R.id.txt1);
			textViewToChange2 = (TextView) findViewById(R.id.txt2);
			textViewToChange4 = (TextView) findViewById(R.id.txt4);
			textViewToChange5 = (TextView) findViewById(R.id.txt5);
			textViewToChange6 = (TextView) findViewById(R.id.txt6);
			textViewToChange7 = (TextView) findViewById(R.id.txt7);
			textViewToChange8 = (TextView) findViewById(R.id.txt8);
			textViewToChange9 = (TextView) findViewById(R.id.txt9);
			textViewToChange10 = (TextView) findViewById(R.id.txt10);
			textViewToChange11 = (TextView) findViewById(R.id.txt11);
			textViewToChange12 = (TextView) findViewById(R.id.txt12);
			textViewToChange13 = (TextView) findViewById(R.id.txt13);
			imageTochange = (ImageView) findViewById(R.id.image);

			textViewToChange5a = (TextView) findViewById(R.id.txt5a);
			textViewToChange6a = (TextView) findViewById(R.id.txt6a);
			textViewToChange7a = (TextView) findViewById(R.id.txt7a);
			textViewToChange8a = (TextView) findViewById(R.id.txt8a);
			textViewToChange9a = (TextView) findViewById(R.id.txt9a);
			textViewToChange10a = (TextView) findViewById(R.id.txt10a);
			textViewToChange11a = (TextView) findViewById(R.id.txt11a);
			textViewToChange12a = (TextView) findViewById(R.id.txt12a);
			textViewToChange13a = (TextView) findViewById(R.id.txt13a);
		}

	}

}
