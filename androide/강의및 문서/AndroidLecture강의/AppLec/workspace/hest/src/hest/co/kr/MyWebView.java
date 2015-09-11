package hest.co.kr;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MyWebView extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_web_view);
		Button btn_go = (Button) findViewById(R.id.go_button);
		btn_go.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				WebView browser = (WebView) findViewById(R.id.webkit);
				EditText ed = (EditText) findViewById(R.id.url);
				browser.loadUrl(ed.getText().toString());
				browser.setWebViewClient(new WebViewClient() {
					public boolean shouldOverrideUrlLoading(WebView view,
							String url) {
						view.loadUrl(url);
						return true;
					}
				});
			}
		});
	}
}
