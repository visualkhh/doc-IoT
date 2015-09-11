package exam.Input;

import android.app.*;
import android.media.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.widget.*;
import exam.AndroidExam.*;

public class LogTest extends Activity {
	private static final String TAG = "LogTest";

    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.input_logtest);
		
		Log.v(TAG,"onCreate");

		findViewById(R.id.btn1).setOnClickListener(mClickListener);
		findViewById(R.id.btn2).setOnClickListener(mClickListener);
	}

	public void onDestroy() {
		super.onDestroy();
		Log.v(TAG,"onDestroy");
	}

	Button.OnClickListener mClickListener = new Button.OnClickListener() {
		public void onClick(View v) {
			MediaPlayer player;
			switch (v.getId()) {
			case R.id.btn1:
				Log.v(TAG,"First Button Pressed");
				break;
			case R.id.btn2:
				Log.v(TAG,"Second Button Pressed");
				break;
			}
		}
	};
}
	
