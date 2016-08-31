package com.lanchuang.wgc.android_webviewtest1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity
{
	WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState )
	{
		super.onCreate(savedInstanceState);
		// 将屏幕设置为全屏
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN ,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// 去掉标题栏
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		webView = (WebView) findViewById(R.id.wv_webview);
		loadWeb();

	}

	@SuppressLint("SetJavaScriptEnabled")
	private void loadWeb()
	{
		// String url = "http://cn.bing.com/?scope=web";
		String url = "file:///android_asset/guide/index.html";
		// 此方法可以在webview中打开链接而不会跳转到外部浏览器
		webView.setWebViewClient(new WebViewClient());

		WebSettings webSettings = webView.getSettings();
		// 支持js脚本
		webSettings.setJavaScriptEnabled(true);
		// 将图片调整到适合webview的大小
		// webSettings.setUseWideViewPort(true);
		// 支持缩放
		// webSettings.setSupportZoom(true);
		// 支持自动加载图片
		// webSettings.setLoadsImagesAutomatically(true);
		// 支持获取手势焦点
		webView.requestFocusFromTouch();

		webView.loadUrl(url);
	}

	@Override
	public boolean onKeyDown(int keyCode , KeyEvent event )
	{
		// 重写onKeyDown，当浏览网页，WebView可以后退时执行后退操作。
		if(keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack())
		{
			webView.goBack();
			return true;
		}
		return super.onKeyDown(keyCode ,event);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu )
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main ,menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item )
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if(id == R.id.action_settings)
		{
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
