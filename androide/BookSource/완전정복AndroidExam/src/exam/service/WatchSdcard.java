package exam.service;

import android.app.*;
import android.content.*;
import android.os.*;
import android.widget.*;
import exam.AndroidExam.*;

/*
스킴을 file로 지정해야 방송된다. 이유는 아직 조사중이다.
매니페스트에 리시버를 등록할 때는 액션명을 실제 문자열로 적어야 한다. 

 */
public class WatchSdcard extends Activity {
	TextView mStatus;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.service_watchsdcard);

		mStatus = (TextView)findViewById(R.id.status);
	}

	public void onResume() {
		super.onResume();

		IntentFilter filter = new IntentFilter();
		filter.addAction(Intent.ACTION_MEDIA_MOUNTED);
		filter.addAction(Intent.ACTION_MEDIA_REMOVED);
		filter.addAction(Intent.ACTION_MEDIA_UNMOUNTED);
		filter.addAction(Intent.ACTION_MEDIA_EJECT);
		filter.addAction(Intent.ACTION_MEDIA_NOFS);
		filter.addDataScheme("file");
		registerReceiver(mBRSdcard, filter);
	}	

	public void onPause() {
		super.onPause();        
		unregisterReceiver(mBRSdcard);
	}

	BroadcastReceiver mBRSdcard = new BroadcastReceiver() {
		int Count = 0;
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			Count++;
			String str = String.format("수신 회수:%d, 위치:%s", Count, intent.getData().toString());
			mStatus.setText(str);
			if (action.equals(Intent.ACTION_MEDIA_MOUNTED)) {
				boolean readonly = intent.getBooleanExtra("read-only", false);
				String mount = "미디어 장착 : " + (readonly ? "읽기 전용":"읽기 쓰기 가능");
				Toast.makeText(context, mount, Toast.LENGTH_SHORT).show();
			}
			if (action.equals(Intent.ACTION_MEDIA_REMOVED)) {
				Toast.makeText(context, "미디어 분리", Toast.LENGTH_SHORT).show();
			}
			if (action.equals(Intent.ACTION_MEDIA_UNMOUNTED)) {
				Toast.makeText(context, "미디어 잘못된 위치에 장착", Toast.LENGTH_SHORT).show();
			}
			if (action.equals(Intent.ACTION_MEDIA_EJECT)) {
				Toast.makeText(context, "미디어 제거 요청", Toast.LENGTH_SHORT).show();
			}
			if (action.equals(Intent.ACTION_MEDIA_NOFS)) {
				Toast.makeText(context, "미디어 인식 안됨", Toast.LENGTH_SHORT).show();
			}
		}
	};
}