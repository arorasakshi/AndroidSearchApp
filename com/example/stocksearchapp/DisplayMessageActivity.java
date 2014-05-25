package com.example.stocksearchapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stocksearchapp.stocksearchresult.StockSearchResult;

public class DisplayMessageActivity extends ActionBarActivity {
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		int counter = 0;
		super.onCreate(savedInstanceState);

		// Get the message from the intent
		Intent intent = getIntent();
		String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
		StockSearchResult stockSearchResult = HandleJson
				.readAndParseJSON(message);
		// Create the text view
		int length = stockSearchResult.getResult().getNews().getItem().length;

		ScrollView sv = new ScrollView(this);
		LinearLayout ll = new LinearLayout(this);
		ll.setOrientation(LinearLayout.VERTICAL);
		sv.addView(ll);
		
		

		for (counter = 0; counter < length; counter++) {
			TextView textView = new TextView(this);
			textView.setTextSize(15);

			String data = stockSearchResult.getResult().getNews().getItem()[counter]
					.getTitle();
			final String Url = stockSearchResult.getResult().getNews().getItem()[counter].getLink();

			String textStart = "<a href='";
			String close = "'>";
			String textEnd = " </a>";
			String text = textStart + Url + close + data + textEnd;
			textView.setText(Html.fromHtml(text));

			ll.addView(textView);
			textView.setClickable(true);

			textView.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
							DisplayMessageActivity.this);
					alertDialogBuilder.setTitle("News decision");
					alertDialogBuilder.setMessage("News");
					alertDialogBuilder.setPositiveButton("View",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									
									Intent intent = new Intent(Intent.ACTION_VIEW, 
										     Uri.parse(Url));
										startActivity(intent);

								}
							});
					alertDialogBuilder.setNegativeButton("Cancel",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {

								}
							});

					AlertDialog alertDialog = alertDialogBuilder.create();

					alertDialog.show();

				}
			});
		}
		String messageToToast = "Showing"+length+"Headlines";
		creatToast(messageToToast);
		setContentView(sv);
		
	}

	private void creatToast(String length){
		Context context = getApplicationContext();
		CharSequence text = length;
		int duration = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_message, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_display_message,
					container, false);
			return rootView;
		}
	}

}
