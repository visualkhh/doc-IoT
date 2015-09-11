package exam.service;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class NewsController extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.service_newscontroller);
		
		Button btnstart = (Button)findViewById(R.id.newsstart);
		btnstart.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(NewsController.this, NewsService.class);
				startService(intent);
			}
		});

		Button btnend = (Button)findViewById(R.id.newsend);
		btnend.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(NewsController.this, NewsService.class);
				stopService(intent);
			}
		});
	}
}