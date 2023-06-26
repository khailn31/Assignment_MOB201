package khailnph29864.fpoly.assignment_mob201;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class NewsActivity extends AppCompatActivity {
WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        web=findViewById(R.id.web);
        Intent intent=getIntent();
        String link=intent.getStringExtra("link");
        web.loadUrl(link);
        web.setWebViewClient(new WebViewClient());
    }
}