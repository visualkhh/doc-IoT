package exam.activity;

import java.io.*;

import android.app.*;
import android.content.*;
import android.net.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class CallOther extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_callother);

		findViewById(R.id.web).setOnClickListener(mClickListener);
		findViewById(R.id.dial).setOnClickListener(mClickListener);
		findViewById(R.id.picture).setOnClickListener(mClickListener);
		findViewById(R.id.other).setOnClickListener(mClickListener);
	}

	Button.OnClickListener mClickListener = new View.OnClickListener() {
		public void onClick(View v) {
			Intent intent;
			switch (v.getId()) {
			case R.id.web:
				intent = new Intent(Intent.ACTION_VIEW, 
						Uri.parse("http://www.google.com"));
				startActivity(intent); 
				break;
			case R.id.dial:
				intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:015-123-4567"));
				startActivity(intent);
				break;
			case R.id.picture:
				intent = new Intent(Intent.ACTION_VIEW);
				Uri uri = Uri.fromFile(new File("/sdcard/test.jpg"));
				intent.setDataAndType(uri, "image/jpeg");
				startActivity(intent);
				break;
			case R.id.other:
				intent = new Intent(Intent.ACTION_MAIN);
				intent.setComponent(new ComponentName("exam.Input",	"exam.Input.Input"));
				//intent.setClassName("exam.Input",	"exam.Input.Input");
				startActivity(intent);
				break;
			}
		}
	};
}
