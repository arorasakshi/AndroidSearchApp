package com.example.stocksearchapp;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import com.example.stocksearchapp.autocomplete.Result;
import com.example.stocksearchapp.autocomplete.ResultSetContainer;

public class AutocompleteAdaptor extends ArrayAdapter<String> implements Filterable {
    private ArrayList<String> resultList;

    public AutocompleteAdaptor(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    @Override
    public int getCount() {
        return resultList.size();
    }

    @Override
    public String getItem(int index) {
        return resultList.get(index);
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if (constraint != null) {
                    // Retrieve the autocomplete results.
                    try {
						resultList = autocomplete(constraint.toString());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ExecutionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

                    // Assign the data to the FilterResults
                    filterResults.values = resultList;
                    filterResults.count = resultList.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (results != null && results.count > 0) {
                    notifyDataSetChanged();
                }
                else {
                    notifyDataSetInvalidated();
                }
            }};
        return filter;
    }

    

	
	private ArrayList<String> autocomplete(String input) throws InterruptedException, ExecutionException {
	    ArrayList<String> resultList = new ArrayList<String>();
	    AsyncHttpJSONPServletCall asyncHttpJSONPServletCall = new AsyncHttpJSONPServletCall();
	    
	    
	    
	    String url = "http://autoc.finance.yahoo.com/autoc?query="+input+"&callback=YAHOO.Finance.SymbolSuggest.ssCallback";
	    ResultSetContainer resultSetContainer =asyncHttpJSONPServletCall.execute(url).get();
	    for(Result result : resultSetContainer.getResultset().getResult()){
	    	resultList.add(result.getSymbol()+", "+ result.getName()+"("+result.getexch()+")");
	    	System.out.println(result.getSymbol());
	    }
	   
	

	    

	    return resultList;
	}
	
	
	
	private class AsyncHttpJSONPServletCall extends
	AsyncTask<String, Integer, ResultSetContainer> {
private String json;
ResultSetContainer resultSetContainer = new ResultSetContainer();

@Override
protected void onPostExecute(ResultSetContainer resultSetContainer) {
	
	
}

@Override
protected ResultSetContainer doInBackground(String... params) {
	HandleJson obj = new HandleJson(params[0]);
	String json = obj.fetchJSON();
	resultSetContainer = HandleJson.readAndParseJSONP(json);
	return resultSetContainer;

}

}

	
}
