package exam.Network;

import java.io.*;
import java.net.*;

import org.apache.http.*;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.*;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class DownHtml extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.network_downhtml);

		Button btn = (Button)findViewById(R.id.down);
		btn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				String html;
				html = DownloadHtml("http://www.google.com"); 
				EditText result = (EditText)findViewById(R.id.result);
				result.setText(html);
			}
		});
	}

	/* 자바의 네트워크 클래스 사용
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
	//*/

	//* 아파치 클래스 사용
	String DownloadHtml(String addr) {
		HttpGet httpget = new HttpGet(addr);
		DefaultHttpClient client = new DefaultHttpClient();
		StringBuilder html = new StringBuilder(); 
		try {
			HttpResponse response = client.execute(httpget);
			BufferedReader br = new BufferedReader(new 
					InputStreamReader(response.getEntity().getContent()));
			for (;;) {
				String line = br.readLine();
				if (line == null) break;
				html.append(line + '\n'); 
			}
			br.close();
		} 
		catch (Exception e) {;}
		return html.toString();
	}
	//*/
}

