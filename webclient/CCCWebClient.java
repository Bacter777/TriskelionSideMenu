package com.bacter.residemenu.menu.webclient;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class CCCWebClient extends WebViewClient
{
    @Override
    public boolean shouldOverrideUrlLoading(WebView view,String url)
    {
        String hostname;
        hostname = "https://www.facebook.com/groups/CebuCityCouncil";

        Uri uri = Uri.parse(url);
        if (url.startsWith("file") || uri.getHost() != null && uri.getHost().endsWith(hostname))
        {
            return false;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(url));
        view.getContext().startActivity(intent);
        return true;
    }
}
