package com.zoutexlexba.miage.tpandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Selection of the web client and declaration fot eh web-view.
        WebView webView = new WebView(this);
        webView.setWebChromeClient(new WebChromeClient());
        
        //Param. to enable Javascript and the ability to zoom.
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        
        //Load the subcited URL on the smartphone's screen
        webView.loadUrl("https://developer.android.com/index.html");

        //Enable|set the view
        setContentView(webView);
    }
}
