package com.codepath.android.booksearch.net;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class BookClient {
    private static final String API_BASE_URL = "http://api.svsu.edu/";
    private AsyncHttpClient client;

    public BookClient() {
        this.client = new AsyncHttpClient();
    }

    private String getApiUrl(String relativeUrl) {
        return API_BASE_URL + relativeUrl;
    }

    // Method for accessing the search API
    public void getBooks(final String query, JsonHttpResponseHandler handler) {
        try {
            String url = getApiUrl("courses?courseNumber=");
            client.get(url + URLEncoder.encode(query, "utf-8"), handler);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

 /*   // Method for accessing books API to get publisher and no. of pages in a book.
    public void getExtraBookDetails(String openLibraryId, JsonHttpResponseHandler handler) {
        String url = getApiUrl("courses/");
        client.get(url + openLibraryId + ".json", handler);
    }*/
}
