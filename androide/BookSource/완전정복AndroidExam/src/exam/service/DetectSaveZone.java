package exam.service;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class DetectSaveZone extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.service_detectsavezone);
		
		Button btn = (Button)findViewById(R.id.brsavezone);
		btn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				v.postDelayed(new Runnable() {
					public void run() {
						Intent intent = new Intent();
						intent.setAction("exam.service.SAVEZONE");
						sendBroadcast(intent);
					}
				}, 10000);
			}
		});
	}
}