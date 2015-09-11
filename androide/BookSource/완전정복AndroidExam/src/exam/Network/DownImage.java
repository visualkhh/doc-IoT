package exam.Network;

import java.io.*;
import java.net.*;

import android.app.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class DownImage extends Activity {
	ImageView img;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.network_downimage);

		img = (ImageView)findViewById(R.id.result);

		Button btndraw = (Button)findViewById(R.id.draw);
		btndraw.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				String imageurl = "http://www.winapi.co.kr/data/child2.jpg";
				try {
					InputStream is = new URL(imageurl).openStream();
					Bitmap bit = BitmapFactory.decodeStream(is);
					img.setImageBitmap(bit);
					is.close();
				} catch (Exception e) {;}
			}
		});

		Button btndown = (Button)findViewById(R.id.down);
		btndown.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				String imageurl = "http://www.winapi.co.kr/data/child3.jpg";
				int idx = imageurl.lastIndexOf('/');
				String localimage = imageurl.substring(idx + 1);
				String path = Environment.getDataDirectory().getAbsolutePath();
				path += "/data/exam.Network/files/" + localimage;

				if (new File(path).exists() == false) {
					DownloadImage(imageurl, localimage);
				}

				Bitmap bitmap = BitmapFactory.decodeFile(path);
				img.setImageBitmap(bitmap);
			}
		});
	}
	
	boolean DownloadImage(String Url, String FileName) {
		URL imageurl;
		int Read;
		try {
			imageurl = new URL(Url);
			HttpURLConnection conn= (HttpURLConnection)imageurl.openConnection();
			int len = conn.getContentLength();
			byte[] raster = new byte[len];
			InputStream is = conn.getInputStream();
			FileOutputStream fos = openFileOutput(FileName, 0);

			for (;;) {
				Read = is.read(raster);
				if (Read <= 0) {
					break;
				}
				fos.write(raster,0, Read);
			}

			is.close();
			fos.close();
			conn.disconnect();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}

