package com.example.administrator.newsdemo2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/5/19 0019.
 */
public class DetailActivity extends AppCompatActivity{

    private WebView webview;
    private Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detial);
        initView();
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        Toast.makeText(this, "url:"+url, Toast.LENGTH_SHORT).show();
        initTbs(url);
    }

    private void initView() {
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar action = getSupportActionBar();
        action.setDisplayHomeAsUpEnabled(true);
        action.setHomeAsUpIndicator(R.drawable.back_btn);

    }

    private void initTbs(String url) {
        webview= (WebView) findViewById(R.id.webview);
        webview.loadUrl(url);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                default:
        }
        return true;
    }
}
