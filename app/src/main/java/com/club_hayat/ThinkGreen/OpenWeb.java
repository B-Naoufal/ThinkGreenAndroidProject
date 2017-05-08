package com.club_hayat.ThinkGreen;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.club_hayat.ThinkGreen.Custom.lifecycle;

public class OpenWeb extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Adds Progrss bar Support
        this.getWindow().requestFeature(Window.FEATURE_PROGRESS);
        // Makes Progress bar Visible
        getWindow().setFeatureInt( Window.FEATURE_PROGRESS, Window.PROGRESS_VISIBILITY_ON);
        setContentView(R.layout.activity_open_web);
        getWindow().setFeatureInt( Window.FEATURE_PROGRESS, Window.PROGRESS_VISIBILITY_ON);
        Intent svc=new Intent(this, BackgroundSoundService.class);
        startService(svc);
        final WebView webView = (WebView)findViewById(R.id.WV);
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setUseWideViewPort(true);
        webView.setInitialScale(10);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        final Activity MyActivity = this;

        webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress)
            {
                //Make the bar disappear after URL is loaded, and changes string to Loading...
                MyActivity.setProgress(progress * 100);
               // ImageView imgView = (ImageView)findViewById(R.id.loading_data);
               // imgView .setVisibility(View.VISIBLE); //Make the bar disappear after URL is loaded
               ProgressBar Pb = (ProgressBar)findViewById(R.id.progressBar);
                Pb.setVisibility(ProgressBar.VISIBLE);
                webView .setVisibility(WebView.GONE);
                // Return the app name after finish loading
                if(progress == 100){
                   // imgView .setVisibility(ImageView.GONE);
                    Pb.setVisibility(ProgressBar.GONE);
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
                ImageView imgView = (ImageView)findViewById(R.id.internet_error);
                imgView .setVisibility(View.VISIBLE);
                webView .setVisibility(WebView.GONE);
            }

            if(errCode == -14) {
                final String mimeType = "text/html";
                final String encoding = "UTF-8";
                String html = "< />";
                webView.loadDataWithBaseURL("", html, mimeType, encoding, "");
                ImageView imgView = (ImageView)findViewById(R.id.internet_error);
                imgView .setVisibility(View.VISIBLE);
                webView .setVisibility(WebView.GONE);
            }

        }
        });
        webView.loadUrl("https://www.bquad.mu/ecological-footprint/questionnaire.php?action=repas");
    }
    @Override
    protected void onResume() {
        super.onResume();
        lifecycle.activityResumed();
        Intent svc=new Intent(this, BackgroundSoundService.class);
        startService(svc);

    }

    @Override
    protected void onPause() {
        super.onPause();
        lifecycle.activityPaused();
        Intent svc=new Intent(this, BackgroundSoundService.class);
        stopService(svc);

    }



}
