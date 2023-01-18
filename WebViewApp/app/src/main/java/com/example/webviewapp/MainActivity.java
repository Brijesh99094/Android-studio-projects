package com.example.webviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnBrowser ,btnWeb,btnHtml;
    EditText editUrl;
    ProgressBar webProgress;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBrowser = (Button) findViewById(R.id.btnBrowser);
        btnWeb = (Button) findViewById(R.id.btnWeb);
        btnHtml = (Button) findViewById(R.id.btnHtml);
        editUrl = (EditText) findViewById(R.id.editUrl);
        webProgress = (ProgressBar) findViewById(R.id.webProgress);
        webView = (WebView) findViewById(R.id.webView);

        btnBrowser.setOnClickListener(this);
        btnHtml.setOnClickListener(this);
        btnWeb.setOnClickListener(this);

        //enabling settings
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);


        //setting the visiblity of the progressbar default none
        webProgress.setVisibility(View.GONE);

        // creating client on your web view
        WebViewClient webViewClient = new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                webProgress.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                webProgress.setVisibility(View.GONE);
            }
        };
        webView.setWebViewClient(webViewClient);



        WebChromeClient webChromeClient = new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                webProgress.setVisibility(newProgress);
            }
        };
        webView.setWebChromeClient(webChromeClient);
    }

        @Override
        public void onClick(View view) {
                if(!(editUrl.getText().toString().startsWith("http://") || editUrl.getText().toString().startsWith("https://"))) {
                    editUrl.setText("http://"+editUrl.getText().toString());
                }
                switch(view.getId()){
                    case R.id.btnWeb:
                        // add this in manifest file when you get the eror in the web view
                        //net::CLEARTEXT_NOT_PERMITTED
                        // android:usesCleartextTraffic="true"
                        webView.loadUrl(editUrl.getText().toString());
                        break;
                    case R.id.btnBrowser:
                        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(editUrl.getText().toString()));
                        startActivity(i);
                        break;
                    case R.id.btnHtml:
                        try {
                            // we  have to create our assets inside src/main/create folder named assets
                            InputStream is = getAssets().open("demo.html");
                            BufferedReader br = new BufferedReader(new InputStreamReader(is));
                            String line ="";
                            String data = "";
                            while((line=br.readLine()) != null){
                                data += line;
                            }
                            webView.loadData(data,"text/html","utf-8");
                        }catch (IOException e){ e.printStackTrace(); }

                }
            }
    }