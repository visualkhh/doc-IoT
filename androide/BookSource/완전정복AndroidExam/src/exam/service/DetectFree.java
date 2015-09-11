package exam.service;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class DetectFree extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.service_detectfree);
		
		Button btn = (Button)findViewById(R.id.brfree);
		btn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setAction("exam.service.FREEWIFI");
				sendBroadcast(intent);
			}
		});
	}
}