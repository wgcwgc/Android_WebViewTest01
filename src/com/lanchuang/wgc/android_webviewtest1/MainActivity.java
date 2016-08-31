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
		// ����Ļ����Ϊȫ��
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN ,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// ȥ��������
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
		// �˷���������webview�д����Ӷ�������ת���ⲿ�����
		webView.setWebViewClient(new WebViewClient());

		WebSettings webSettings = webView.getSettings();
		// ֧��js�ű�
		webSettings.setJavaScriptEnabled(true);
		// ��ͼƬ�������ʺ�webview�Ĵ�С
		// webSettings.setUseWideViewPort(true);
		// ֧������
		// webSettings.setSupportZoom(true);
		// ֧���Զ�����ͼƬ
		// webSettings.setLoadsImagesAutomatically(true);
		// ֧�ֻ�ȡ���ƽ���
		webView.requestFocusFromTouch();

		webView.loadUrl(url);
	}

	@Override
	public boolean onKeyDown(int keyCode , KeyEvent event )
	{
		// ��дonKeyDown���������ҳ��WebView���Ժ���ʱִ�к��˲�����
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
