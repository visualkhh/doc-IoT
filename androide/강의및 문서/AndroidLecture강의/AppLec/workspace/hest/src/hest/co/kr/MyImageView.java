package hest.co.kr;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MyImageView extends Activity {

	ImageView iv;
	ImageButton imgBtn;

	int num = 1;
	private void loadImages() {
		try {
			URL url = new URL("http://okgosu.net/pds/blackgg/" + num + ".jpg");
			URLConnection conn = url.openConnection();
			conn.connect();
			BufferedInputStream bis = new BufferedInputStream(conn
					.getInputStream());
			Bitmap bm = BitmapFactory.decodeStream(bis);
			bis.close();
			iv.setImageBitmap(bm);
			num++;
			if (num > 9)
				num = 1;
		} catch (IOException e) {
			Log.w("okgosu", e);
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_image_view);
		imgBtn = (ImageButton) findViewById(R.id.imgBtn);
		iv = (ImageView) findViewById(R.id.img);
		iv.setImageResource(R.drawable.s_9);
		//iv.setImageResource(getResources().getIdentifier("snk01", "drawable", "hest.co.kr"));
		final WallpaperManager wallpaperManager = WallpaperManager
				.getInstance(this);
		iv.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				loadImages();
				return false;
			}
		});
		imgBtn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				iv.setDrawingCacheEnabled(true);
				try {
					wallpaperManager.setBitmap(iv.getDrawingCache());
					finish();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

	}
}
