package com.club_hayat.ThinkGreen;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.Toast;

public class About_Us extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Adds Progrss bar Support
        this.getWindow().requestFeature(Window.FEATURE_PROGRESS);
        // Makes Progress bar Visible
        getWindow().setFeatureInt( Window.FEATURE_PROGRESS, Window.PROGRESS_VISIBILITY_ON);
        setContentView(R.layout.activity_about__us);
        final WebView webView = (WebView)findViewById(R.id.WV);
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setUseWideViewPort(true);
        webView.setInitialScale(10);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);

        // webView.loadUrl("http://www.e-graine.org/calculateur/?page_url=http%3A%2F%2Fdev.limpideagency.com%2Fegraine%2Flempreinte-ecologique-en-bd%2F");
        final Activity MyActivity = this;

        webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress)
            {
                //Make the bar disappear after URL is loaded, and changes string to Loading...
                MyActivity.setProgress(progress * 100);
                // ImageView imgView = (ImageView)findViewById(R.id.loading_data);
                // imgView .setVisibility(View.VISIBLE); //Make the bar disappear after URL is loaded
                webView .setVisibility(WebView.GONE);

                // Return the app name after finish loading
                if(progress == 100){
                    ImageView image = (ImageView) findViewById(R.id.bnf);
                    // imgView .setVisibility(ImageView.GONE);
                    image.setVisibility(ImageView.GONE);
                    View backk = findViewById(R.id.activity_about__us);
                    backk.setBackgroundColor(Color.TRANSPARENT);
                    webView .setVisibility(WebView.VISIBLE);
                }
            }

        });
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, int errCode, String errDescription, String failingUrl ) {

                try {
                    view.stopLoading();
                }
                catch(Exception e){}
                view.clearView();

                Toast.makeText(getApplicationContext(), " Please Enable your Internet Connection & try again", Toast.LENGTH_SHORT).show();
                if(errCode == -2 || errCode == -8) {
                    final String mimeType = "text/html";
                    final String encoding = "UTF-8";
                    String html = "< />";
                    webView.loadDataWithBaseURL("", html, mimeType, encoding, "");
                }

                if(errCode == -14) {
                    final String mimeType = "text/html";
                    final String encoding = "UTF-8";
                    String html = "< />";
                    webView.loadDataWithBaseURL("", html, mimeType, encoding, "");
                }

            }
        });
        ImageView image = (ImageView) findViewById(R.id.bnf);
        image.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                webView.loadUrl("https://www.linkedin.com/in/brahmi-naoufal-577710107");

            }

        });

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        final WebView webView = (WebView)findViewById(R.id.WV);
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (webView.canGoBack()) {
                        webView.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }

    }

