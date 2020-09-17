package com.bacter.residemenu.menu.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebView;

import com.bacter.residemenu.R;
import com.bacter.residemenu.menu.webclient.CCCWebClient;

public class CebuCityCouncil extends Activity
{
    private WebView ccc_webview;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cebu_city_council);

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Group Page....");
        progressDialog.setCancelable(false);

        ccc_webview = findViewById(R.id.ccc_webview);
        ccc_webview.requestFocus();
        ccc_webview.getSettings().setJavaScriptEnabled(true);
        ccc_webview.getSettings().setSupportMultipleWindows(true);
        ccc_webview.setWebViewClient(new CCCWebClient());
        ccc_webview.loadUrl("https://www.facebook.com/groups/CebuCityCouncil");
    }
    @Override
    public void onBackPressed()
    {
        if (ccc_webview.canGoBack())
        {
            ccc_webview.goBack();
        }
        else
            {
                super.onBackPressed();
            }
    }
}
