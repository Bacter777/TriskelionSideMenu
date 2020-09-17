package com.bacter.residemenu.menu.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bacter.residemenu.R;

public class CebuCityCouncil extends Fragment
{
    WebView ccc_webview;
    public CebuCityCouncil() {
        // Required empty public constructor
    }
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.cebu_city_council, container, false);

        ccc_webview = (WebView)view.findViewById(R.id.ccc_webview);
        ccc_webview.getSettings().setJavaScriptEnabled(true);
        ccc_webview.loadUrl("https://www.facebook.com/groups/CebuCityCouncil");
        ccc_webview.setWebViewClient(new WebViewClient()
        {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view,String uri)
            {
                view.loadUrl(uri);
                return false;
            }
        });
        return view;
    }
}