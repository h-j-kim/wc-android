package com.wheaton.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BonAppMenu extends TrackedFragment {
	public BonAppMenu() {
		
	}
	
	@SuppressLint("SetJavaScriptEnabled")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		
		Activity act = getActivity();

		WebView webView = new WebView(getActivity());
		webView.setWebViewClient(new MyWebViewClient());
		webView.getSettings().setJavaScriptEnabled(true);

		act.setProgressBarIndeterminate(true);
		act.setProgressBarIndeterminateVisibility(true);

		webView.loadUrl(MainScreen.MENU_URL);
		
		return webView;
	}

	private class MyWebViewClient extends WebViewClient {
	    @Override
	    public boolean shouldOverrideUrlLoading(WebView view, String url)
	    {
	        view.loadUrl(url);
	        return true;
	    }

	    @Override
	    public void onPageFinished(WebView view, String url)
	    {
	    	super.onPageFinished(view, url);
	    	getActivity().setProgressBarIndeterminateVisibility(false);
	    }
	}
}
