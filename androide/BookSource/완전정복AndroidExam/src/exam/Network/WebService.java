package exam.Network;

import java.io.*;
import java.net.*;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class WebService extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.network_downhtml);

		Button btn = (Button)findViewById(R.id.down);
		btn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				String xml;
				String url;
				String name = "jennifer";
				int count = 2;
				url = "http://twitter.com/statuses/user_timeline.xml?screen_name=" +
					name + "&count=" + count;
				xml = DownloadHtml(url); 
				EditText result = (EditText)findViewById(R.id.result);
				result.setText(xml);
			}
		});
	}
	
	String DownloadHtml(String addr) {
		StringBuilder html = new StringBuilder(); 
		try {
			URL url = new URL(addr);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			if (conn != null) {
				conn.setConnectTimeout(10000);
				conn.setUseCaches(false);
				if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
					BufferedReader br = new BufferedReader(
							new InputStreamReader(conn.getInputStream()));
					for (;;) {
						String line = br.readLine();
						if (line == null) break;
						html.append(line + '\n'); 
					}
					br.close();
				}
				conn.disconnect();
			}
		} 
		catch (Exception ex) {;}
		return html.toString();
	}
}

