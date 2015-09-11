package exam.service;

import android.app.*;
import android.content.*;
import android.os.*;
import android.widget.*;
import exam.AndroidExam.*;

public class OnSaveZone extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.service_onsavezone);
	}
	
	public void onResume() {
		super.onResume();
		IntentFilter filter = new IntentFilter();
		filter.addAction("exam.service.SAVEZONE");
		registerReceiver(mSaveZoneBR, filter);
	}
	
	public void onPause() {
		super.onPause();
		unregisterReceiver(mSaveZoneBR);
	}

	BroadcastReceiver mSaveZoneBR = new BroadcastReceiver() {
		public void onReceive(Context context, Intent intent) {
			Toast.makeText(context, "아싸! 공짜다.", 
					Toast.LENGTH_LONG).show();
		}
	};
}